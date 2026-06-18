package ejercicio_01;

/**
 *
 * @author RODRIGO
 */
public class Empleado {
    //Atributos
    private final int id;
    private String nombre;
    private String puesto;
    private double salario;
    private static int totalEmpleados = 0;
    
    //Constructores
    //Constructor principal (todos los parámetros)
    public Empleado(String nombre, String puesto, double salario){
        totalEmpleados++; //Se incrementa el contador de empleados
        this.id = totalEmpleados; //Se utiliza el contador de empleados para asignar el ID de cada empleado
        this.setNombre(nombre); //Se llama al setter para cargar el nombre
        this.setPuesto(puesto); //Se llama al setter para cargar el puesto
        this.setSalario(salario); //Se llama al setter para cargar el salario
        
    }
    //Constructor secundario
    public Empleado(String nombre, String puesto){
        this(nombre, puesto, 300000); //Se crea el objeto con un salario predeterminado
    }
    
    //Getters y setters

    public void setNombre(String nombre) { 
        if (validarString(nombre)) {       
            this.nombre = nombre;
            return;
        }
        this.nombre = "Para cargar";
    }

    public void setPuesto(String puesto) {
        if (validarString(puesto)){
            this.puesto = puesto;
            return;
        }
        this.puesto = "A designar";
    }

    public void setSalario(double salario) {
        if (validarDoublePositivo(salario)) {
            this.salario = salario;
        }
    }
    
    private static int getTotalEmpleados() {
        return totalEmpleados;
    }
    //Se dejó únicamente el getter de TotalEmpleados dado que los demás atributos se muestran por toString
    
    //Métodos
    //Método para incrementar el salario del Empleado con un porcentaje
    public void actualizarSalario(double porcentaje) { 
        if (validarDoublePositivo(porcentaje)) { //Si el porcentaje es positivo se actualiza el salario del empleado
            this.salario += salario * porcentaje / 100;
            System.out.println("Se ha incrementado el salario de " + nombre + " en un " + porcentaje + "%");
            return;
        }
        System.out.println("No se pudo actualizar el salario de " + nombre + " con el valor " + porcentaje + ".");
    }
    //Método para incrementar el salario del empleado con un monto fijo
    public void actualizarSalario(int monto) { 
        if (validarIntPositivo(monto)) { //Si el monto es positivo se actualiza el salario del empleado
            this.salario += monto;
            System.out.println("Se ha incrementado el salario de " + nombre + " en $" + monto + ".");
            return;
        }
        System.out.println("No se pudo actualizar el salario de " + nombre + " con el valor " + monto + ".");
    }
    public static int mostrarTotalEmpleados () {
        return getTotalEmpleados();
        }
    
    @Override
    public String toString() {
        return "Empleado {" + "Id = " + id + ", Nombre = " + nombre + ", Puesto = " + puesto + ", Salario = $" + salario + '}';
    }
    
    //Validadores
    private static boolean validarString(String palabra) {
        boolean valido = true;
        if ((palabra == null) || (palabra.trim().equals(""))) { //Se eliminan espacios antes y delante del String y verifica que no esté vacío
            valido = false;
            System.out.println("ERROR: El campo no puede estar vacío.");
        }
        return valido;
    }
    private static boolean validarDoublePositivo (double num) {
        boolean positivo = true;
        if (num < 0){
            positivo = false;
            System.out.println("ERROR: El valor ingresado debe ser mayor o igual a cero.");
        }
    return positivo;
    }
    private static boolean validarIntPositivo(int num) {
        boolean valido = true;
        if (num < 0) {
            valido = false;
            System.out.println("ERROR: El valor ingresado no puede ser negativo.");
        }
        return valido;
    }
}
