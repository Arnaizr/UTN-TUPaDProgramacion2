package excepciones;

/**
 *
 * @author RODRIGO
 */
public class Persona {
    private int edad;
    
    
    public void ingresarEdad (int edad){
    if (edad < 0 || edad > 120){
        throw new EdadInvalidaException("La edad debe estar entre 0 y 120");
    }
    this.edad = edad;
    }

    public int getEdad() {
        return edad;
    }

}
