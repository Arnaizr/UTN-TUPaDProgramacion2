package ejercicio_03;

/**
 *
 * @author RODRIGO
 */
public abstract class Empleado {
    protected final double SUELDO_BASE = 15000; 
    private String nombre;
    protected double sueldo;
    
    public Empleado (String nombre){
        this.setNombre(nombre);
    }

    private void setNombre(String nombre) {
        if (validarString(nombre)){
            this.nombre = nombre;
        }
    }
    
    public abstract void calcularSueldo();

    @Override
    public String toString() {
        return "Empleado{" + "nombre = " + nombre + ", sueldo = $" + String.format("%.2f",sueldo) + ", ";
    }
    
    
    
    //Validaciones 
    //Método para verificar que un String no esté vacío o en null 
    protected static boolean validarString(String palabra) {
        boolean valido = true;
        if ((palabra == null) || (palabra.trim().equals(""))) { //Se eliminan espacios antes y delante del String y verifica que no esté vacío
        valido = false;
        System.out.println("ERROR: El campo no puede estar vacío.");
        }
        return valido;
        }
}
