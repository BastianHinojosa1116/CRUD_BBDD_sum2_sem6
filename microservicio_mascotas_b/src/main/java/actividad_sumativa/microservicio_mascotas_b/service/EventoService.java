package actividad_sumativa.microservicio_mascotas_b.service;

import actividad_sumativa.microservicio_mascotas_b.model.Evento;


// Importamos la interfaz Repository para acceder a la base de datos
import actividad_sumativa.microservicio_mascotas_b.repository.EventoRepository;

// Importamos la excepción personalizada
import actividad_sumativa.microservicio_mascotas_b.exception.EventoNotFoundException;

// Importamos utilidades de Spring
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Importamos utilidades para listas
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@Service
public class EventoService {    
    private static final Logger log = LoggerFactory.getLogger(EventoService.class);
    @Autowired
    private EventoRepository repo;
     // -------------------- MÉTODOS -------------------------

        /**
         * Devuelve la lista completa de eventos desde la base de datos.
         * 
         * @return Lista de eventos obtenidas desde Oracle.
         */
        public List<Evento> obtenerTodos() {
            return repo.findAll();
    }

    public Evento obtenerPorId(Long id) {
        log.info("Buscando evento con ID: {}", id); // Agregar log aquí
        Evento evento = repo.findById(id)
                            .orElseThrow(() -> new EventoNotFoundException(id));
    
        log.info("Evento encontrado: {}", evento);  // Verifica si el evento se carga correctamente
        return evento;
    }
    

   
    public Evento agregar(Evento evento) {
            if (repo.existsById(evento.getId())) {
                // Si ya existe una película con ese ID, lanzamos una excepción
                throw new IllegalArgumentException("Ya existe un evento con el ID " + evento.getId());
            }
        
            // Si no existe, se guarda normalmente
            return repo.save(evento);
        }

    /**
     * Elimina un evento por su ID.
     * 
     * @param id ID del evento a eliminar.
     */
    public void eliminar(Long id) {
            if (!repo.existsById(id)) {
                    throw new EventoNotFoundException(id);
            }
            repo.deleteById(id);
    }

    /**
     * Actualiza un evento existente.
     * 
     * @param id            ID del evento a actualizar.
     * @param nuevaPelicula Datos nuevos del evento.
     * @return Evento actualizado.
     */
    public Evento actualizar(Long id, Evento nuevoEvento) {
        Evento existente = repo.findById(id)
                            .orElseThrow(() -> new EventoNotFoundException(id));

            // Actualizar campos
            existente.setTipo(nuevoEvento.getTipo());
            existente.setModalidad(nuevoEvento.getModalidad());
            existente.setFecha(nuevoEvento.getFecha());
            existente.setLugar(nuevoEvento.getLugar());
            

            return repo.save(existente);
    }
   
}
