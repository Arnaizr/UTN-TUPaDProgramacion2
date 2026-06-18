package arnaiz_rodrigo_segundo_parcial.entities;

/**
 *
 * @author RODRIGO
 */
public class DetallePedido extends Base {
    private int cantidad;
    private double subtotal;
    private Producto producto;
    private static long contadorId = 0; //Se crea un contador estático de clase para la instanciación automática del id
	
    public DetallePedido (int cantidad, Producto producto){
        super(++contadorId); //Se envía como parámetro el contador incrementado a la clase base
        this.setProducto(producto);
        this.setCantidad(cantidad);
    }
    //Getters
    public int getCantidad(){
        return cantidad;
    }

    public double getSubtotal(){
        return subtotal;
    }

    public Producto getProducto(){
        return producto;
    }

    //Setters
    public void setCantidad(int cantidad){
        if (validarCantidad(cantidad)){ //Se hace una verificación que la cantidad no sea negativa o exceda al stock
            this.cantidad = cantidad;
            subtotal = calcularSubtotal(); //Se recalcula el subtotal con la actualización de los datos
        }
    }

    public void setProducto(Producto producto){
        this.producto = producto;
        subtotal = calcularSubtotal(); //Se recalcula el subtotal con la actualización de los datos
    }
    private double calcularSubtotal(){
    subtotal = 0.0; //Se reseta el subtotal cada vez que se invoca al método
    if (producto == null){
        System.out.println("Error: El producto no puede estar vacío"); //Si no hay producto el subtotal es 0
    }
    else if (producto.isDisponible()){ //Se hace una verificación que el producto se encuentre disponible (stock > 0)
        subtotal = cantidad * producto.getPrecio(); 
    }
    else{
        System.out.println("El producto no está disponible.");
    }
    return subtotal;
}	
	
    @Override
    public String toString() {
        return "· DetallePedido #[" + getId() + "]: [" + producto.getNombre() + "] x [" + cantidad + "] => Subtotal: $" + String.format("%.2f", subtotal);
    }
    //Validaciones 
    //Método para validar que la cantidad cumpla las condiciones
    private boolean validarCantidad(int num) {
        if (producto == null) return false; //Si el producto es null retorna falso
        if (num < 0) {
            System.out.println("ERROR: El valor ingresado no puede ser negativo.");
            return false;
        }else if (num > producto.getStock()){ //Se valida que haya suficiente stock del producto para encargar
            System.out.println("ERROR: No hay stock suficiente.");
            return false;
        }
        return true;
    }
}
