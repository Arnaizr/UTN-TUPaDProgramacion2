package ejercicio_10;

/**
 *
 * @author RODRIGO
 */
public class Titular {
    private String nombre; 
    private String dni; 
    private CuentaBancaria cuentaBancaria; 

    //Constructor con atributos propios 
    public Titular(String nombre, String dni){ 
        this.setNombre(nombre); 
        this.setDni(dni); 
    }
    //Getters
    public String getNombre(){ //Getter para salida de datos en toString de cuenta bancaria
        return nombre;
    }
    public CuentaBancaria getCuentaBancaria(){ //Getter para asociacion bidireccional 
        return cuentaBancaria;
    }
    //Setters 
    private void setNombre(String nombre) { 
        if (validarString(nombre)){ 
            this.nombre = nombre; 
        } 
    } 
    private void setDni(String dni) { 
        if (validarString(dni)){
            this.dni = dni; 
        } 
    } 
    public void setCuentaBancaria(CuentaBancaria cuentaBancaria) { //Setter bidireccional para cuentaBancaria
        this.cuentaBancaria = cuentaBancaria;
        if (cuentaBancaria != null && cuentaBancaria.getTitular() != this) {
            cuentaBancaria.setTitular(this);
        }
    }
    
    @Override public String 
    toString() { return "Titular: " + nombre + " (DNI:  " + dni + "), " + (cuentaBancaria !=null ? "Cuenta (CBU): " + cuentaBancaria.getCbu() : " Cuenta: Sin datos");
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
