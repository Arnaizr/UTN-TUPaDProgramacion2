package arnaiz_rodrigo_trabajo_practico_integrador.entities;

import arnaiz_rodrigo_trabajo_practico_integrador.Service.Validaciones;
import arnaiz_rodrigo_trabajo_practico_integrador.exceptions.InvalidFieldException;

/**
 *
 * @author RODRIGO
 */
public class DetallePedido extends Base {
    private int cantidad;
    private double subtotal;
    private Producto producto;
	
    public DetallePedido (int cantidad, Producto producto){
        super();
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
        validarCantidad(cantidad); //Se hace una verificación que la cantidad no sea negativa o exceda al stock
        this.cantidad = cantidad;
        subtotal = calcularSubtotal(); //Se recalcula el subtotal con la actualización de los datos
    }

    public void setProducto(Producto producto){
        if (producto == null){
            throw new InvalidFieldException("El producto no puede ser estar vacío.");
        }
        this.producto = producto;
        subtotal = calcularSubtotal();
    }
    private double calcularSubtotal(){
    subtotal = 0.0; //Se reseta el subtotal cada vez que se invoca al método
    if (producto.isDisponible()){ //Se hace una verificación que el producto se encuentre disponible
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
    private void validarCantidad(int num) {
        if (!Validaciones.validarIntNoNegativo(num)) {
            throw new InvalidFieldException("ERROR: El valor ingresado no puede ser negativo.");
        }
        if (num > producto.getStock()){ //Se valida que haya suficiente stock del producto para encargar
            throw new InvalidFieldException("ERROR: No hay stock suficiente.");
        }
    }
}
