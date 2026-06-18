package interfaces;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author RODRIGO
 */
public class Pedido implements Pagable{
    private final List<Producto> productos;
    private Estado estado;
    private Cliente cliente;

    public Pedido(Cliente cliente) { //Se recibe un cliente que se asocia automáticamente al pedido
        this.productos = new ArrayList<>();
        this.estado = Estado.INICIADO; //Al crearse un pedido se establece como iniciado
        this.setCliente(cliente);
    }

    public Cliente getCliente() {
        return cliente;
    }
    
    public void setCliente(Cliente cliente) { //Setter bidireccional para cliente
        this.cliente = cliente;
        if (cliente != null && cliente.getPedido() != this) {
            cliente.setPedido(this);
            cliente.recibirNotificacion(notificarEstado()); //Seteado el cliente se lo notifica del estado del pedido
        }
    }
    
    public void agregarProducto(Producto p){
        if (p == null){
            System.out.println("ERROR: Producto inválido.");
            return;
        }
        productos.add(p);
    }
    public void procesarPago(MedioDePago medio){ //Se recibe un medio de pago para procesar el pago
        if (medio.procesarPago(calcularTotal())){ //Se envía el importe al medio de pago ingresado para procesarlo
            estado = Estado.PAGADO; //Si alcanza el saldo del medio de pago se gestiona el pago y cambia el estado
            cliente.recibirNotificacion(notificarEstado());
        }
        else{ //Caso contrario se informa al cliente del saldo insuficiente y el pedido queda pendiente de pago
            System.out.println("SALDO INSUFICIENTE");
            estado = Estado.PENDIENTE_DE_PAGO;
            cliente.recibirNotificacion(notificarEstado());
        }
        
    }    
    
    @Override
    public double calcularTotal() {
        double total = 0.0;
        if (cliente == null){
            System.out.println("Debe haber un  cliente asociado al pedido");
            return total;
        }
        if (productos.isEmpty()){
            System.out.println("No hay productos en el pedido.");
            return total;
        }
        for (Producto producto : productos) {
                total += producto.calcularTotal();
            }
       return total;
    }
    
    public String notificarEstado(){ //Método para informar del estado actual del pedido
        return estado.name();
    }
    
    
}
