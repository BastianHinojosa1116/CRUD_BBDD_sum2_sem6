package actividad_sumativa.microservicio_enviosinter_d.controller;

import actividad_sumativa.microservicio_enviosinter_d.model.ResponseWrapper;
import actividad_sumativa.microservicio_enviosinter_d.service.EnvioService;
import actividad_sumativa.microservicio_enviosinter_d.model.Envio; // Si tienes la entidad Envio

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/envio")
public class EnvioController {

    private final EnvioService envioService;

    // Constructor con inyección de dependencia
    public EnvioController(EnvioService envioService) {
        this.envioService = envioService;
    }

    // Obtener todos los envíos
    @GetMapping
    public ResponseEntity<?> obtenerTodas() {

        List<Envio> envios = envioService.obtenerTodas();

        if (envios.isEmpty()) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No hay películas registradas actualmente");
        }

        return ResponseEntity.ok(
                new ResponseWrapper<>(
                        "OK",
                        envios.size(),
                        envios));
    }

    // Obtener envío por ID
    @GetMapping("/{id}")
    public Envio obtenerPorId(@PathVariable Long id) {

        return envioService.obtenerPorId(id);
    }

    @PutMapping("/actualizarEstado/{id}")
    public ResponseEntity<Envio> actualizarEstado(
            @PathVariable Long id,
            @RequestBody Map<String, String> body) {
        String nuevoEstado = body.get("estado");
        Envio envioActualizado = envioService.actualizar(id, nuevoEstado);
        return ResponseEntity.ok(envioActualizado);
    }

    // Agregar un nuevo envío
    @PostMapping("/agregarEnvio")
    public ResponseEntity<ResponseWrapper<Envio>> crearPelicula(@Valid @RequestBody Envio envio) {

        Envio creada = envioService.guardar(envio);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseWrapper<>(
                        "Envio creada exitosamente",
                        1,
                        List.of(creada)));
    }

    @DeleteMapping("/eliminarEnvio/{id}")
    public ResponseEntity<ResponseWrapper<Void>> eliminarEnvio(@PathVariable Long id) {

        envioService.eliminar(id);

        return ResponseEntity.ok(
                new ResponseWrapper<>(
                        "Envio eliminado exitosamente",
                        0,
                        null));
    }
}
