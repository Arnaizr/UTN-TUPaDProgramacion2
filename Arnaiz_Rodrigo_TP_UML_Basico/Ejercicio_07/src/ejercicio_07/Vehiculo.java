package ejercicio_07;

/**
 *
 * @author RODRIGO
 */
public class Vehiculo { 
    private String patente; 
    private String modelo; 
    private Conductor conductor; 
    private Motor motor; 
    
    //Constructor con atributos propios y motor como agregacion 
    public Vehiculo(String patente, String modelo, Motor motor){ 
        this.setPatente(patente); 
        this.setModelo(modelo); 
        this.setMotor(motor); 
    }
    //Getters
    public String getPatente(){ //Getter para salida de datos en toString de cliente
        return patente;
    }
    public Conductor getConductor(){ //Getter para asociacion bidireccional 
        return conductor;
    }
    //Setters 
    private void setPatente(String patente) { 
        if (validarString(patente)){ 
            this.patente = patente; 
        } 
    } 
    private void setModelo(String modelo) { 
        if (validarString(modelo)){
            this.modelo = modelo; 
        } 
    } 
   private void setMotor(Motor motor) {
        if (motor != null){ 
            this.motor = motor; 
        }
    } 
    public void setConductor(Conductor conductor) { //Setter bidireccional para conductor
        this.conductor = conductor;
        if (conductor != null && conductor.getVehiculo() != this) {
            conductor.setVehiculo(this);
        }
    }
    
    @Override public String 
    toString() { return "Vehículo: " + modelo + " (patente:  " + patente + "), " + (conductor !=null ? "Conductor: " + conductor.getNombre() : " Conductor: Sin datos") + ", " + motor;
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

