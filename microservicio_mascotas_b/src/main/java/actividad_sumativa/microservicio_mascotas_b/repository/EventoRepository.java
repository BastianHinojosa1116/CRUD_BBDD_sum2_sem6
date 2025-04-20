// Indica que esta clase pertenece al paquete repository
package actividad_sumativa.microservicio_mascotas_b.repository;

// -------------------- IMPORTACIONES -------------------------

// Importamos JPA Repository para que Spring genere el acceso a base de datos
import org.springframework.data.jpa.repository.JpaRepository;

// Importamos la entidad Evento
import actividad_sumativa.microservicio_mascotas_b.model.Evento;

// -------------------- INTERFAZ -------------------------

/**
 * Repositorio que permite realizar operaciones CRUD sobre la entidad Pelicula.
 * 
 * Al heredar de JpaRepository automáticamente Spring creará:
 * - findAll()
 * - findById()
 * - save()
 * - delete()
 * - y otros métodos útiles
 * 
 * Este repositorio conecta directamente con la tabla "peliculas" de Oracle.
 */


public interface EventoRepository extends JpaRepository<Evento, Long> {
    // Este repositorio debería permitirte consultar los eventos correctamente.
}
