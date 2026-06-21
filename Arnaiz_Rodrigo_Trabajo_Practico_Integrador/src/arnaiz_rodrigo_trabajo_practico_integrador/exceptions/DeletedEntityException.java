package arnaiz_rodrigo_trabajo_practico_integrador.exceptions;

/**
 *
 * @author RODRIGO
 */
public class DeletedEntityException extends RuntimeException{

    public DeletedEntityException() {
    }

    public DeletedEntityException(String message) {
        super(message);
    }

    public DeletedEntityException(String message, Throwable cause) {
        super(message, cause);
    }

    public DeletedEntityException(Throwable cause) {
        super(cause);
    }
    
}
