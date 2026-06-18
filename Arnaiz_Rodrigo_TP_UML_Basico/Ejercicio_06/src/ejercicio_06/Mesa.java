package ejercicio_06;

/**
 *
 * @author RODRIGO
 */
public class Mesa { 
    private int numero; 
    private int capacidad; 

    //Constructor con atributos propios 
    public Mesa(int numero, int capacidad){ 
    this.setNumero(numero); 
    this.setCapacidad(capacidad); 
    } 
    //Setters 
    private void setNumero(int numero) { 
        if (validarIntPositivo(numero)){ 
            this.numero = numero; 
        } 
    } 
    private void setCapacidad(int capacidad) { 
        if (validarIntPositivo(capacidad)){
            this.capacidad = capacidad; 
        } 
    } 
    
    @Override public String 
    toString() { return "Mesa: " + numero + " (capacidad: " + capacidad + ")";
    } 
    //Validaciones 
    //Método para validar que un int no sea negativo
    private static boolean validarIntPositivo(int num) {
        boolean valido = true;
        if (num <= 0) {
            valido = false;
            System.out.println("ERROR: El valor ingresado no puede ser negativo o cero.");
        }
        return valido;
    }
}