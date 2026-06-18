package ejercicio_04;

/**
 *
 * @author RODRIGO
 */
public class Producto {
    private String nombre;
    private double precioBase;
    private static double IVA = (21.0);
    //Constructores
    //Constructor principal (todos los parámetros)
    public Producto(String nombre, double precioBase){
        this.setNombre(nombre); //Se llama al setter para cargar el nombre
        this.setPrecioBase(precioBase); //Se llama al setter para cargar el precio base
    }
    //Constructor secundario
    public Producto(String nombre){
        this(nombre, 100); //Se crea el objeto con el precio predeterminado
    }
    //Getters y Setters
/*
    public String getNombre() {//La consigna no solicita generar getters, se dejan comentados los valores de devuelven por stringTo
        return nombre;
    }
*/
    public void setNombre(String nombre) {
        if (validarString(nombre)){
            this.nombre = nombre;
            return;
        }
        this.nombre = "*Pendiente de carga*";
    }
/*
    public double getPrecioBase() {//La consigna no solicita generar getters, se dejan comentados los valores de devuelven por stringTo
        return precioBase;
    }
*/
    private void setPrecioBase(double precioBase) {
        if (validarDoublePositivo(precioBase)){
            this.precioBase = precioBase;
            return;
        }
        this.precioBase = 100; //Si el valor es negativo se carga el monto predeterminado
    }
/*
    public static double getIVA() {//La consigna no solicita generar getters, se dejan comentados los valores de devuelven por stringTo
        return IVA;
    }
*/
    private static void setIVA(double IVA) {
        Producto.IVA = IVA;
    }
    
    //Override de toString
    @Override
    public String toString() {
        return "Producto{" + "Nombre = " + nombre + ", Precio Base = $" + String.format("%.2f", precioBase) + ", Precio Final = $" + String.format("%.2f", calcularPrecioFinal()) + '}';
    }
    
    
    
    //Métodos
    //Método para aplicar descuento con un porcentaje
    public void aplicarDescuento(double porcentaje){
        if (validarPorcentaje(porcentaje)) {
            precioBase = precioBase - (precioBase*porcentaje/100);
            System.out.println("Se ha aplicado un " + porcentaje + "% de descuento para " + nombre + ".");
        }
    }
    
    //Método para aplicar descuento con porcentaje y tope mínimo
    public void aplicarDescuento(double porcentaje, double precioMinimo){
        if ((validarPorcentaje(porcentaje)) && (validarPrecioMinimo(precioMinimo, precioBase))) {
            double precioConDescuento = precioBase - (precioBase*porcentaje/100);
            if (precioConDescuento >= precioMinimo){
                precioBase = precioConDescuento;
                System.out.println("Se ha aplicado un " + porcentaje + "% de descuento para " + nombre + ".");
            }
            else{
                precioBase = precioMinimo;
                System.out.println("El descuento supera el precio mínimo, " + nombre + " queda en $" + String.format("%.2f", precioBase) + ".");
            }
        }
    }
    
    //Método para calcular el precio final
    public double calcularPrecioFinal(){
        return precioBase + (precioBase*IVA/100);
    }
    
    //Método para actualizar el valor del IVA
    public static void cambiarIVA(double nuevo){
        if (validarPorcentaje(nuevo)){
            setIVA(nuevo);
            System.out.println("El IVA ahora es de un " + String.format("%.2f", IVA) + "%.");
        }
    }
    
    //Validaciones
    //Método para validar un double positivo
    private static boolean validarDoublePositivo (double num) {
        boolean positivo = true;
        if (num < 0){
            positivo = false;
            System.out.println("ERROR: El valor ingresado debe ser mayor o igual a cero.");
        }
    return positivo;
    }
    
    //Método para verificar que un String no esté vacío o en null
    private static boolean validarString(String palabra) {
        boolean valido = true;
        if ((palabra == null) || (palabra.trim().equals(""))) { //Se eliminan espacios antes y delante del String y verifica que no esté vacío
            valido = false;
            System.out.println("ERROR: El campo no puede estar vacío.");
        }
        return valido;
    }
    
    //Método para verificar que el porcentaje de descuento sea válido
    private static boolean validarPorcentaje (double num) {
        boolean positivo = true;
        if ((num < 0) || (num >100)){
            positivo = false;
            System.out.println("ERROR: El porcentaje de descuento debe estar entre cero y cien.");
        }
    return positivo;
    }
    
    //Método para verificar que el precio mínimo no sea menor a cero o mayor al precio base
    private static boolean validarPrecioMinimo (double min, double base) {
        boolean positivo = true;
        if (min < 0){
            positivo = false;
            System.out.println("ERROR: El precio mínimo debe ser positivo.");
        }
        else if (min > base) {
            positivo = false;
            System.out.println("Error: El precio mínimo no puede ser mayor al precio base");
        }
    return positivo;
    }
}
