package ejercicio_13;

/**
 *
 * @author RODRIGO
 */
public class Usuario {
    private String nombre;
    private String email;
    
    public Usuario (String nombre, String email){ //Constructor de atributos propios
        this.setNombre(nombre);
        this.setEmail(email);
    }
    
    private void setNombre(String nombre) { 
        if (validarString(nombre)){ 
            this.nombre = nombre; 
        } 
    } 
    private void setEmail(String email) { 
        if (validarString(email)){ 
            this.email = email; 
        } 
    } 

    @Override
    public String toString() {
        return "Usuario: " + nombre + " (Email: " + email + ")";
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
