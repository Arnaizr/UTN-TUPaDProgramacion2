package ejercicio_01;

/**
 *
 * @author RODRIGO
 */
public class Vehiculo {
    private String marca;
    private String modelo;
    
    //Setters
    public Vehiculo(String marca, String modelo){
        this.setMarca(marca);
        this.setModelo(modelo);
    }

    public void setMarca(String marca) {
        if (validarString (marca)){
        this.marca = marca;
    }
        
    }
    public void setModelo(String modelo) {
        if (validarString(modelo)){
        this.modelo = modelo;            
        }
    }
    //Métodos
    //Método para mostrar la info del vehículo
    public String mostrarInfo(){
        return "Marca: " + marca + ", Modelo: " + modelo;
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
