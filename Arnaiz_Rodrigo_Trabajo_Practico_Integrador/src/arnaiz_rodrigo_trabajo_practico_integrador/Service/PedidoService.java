package arnaiz_rodrigo_trabajo_practico_integrador.Service;

import arnaiz_rodrigo_trabajo_practico_integrador.entities.DetallePedido;
import arnaiz_rodrigo_trabajo_practico_integrador.entities.Pedido;
import arnaiz_rodrigo_trabajo_practico_integrador.entities.Producto;
import arnaiz_rodrigo_trabajo_practico_integrador.entities.Usuario;
import arnaiz_rodrigo_trabajo_practico_integrador.enums.CampoPedido;
import arnaiz_rodrigo_trabajo_practico_integrador.enums.Estado;
import arnaiz_rodrigo_trabajo_practico_integrador.enums.FormaPago;
import arnaiz_rodrigo_trabajo_practico_integrador.exceptions.DuplicateProductException;
import arnaiz_rodrigo_trabajo_practico_integrador.exceptions.EntityNotFoundException;
import arnaiz_rodrigo_trabajo_practico_integrador.exceptions.InvalidFieldException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author RODRIGO
 */
public class PedidoService {
    private final List<Pedido> pedidos;
    private final UsuarioService usuarioService;
    
    public PedidoService(UsuarioService usuarioService) {
    this.pedidos = new ArrayList<>();
    this.usuarioService = usuarioService;
    }
    
    public void listarPedidos(){
        List<Pedido> activos = new ArrayList<>();
        for (Pedido pedido : pedidos) {
            if (!pedido.isEliminado()){
                activos.add(pedido);
            }
        }
        if (activos.isEmpty()){
            System.out.println("No hay pedidos cargados en el sistema.");
            return;
        }
        System.out.println("=======================================================================================================");
        for (Pedido pedido : activos) {
            System.out.println(pedido);
        }
        System.out.println("=======================================================================================================\n");
    }

    public Pedido createPedido(FormaPago formaPago, long idUsuario, ArrayList<Integer> cantidades, ArrayList<Producto> productos){
        Usuario usuarioAInstanciar = usuarioService.findUsuarioById(idUsuario);
        Pedido nuevo = new Pedido(formaPago, usuarioAInstanciar);
        try{
            Iterator<Integer> itInt = cantidades.iterator(); //Se crea un iterador para la carga de cantidades
            Iterator<Producto> itProd = productos.iterator(); //Se crea un iterador para la carga de productos
            while (itInt.hasNext()){ //Se repite mientras haya cantidades a cargar (ambas listas son coincidentes
                Producto productoBucle = itProd.next(); //Se carga el producto actual de la iteración de la colección
                int cantidadBucle = itInt.next(); //Se carga la cantidad actual de la iteración de la colección
                nuevo.addDetallePedido(cantidadBucle, productoBucle); //Se llama al método addDetallePedido para agregar el producto y cantidad
            }
            pedidos.add(nuevo); 
        }
        catch (DuplicateProductException | InvalidFieldException e){
            nuevo.setUsuario(null); // Se deshace la relación bilateral: usuario.eliminarPedido(this) se dispara internamente
            throw e; // Deshecha la relación se lanza nuevamente la excepción para que la capture el menú
        }
        return nuevo;
    }

    
    
    //Método para buscar un pedido por su id asociado
    public Pedido findPedidoById(long id){
        Pedido pedidoEncontrado = null; //Se inicializa en null la variable de pedido encontrado
        Iterator<Pedido> it = this.pedidos.iterator(); //Se crea un iterador para la búsqueda
        while (it.hasNext() && pedidoEncontrado == null){ //Se repite mientras haya pedidos en la colección y mientras no encuentre el pedido
            Pedido pedidoBucle = it.next(); //Se carga el pedido actual de la iteración de la colección
            if (id == pedidoBucle.getId()&& !pedidoBucle.isEliminado()){
                pedidoEncontrado = pedidoBucle;
            }
        }
        if (pedidoEncontrado == null){
            throw new EntityNotFoundException ("No se encontró un pedido con id: " + id);
        }
        return pedidoEncontrado;
    }
    
    public void editPedido(long id, CampoPedido campo, String nuevoValor){
        try{
            Pedido pedidoAEditar = findPedidoById(id); //Se busca el pedido por id
            switch (campo){
                case FORMAPAGO -> pedidoAEditar.setFormaPago(FormaPago.valueOf(nuevoValor));
                case ESTADO -> pedidoAEditar.setEstado(Estado.valueOf(nuevoValor));
                }
            System.out.println("Se cambió el atributo " + campo.name() + " del pedido : #" + pedidoAEditar.getId() + " por: " + nuevoValor + ".");
        }
        catch (EntityNotFoundException e){
            System.out.println(e.getMessage());
        }
    }

    //Método para eliminar un usuario por su id
    public void deletePedidoById(long id){
        try {
            Pedido pedidoAEliminar = findPedidoById(id); //Se busca el usuario con el id ingresado
            pedidoAEliminar.setEliminado(true); //Se hace la baja lógica del pedido
            for (DetallePedido detalle : pedidoAEliminar.getDetalles()) {
                detalle.setEliminado(true);
            }
            System.out.println("Se eliminó el pedido con id: " + id);
        }
        catch (EntityNotFoundException e){
            System.out.println(e.getMessage());
        }
    }



}
