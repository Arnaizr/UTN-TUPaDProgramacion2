package excepciones;

/**
 *
 * @author RODRIGO
 */
public class EdadInvalidaException extends RuntimeException{

    public EdadInvalidaException() {
    }

    public EdadInvalidaException(String message) {
        super(message);
    }

    public EdadInvalidaException(String message, Throwable cause) {
        super(message, cause);
    }

    public EdadInvalidaException(Throwable cause) {
        super(cause);
    }
    
}
