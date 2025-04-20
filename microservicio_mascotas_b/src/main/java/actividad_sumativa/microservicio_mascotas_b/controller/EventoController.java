package actividad_sumativa.microservicio_mascotas_b.controller;


import actividad_sumativa.microservicio_mascotas_b.model.Evento;
import actividad_sumativa.microservicio_mascotas_b.service.EventoService;

import actividad_sumativa.microservicio_mascotas_b.model.ResponseWrapper;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/evento")
public class EventoController {
    private final EventoService eventoService;

    public EventoController(EventoService eventoService) {
        this.eventoService = eventoService;
    }

    @GetMapping
    public ResponseEntity<?> obtenerTodas() {
        List<Evento> peliculas = eventoService.obtenerTodos();

        if (peliculas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No hay EVENTOS registradas actualmente");
        }

        ResponseWrapper<Evento> respuesta = new ResponseWrapper<>(
                "OK",
                peliculas.size(),
                peliculas);

        return ResponseEntity.ok(respuesta);
    }

    @GetMapping("/{id}")
public ResponseEntity<ResponseWrapper<Evento>> obtenerEventoPorId(@PathVariable Long id) {
    Evento evento = eventoService.obtenerPorId(id);
    ResponseWrapper<Evento> respuesta = new ResponseWrapper<>(
        "OK",
        1,
        List.of(evento)
    );
    return ResponseEntity.ok(respuesta);
}
    
    

    /**
     * aGREGAR un evento
     * Si no la encuentra, lanza una excepción personalizada capturada por el
     * GlobalExceptionHandler.
     */
    @PostMapping("/agregarEvento")
    public ResponseEntity<ResponseWrapper<Evento>> agregarEvento(@RequestBody Evento evento) {
        Evento nueva = eventoService.agregar(evento);

        ResponseWrapper<Evento> respuesta = new ResponseWrapper<>(
                "CREATED",
                1,
                List.of(nueva));

        return ResponseEntity.ok(respuesta);
    }

    /**
     * eliminar  un evento
     * Si no la encuentra, lanza una excepción personalizada capturada por el
     * GlobalExceptionHandler.
     */
    
    @DeleteMapping("/eliminarEvento/{id}")
    public ResponseEntity<ResponseWrapper<String>> eliminarEvento(@PathVariable Long id) {
        eventoService.eliminar(id);

        ResponseWrapper<String> respuesta = new ResponseWrapper<>(
                "Eliminado correctamente",
                1,
                List.of("Evento con ID " + id + " eliminado."));

        return ResponseEntity.ok(respuesta);
    }

    @PutMapping("/modificarEvento/{id}")
    public ResponseEntity<ResponseWrapper<Evento>> actualizarEvento(@PathVariable Long id,
            @RequestBody Evento pelicula) {
                Evento actualizada = eventoService.actualizar(id, pelicula);

        ResponseWrapper<Evento> respuesta = new ResponseWrapper<>(
                "Actualizado correctamente",
                1,
                List.of(actualizada));

        return ResponseEntity.ok(respuesta);
    }
    
    
   

}
