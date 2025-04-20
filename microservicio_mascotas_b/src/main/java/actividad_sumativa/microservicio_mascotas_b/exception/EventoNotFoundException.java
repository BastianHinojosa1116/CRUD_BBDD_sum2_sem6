package actividad_sumativa.microservicio_mascotas_b.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND) // Devuelve automáticamente un código 404 al lanzarse
public class EventoNotFoundException extends RuntimeException {

    /**
     * Constructor de la excepción.
     * Recibe el ID que el usuario buscó y no fue encontrado.
     * 
     * @param id ID del evento que no existe.
     */
    public EventoNotFoundException(Long id) {
        // Generamos un mensaje personalizado que luego será visible en la respuesta de error
        super("El evento con id " + id + " no fue encontrado");
    }
}
