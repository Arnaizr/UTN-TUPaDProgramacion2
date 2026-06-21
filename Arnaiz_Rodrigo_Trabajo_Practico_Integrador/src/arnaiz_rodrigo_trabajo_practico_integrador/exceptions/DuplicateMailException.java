package arnaiz_rodrigo_trabajo_practico_integrador.exceptions;

/**
 *
 * @author RODRIGO
 */
public class DuplicateMailException extends RuntimeException{

    public DuplicateMailException() {
    }

    public DuplicateMailException(String message) {
        super(message);
    }

    public DuplicateMailException(String message, Throwable cause) {
        super(message, cause);
    }

    public DuplicateMailException(Throwable cause) {
        super(cause);
    }
    
}
