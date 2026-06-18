package ejercicio_12;

/**
 *
 * @author RODRIGO
 */
public class Contribuyente {
    private String nombre;
    private String cuil;
    
    public Contribuyente (String nombre, String cuil){ //Constructor de atributos propios
        this.setNombre(nombre);
        this.setCuil(cuil);
    }
    
    private void setNombre(String nombre) { 
        if (validarString(nombre)){ 
            this.nombre = nombre; 
        } 
    } 
    private void setCuil(String cuil) { 
        if (validarString(cuil)){ 
            this.cuil = cuil; 
        } 
    } 

    @Override
    public String toString() {
        return "Contribuyente: " + nombre + " (Cuil: " + cuil + ")";
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
