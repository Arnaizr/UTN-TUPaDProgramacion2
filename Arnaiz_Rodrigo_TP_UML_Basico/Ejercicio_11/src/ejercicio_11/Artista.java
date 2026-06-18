package ejercicio_11;

/**
 *
 * @author RODRIGO
 */
public class Artista {
    private String nombre;
    private String genero;
    
    public Artista (String nombre, String genero){ //Constructor de atributos propios
        this.setNombre(nombre);
        this.setGenero(genero);
    }
    
    private void setNombre(String nombre) { 
        if (validarString(nombre)){ 
            this.nombre = nombre; 
        } 
    } 
    private void setGenero(String genero) { 
        if (validarString(genero)){ 
            this.genero = genero; 
        } 
    } 

    @Override
    public String toString() {
        return "Artista: " + nombre + " (Genero: " + genero + ")";
    }
    
    
    
    
    //Validaciones 
    //Método para verificar que un String no esté vacío o en null 
    private static boolean validarString(String palabra) {
        boolean valido = true;
        if ((palabra == null) || (palabra.trim().equals(""))) { //Se eliminan espacios antes y delante del String y verifica que no esté vacío
        valido = false;
        System.out.println("ERROR: El campo no puede estar vacío.");
        }
        return valido;
        }
}
