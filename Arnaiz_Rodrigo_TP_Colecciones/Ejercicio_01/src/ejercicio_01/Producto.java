package ejercicio_01;

/**
 *
 * @author RODRIGO
 */
public class Producto {
    private final String id;
    private String nombre;
    private double precio;
    private int cantidad;
    private CategoriaProducto categoria;
    private static int contadorId = 0; //Se agrega un atributo static para crear un ID autoincremental
    
    public Producto(String nombre, double precio, int cantidad, CategoriaProducto categoria) { //Constructor general
        contadorId++;
        this.id = String.format("E%03d", contadorId);
        this.setNombre(nombre);
        this.setPrecio(precio);
        this.setCantidad(cantidad);
        this.setCategoria(categoria);
    }
    public Producto(String nombre, double precio, CategoriaProducto categoria){ //Constructor de producto sin stock inicial
        this(nombre, precio, 0, categoria);
    }
    //Getters
    public String getId() {
        return id;
    }
    public CategoriaProducto getCategoria() {
        return categoria;
    }
    public int getCantidad() {
        return cantidad;
    }
    public double getPrecio() {
        return precio;
    }
    
    //Setters
    private void setNombre(String nombre) {
        if(validarString(nombre)){
            this.nombre = nombre;
        }
    }
    private void setPrecio(double precio) {
        if(validarDoubleNoNegativo(precio)){
            this.precio = precio;
        }
    }
    private void setCantidad(int cantidad) {
        if(validarIntNoNegativo(cantidad)){
            this.cantidad = cantidad;
        }
    }
    private void setCategoria(CategoriaProducto categoria) {
        if (categoria != null){
            this.categoria = categoria;
        }
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nombre: " + nombre + ", Precio: $" +  String.format("%.2f" , precio) + ", Stock: " + cantidad + ", Categoria: " + categoria.name() + ".";
    }
    
    //Métodos
    //Método para mostrar la info del producto
    public void mostrarInfo() {
        System.out.println(this.toString());
    }
    //Método para actualizar el stock de un producto
    public void actualizarStock(int cantidad){
        if(validarIntNoNegativo(cantidad)){
            this.cantidad = cantidad;
            System.out.println("El stock del producto " + nombre + " ahora es: " + cantidad);
        }
    }
    //Validaciones 
    //Método para validar que un int no sea negativo
    private static boolean validarIntNoNegativo(int num) {
        boolean valido = true;
        if (num < 0) {
            valido = false;
            System.out.println("ERROR: El valor ingresado no puede ser negativo.");
        }
        return valido;
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
    
    //Método para validar un double mayor o igual a cero
    private static boolean validarDoubleNoNegativo (double num) {
        boolean positivo = true;
        if (num < 0){
            positivo = false;
            System.out.println("ERROR: El valor ingresado debe ser mayor o igual a cero.");
        }
    return positivo;
    }
}
