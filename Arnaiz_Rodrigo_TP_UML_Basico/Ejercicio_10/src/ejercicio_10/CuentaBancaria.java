package ejercicio_10;

/**
 *
 * @author RODRIGO
 */
public class CuentaBancaria {
    private String cbu; 
    private double saldo; 
    private Titular titular;
    private ClaveSeguridad claveSeguridad;

    //Constructor con atributos propios y atributos para clave de seguridad
    public CuentaBancaria(String cbu, double saldo, String codigo, String ultimaModificacion){ 
        this.setCbu(cbu); 
        this.setSaldo(saldo); 
        this.claveSeguridad = new ClaveSeguridad(codigo, ultimaModificacion);
    }
    //Getters
    public String getCbu(){ //Getter para salida de datos en toString de vehículo
        return cbu;
    }
    public Titular getTitular(){ //Getter para asociacion bidireccional 
        return titular;
    }
    //Setters 
    private void setCbu(String cbu) { 
        if (validarString(cbu)){ 
            this.cbu = cbu; 
        } 
    } 
    private void setSaldo(double saldo) { 
        if (validarDoublePositivo(saldo)){
            this.saldo = saldo; 
        } 
    } 
    public void setTitular(Titular titular) { //Setter bidireccional para titular
        this.titular = titular;  
        if (titular != null && titular.getCuentaBancaria() != this) {
            titular.setCuentaBancaria(this);
        }
    }
    
    @Override public String toString() { 
        return "Cuenta (CBU): " + cbu + " (Saldo:  $" + String.format("%.2f" , saldo) + "), " + 
               (titular !=null ? "Titular: " + titular.getNombre() : " Titular: Sin datos") + ", " + claveSeguridad;
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
