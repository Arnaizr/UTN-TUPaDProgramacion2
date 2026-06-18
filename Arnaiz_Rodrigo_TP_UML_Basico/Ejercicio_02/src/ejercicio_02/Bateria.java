package ejercicio_02;

/**
 *
 * @author RODRIGO
 */
public class Bateria {
    private String modelo;
    private int capacidad;
    
    public Bateria(String modelo, int capacidad){ //Constructor de atributos propios
        this.setModelo(modelo);
        this.setCapacidad(capacidad);
    }
    //Setters
    private void setModelo(String modelo){
        if (validarString(modelo)) {
            this.modelo = modelo;
        }
    }
    
    private void setCapacidad(int capacidad){
        if (validarIntPositivo(capacidad)) {
            this.capacidad = capacidad;
        }
    }
    //override de toString para mostrar atributos
    @Override
    public String toString() {
        return "modelo: " + modelo + ", capacidad: " + capacidad + " maH";
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
    //Métoddo para validar que un int no sea negativo
    private static boolean validarIntPositivo(int num) {
        boolean valido = true;
        if (num <= 0) {
            valido = false;
            System.out.println("ERROR: El valor ingresado no puede ser negativo.");
        }
        return valido;
    }
}
