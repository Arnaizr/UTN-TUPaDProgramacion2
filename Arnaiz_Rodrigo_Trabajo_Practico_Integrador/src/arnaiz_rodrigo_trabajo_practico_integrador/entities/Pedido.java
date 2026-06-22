package arnaiz_rodrigo_trabajo_practico_integrador.entities;


import arnaiz_rodrigo_trabajo_practico_integrador.enums.Estado;
import arnaiz_rodrigo_trabajo_practico_integrador.enums.FormaPago;
import arnaiz_rodrigo_trabajo_practico_integrador.exceptions.DuplicateProductException;
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
	
    public Pedido (FormaPago formaPago, Usuario usuario){
        super(); 
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
        if (findDetallePedidoByProducto(producto) != null){
            throw new DuplicateProductException("El producto " + producto.getNombre() + " ya se encuentra en el pedido.");    
        }
        this.detalles.add(new DetallePedido(cantidad, producto));
        calcularTotal();
    }
	
    //Método para buscar un detalle del pedido por su producto asociado
    public DetallePedido findDetallePedidoByProducto(Producto producto){
        DetallePedido detalleEncontrado = null; //Se inicializa en null la variable de detalle encontrado
        Iterator<DetallePedido> it = this.detalles.iterator(); //Se crea un iterador para la búsqueda
        while (it.hasNext() && detalleEncontrado == null){ //Se repite mientras haya detalles en la colección y mientras no encuentre el producto
            DetallePedido detalle = it.next(); //Se carga el libro actual de la iteración de la colección
            if (detalle.getProducto().getId() == producto.getId()){
                detalleEncontrado = detalle;
            }
        }
        return detalleEncontrado;
    }

    //Método para eliminar un detalle por su producto asociado
    public void deleteDetallePedidoByProducto(Producto producto){
        DetallePedido detalleAEliminar = findDetallePedidoByProducto(producto); //Se busca el detalle con el producto ingresado
        if (detalleAEliminar == null){
            System.out.println("No se encontró un detalle con el producto " + producto.getNombre());
        }
        else{
            detalles.remove(detalleAEliminar); //Se elimina el detalle del pedido
            System.out.println("Se eliminó el detalle con el producto " + producto.getNombre());
            calcularTotal();
        }
    }
    //Método para mostrar detalles de pedidos 
    public void mostrarDetalles(){
        System.out.println("--------------------------------------");
        for (DetallePedido detalle : detalles) {
            System.out.println(detalle);
        }
        System.out.println("TOTAL DEL PEDIDO: $" + String.format("%.2f", total));
        System.out.println("--------------------------------------");

    }
    @Override
    public void calcularTotal(){
        total = 0.0; //Se reinicia cada vez que se llama al método para no acumular sobre el total anterior
            for (DetallePedido detalle : detalles) {
            total += detalle.getSubtotal();
            }
    }
        
    @Override
    public String toString() {
        return "Pedido #[" + getId() + "] | Usuario: [" + usuario.getNombre() +"] | Fecha: [" + fecha + "] | Estado: [" + estado + "] | Forma de Pago: [" + formaPago + "]";
}
    
}