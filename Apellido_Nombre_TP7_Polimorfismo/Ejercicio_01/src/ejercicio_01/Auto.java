package ejercicio_01;

/**
 *
 * @author RODRIGO
 */
public class Auto extends Vehiculo {
    private int cantidadPuertas; 
    
    public Auto (String marca, String modelo, int cantidadPuertas){
        super(marca, modelo);
        this.setCantidadPuertas(cantidadPuertas);
    }
    //Setters
    public void setCantidadPuertas(int cantidadPuertas) {
        if (cantidadPuertas >= 2 && cantidadPuertas <= 7){
        this.cantidadPuertas = cantidadPuertas;            
        }
    }
    //Métodos
    //Override del método para mostrar la info del auto
    @Override
    public String mostrarInfo(){
        return super.mostrarInfo() + ", Cantidad de puertas: " + cantidadPuertas;
    }
    
}