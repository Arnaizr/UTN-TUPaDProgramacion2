package arnaiz_rodrigo_trabajo_practico_integrador.exceptions;

/**
 *
 * @author RODRIGO
 */
public class EntityNotEmptyException extends RuntimeException{

    public EntityNotEmptyException() {
    }

    public EntityNotEmptyException(String message) {
        super(message);
    }

    public EntityNotEmptyException(String message, Throwable cause) {
        super(message, cause);
    }

    public EntityNotEmptyException(Throwable cause) {
        super(cause);
    }
    
}
