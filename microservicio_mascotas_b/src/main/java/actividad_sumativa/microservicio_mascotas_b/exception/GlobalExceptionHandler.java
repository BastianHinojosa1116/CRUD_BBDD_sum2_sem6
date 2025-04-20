package actividad_sumativa.microservicio_mascotas_b.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;



import actividad_sumativa.microservicio_mascotas_b.model.ResponseWrapper;
import java.util.List;

/**
 * Manejador global de excepciones para toda la aplicación.
 * Usa ResponseWrapper para mantener consistencia en las respuestas.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Captura cuando un evento no se encuentra (ID inválido).
     */
    @ExceptionHandler(EventoNotFoundException.class)
    public ResponseEntity<ResponseWrapper<String>> manejarEventoNoEncontrado(EventoNotFoundException ex) {
        ResponseWrapper<String> respuesta = new ResponseWrapper<>(
                "NOT FOUND",
                0,
                List.of(ex.getMessage())
        );
        return new ResponseEntity<>(respuesta, HttpStatus.NOT_FOUND);
    }

    /**
     * Captura errores de argumentos inválidos, por ejemplo al intentar agregar
     * un evento con un ID ya existente.
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ResponseWrapper<String>> manejarArgumentoInvalido(IllegalArgumentException ex) {
        ResponseWrapper<String> respuesta = new ResponseWrapper<>(
                "BAD REQUEST",
                0,
                List.of(ex.getMessage())
        );
        return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
    }

    /**
     * Captura cualquier otra excepción no controlada (500).
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseWrapper<String>> manejarExcepcionGeneral(Exception ex) {
        ResponseWrapper<String> respuesta = new ResponseWrapper<>(
                "INTERNAL SERVER ERROR",
                0,
                List.of("Ha ocurrido un error inesperado. Intenta más tarde.")
        );
        return new ResponseEntity<>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
