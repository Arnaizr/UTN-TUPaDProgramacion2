package arnaiz_rodrigo_trabajo_practico_integrador.Service;

import arnaiz_rodrigo_trabajo_practico_integrador.entities.Pedido;
import arnaiz_rodrigo_trabajo_practico_integrador.entities.Producto;
import arnaiz_rodrigo_trabajo_practico_integrador.entities.Usuario;
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
        System.out.println("================================================================");
        for (Pedido pedido : activos) {
            System.out.println(pedido);
        }
        System.out.println("================================================================");
    }

    public Pedido createPedido(FormaPago formaPago, long idUsuario, ArrayList<Integer> cantidades, ArrayList<Producto> productos){
        Usuario usuarioAInstanciar = usuarioService.findUsuarioById(idUsuario);
        Pedido nuevo = null;
        ArrayList<Producto> productosACargar = productos;
        ArrayList<Integer> cantidadesACargar = cantidades;
        try{
            nuevo = new Pedido(formaPago, usuarioAInstanciar);
            Iterator<Integer> itInt = cantidadesACargar.iterator(); //Se crea un iterador para la carga de cantidades
            Iterator<Producto> itProd = productosACargar.iterator(); //Se crea un iterador para la carga de productos
            while (itInt.hasNext()){ //Se repite mientras haya cantidades a cargar (ambas listas son coincidentes
                Producto productoBucle = itProd.next(); //Se carga el producto actual de la iteración de la colección
                int cantidadBucle = itInt.next(); //Se carga la cantidad actual de la iteración de la colección
                nuevo.addDetallePedido(cantidadBucle, productoBucle); //Se llama al método addDetallePedido para agregar el producto y cantidad
            }
        }
        catch (EntityNotFoundException | DuplicateProductException | InvalidFieldException e){
            System.out.println(e.getMessage());
            System.out.println("Se cancela la creación del pedido.");
            if (nuevo != null){
                nuevo.setUsuario(null); // Se deshace la relación bilateral: usuario.eliminarPedido(this) se dispara internamente
            }
        }
        return nuevo;
    }








}
