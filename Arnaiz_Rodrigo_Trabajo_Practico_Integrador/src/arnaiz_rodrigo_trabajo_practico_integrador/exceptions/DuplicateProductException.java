package arnaiz_rodrigo_trabajo_practico_integrador.exceptions;

/**
 *
 * @author RODRIGO
 */
public class DuplicateProductException extends RuntimeException{

    public DuplicateProductException() {
    }

    public DuplicateProductException(String message) {
        super(message);
    }

    public DuplicateProductException(String message, Throwable cause) {
        super(message, cause);
    }

    public DuplicateProductException(Throwable cause) {
        super(cause);
    }
    
}
