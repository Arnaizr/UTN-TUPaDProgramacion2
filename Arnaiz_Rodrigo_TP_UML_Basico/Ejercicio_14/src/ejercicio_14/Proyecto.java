package ejercicio_14;

/**
 *
 * @author RODRIGO
 */
public class Proyecto {
    private String nombre;
    private double duracionMin;
    
    public Proyecto (String nombre, double duracionMin){ //Constructor de atributos propios
        this.setNombre(nombre);
        this.setDuracionMin(duracionMin);
    }
    
    private void setNombre(String nombre) { 
        if (validarString(nombre)){ 
            this.nombre = nombre; 
        } 
    } 
    private void setDuracionMin(double duracionMin) { 
        if (validarDoublePositivo(duracionMin)){ 
            this.duracionMin = duracionMin; 
        } 
    } 

    @Override
    public String toString() {
        return "Proyecto: " + nombre + " (Duracion: " + duracionMin + ")";
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
    
    //Método para validar un double positivo
    private static boolean validarDoublePositivo (double num) {
        boolean positivo = true;
        if (num < 0){
            positivo = false;
            System.out.println("ERROR: El valor ingresado debe ser mayor o igual a cero.");
        }
    return positivo;
    }    
}
