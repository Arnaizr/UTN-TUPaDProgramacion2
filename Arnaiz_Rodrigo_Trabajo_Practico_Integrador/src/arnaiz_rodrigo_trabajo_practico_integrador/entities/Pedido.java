package arnaiz_rodrigo_trabajo_practico_integrador.entities;


import arnaiz_rodrigo_trabajo_practico_integrador.enums.Estado;
import arnaiz_rodrigo_trabajo_practico_integrador.enums.FormaPago;
import arnaiz_rodrigo_trabajo_practico_integrador.exceptions.DuplicateProductException;
import arnaiz_rodrigo_trabajo_practico_integrador.exceptions.InvalidFieldException;
import arnaiz_rodrigo_trabajo_practico_integrador.interfaces.Calculable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author RODRIGO
 */
public class Pedido extends Base implements Calculable {
    private LocalDate fecha;
    private Estado estado;
    private double total = 0.0;
    private FormaPago formaPago;
    private final List<DetallePedido> detalles;
    private Usuario usuario;
    private static long contadorId = 0;  //Se crea un contador estático de clase para la instanciación automática del id
    private static long contadorDetalles = 0;  //Se crea un contador estático de clase para la instanciación automática de los detalles
	
    public Pedido (FormaPago formaPago, Usuario usuario){
        super(++contadorId); //Se envía como parámetro el contador incrementado a la clase base
        this.fecha = LocalDate.now();
        this.estado = Estado.PENDIENTE;
        this.setFormaPago(formaPago);
        this.detalles = new ArrayList<>();
        this.setUsuario(usuario);
    }
    //Getters
    public LocalDate getFecha(){
        return fecha;
    }

    public Estado getEstado(){
        return estado;
    }

    public FormaPago getFormaPago(){
        return formaPago;
    }
    public double getTotal(){
        return total;
    }
    public Usuario getUsuario(){
        return usuario;
    }
    public List<DetallePedido> getDetalles(){
        return Collections.unmodifiableList(detalles);
    }
    //Setters
    public void setFormaPago(FormaPago formaPago){
        this.formaPago = formaPago;
    }

    private void setFecha() {
        fecha = LocalDate.now();
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
        setFecha(); //Se actualiza la fecha del pedido con cada cambio de estado (distinta a la fecha de creación de la clase base)
    }
	
    public void setUsuario (Usuario usuario){ //Setter que garantiza la asociación bilateral e integridad referencial
        //Se verifica que el usuario no sea el mismo cargado
        if (this.usuario == usuario){
            return;
        }
        //Se verifica que si hay un usuario  cargado se elimine
        if (this.usuario != null){
            this.usuario.eliminarPedido(this);
        }
        //Establecer el usuario como solicitante del pedido
        this.usuario = usuario;
        //Añadir el pedido a cargo del usuario (si no es nulo y si no está ya cargado)
        if (usuario != null && !usuario.getPedidos().contains(this)){
            usuario.agregarPedido(this);
        }
    }
    //Métodos
    //Método para agregar un producto al pedido
    public void addDetallePedido(int cantidad, Producto producto){
        if (producto == null){
            throw new InvalidFieldException("El producto no puede ser nulo.");
           }
        if (findDetallePedidoByProducto(producto) != null){
            throw new DuplicateProductException("El producto " + producto.getNombre() + " ya se encuentra en el pedido.");
        }
        DetallePedido.validarCantidad(cantidad, producto);
        this.detalles.add(new DetallePedido(++contadorDetalles, cantidad, producto));
        calcularTotal();
    }
	
    //Método para buscar un detalle del pedido por su producto asociado
    public DetallePedido findDetallePedidoByProducto(Producto producto){
        DetallePedido detalleEncontrado = null; //Se inicializa en null la variable de detalle encontrado
        Iterator<DetallePedido> it = this.detalles.iterator(); //Se crea un iterador para la búsqueda
        while (it.hasNext() && detalleEncontrado == null){ //Se repite mientras haya detalles en la colección y mientras no encuentre el producto
            DetallePedido detalle = it.next(); //Se carga el libro actual de la iteración de la colección
            if (detalle.getProducto().getId() == producto.getId() && !detalle.isEliminado()){ 
                detalleEncontrado = detalle;//Si coinciden los id y el detalle no está eliminado se almacena el valor
            }
        }
        return detalleEncontrado;
    }
    
    //Método para eliminar un pedido por el producto asociado
    public void deleteDetallePedidoByProducto(Producto producto){
        DetallePedido detalleAEliminar = findDetallePedidoByProducto(producto);
        if (detalleAEliminar == null){
            System.out.println("No se encontró un detalle con el producto " + producto.getNombre());
        }
        else{
            detalleAEliminar.setEliminado(true); //Se hace un soft delete dejando el detalle en el historial
            System.out.println("Se eliminó el detalle con el producto " + producto.getNombre());
            calcularTotal();
        }
    }
    
    public void mostrarDetalles(){
        System.out.println("=======================================================================================================");
        System.out.println("-------------------------------------------------------------------------------------------------------");
        for (DetallePedido detalle : detalles) {
            if (!detalle.isEliminado()){
                System.out.println(detalle);
            }
        }
        System.out.println("TOTAL DEL PEDIDO: $" + String.format("%.2f", total));
        System.out.println("-------------------------------------------------------------------------------------------------------\n");
    }
    @Override
    public void calcularTotal(){
        total = 0.0;
        for (DetallePedido detalle : detalles) {
            if (!detalle.isEliminado()){
                total += detalle.getSubtotal();
            }
        }
    }
        
    @Override
    public String toString() {
        return "Pedido #[" + getId() + "] | Usuario: [" + usuario.getNombre() +"] | Fecha: [" + fecha + "] | Estado: [" + estado + "] | Forma de Pago: [" + formaPago + "]";
}
    
}