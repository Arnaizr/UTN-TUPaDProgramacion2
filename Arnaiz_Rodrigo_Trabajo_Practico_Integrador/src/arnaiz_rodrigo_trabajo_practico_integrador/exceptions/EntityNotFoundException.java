package arnaiz_rodrigo_trabajo_practico_integrador.exceptions;

/**
 *
 * @author RODRIGO
 */

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException() {
    }
    public EntityNotFoundException(String message) {
        super(message);
    }
    public EntityNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    public EntityNotFoundException(Throwable cause) {
        super(cause);
    }
}