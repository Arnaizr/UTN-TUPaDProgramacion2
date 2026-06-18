package ejercicio_07;

/**
 *
 * @author RODRIGO
 */
public class Conductor { 
    private String nombre; 
    private String licencia; 
    private Vehiculo vehiculo; 

    //Constructor con atributos propios 
    public Conductor(String nombre, String licencia){ 
        this.setNombre(nombre); 
        this.setLicencia(licencia); 
    }
    //Getters
    public String getNombre(){ //Getter para salida de datos en toString de vehículo
        return nombre;
    }
    public Vehiculo getVehiculo(){ //Getter para asociacion bidireccional 
        return vehiculo;
    }
    //Setters 
    private void setNombre(String nombre) { 
        if (validarString(nombre)){ 
            this.nombre = nombre; 
        } 
    } 
    private void setLicencia(String licencia) { 
        if (validarString(licencia)){
            this.licencia = licencia; 
        } 
    } 
    public void setVehiculo(Vehiculo vehiculo) { //Setter bidireccional para vehiculo
        this.vehiculo = vehiculo;
        if (vehiculo != null && vehiculo.getConductor() != this) {
            vehiculo.setConductor(this);
        }
    }
    
    @Override public String 
    toString() { return "Conductor: " + nombre + " (licencia:  " + licencia + "), " + (vehiculo !=null ? "Vehiculo (patente): " + vehiculo.getPatente() : " Vehiculo: Sin datos");
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
