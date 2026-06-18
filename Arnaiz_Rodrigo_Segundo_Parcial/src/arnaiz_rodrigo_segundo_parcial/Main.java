package arnaiz_rodrigo_segundo_parcial;

import arnaiz_rodrigo_segundo_parcial.entities.Base;
import arnaiz_rodrigo_segundo_parcial.entities.Categoria;
import arnaiz_rodrigo_segundo_parcial.entities.DetallePedido;
import arnaiz_rodrigo_segundo_parcial.entities.Pedido;
import arnaiz_rodrigo_segundo_parcial.entities.Producto;
import arnaiz_rodrigo_segundo_parcial.entities.Usuario;
import arnaiz_rodrigo_segundo_parcial.enums.Estado;
import arnaiz_rodrigo_segundo_parcial.enums.FormaPago;
import arnaiz_rodrigo_segundo_parcial.enums.Rol;
import java.util.ArrayList;
import java.util.List;

/**
 * @author RODRIGO
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("---- PROGRAMACIÓN II ----");
        System.out.println("---- Segundo Parcial ----\n");
        System.out.println("---- Food Store ----\n");
        
        //Inicialización de categorías
        Categoria entradas = new Categoria("Entradas", "Bruschettas, Tapas, Pinchos");
        Categoria minutas = new Categoria("Minutas", "Milanesas, Tortillas, Omelettes");
        Categoria pastas = new Categoria("Pastas", "Risottos, Pastas Rellenas, Especiales");
        //Inicialización de productos
        Producto prod_entrada1 = new Producto("Mollejas", 9500.22, "Mollejas a la chapa con provenzal", 15, "fotomolleja.jpg", entradas);
        Producto prod_entrada2 = new Producto("Provoleta", 6600.11, "Provoleta al ajo asado", 10, "fotoprovoleta.jpg", entradas);
        Producto prod_minuta1 = new Producto("Milanesa Napolitana", 17600, "Milanesa Napolitana con guarnición", 20, "fotomilanapo.jpg", minutas);
        Producto prod_minuta2 = new Producto("Tortilla Española", 13650, "Tortilla de papa con longaniza y cebolla", 10, "fototortilla.jpg", minutas);
        Producto prod_pasta1 = new Producto("Sorrentinos", 14900.20, "Sorrentinos de ricota jamón y nuez con salsa a elección", 8, "fotosorrentinos.jpg", pastas);
        Producto prod_pasta2 = new Producto("Parmigiana", 20600.00, "Parmigiana de berenjenas con salsa filetto", 3, "fotoparmigianna.jpg", pastas);
        //Alta de usuarios
        Usuario usu_juanperez = new Usuario("Juan", "Perez", "juancitoperez@gmail.com", "2214448833", "juan123", Rol.USUARIO);
        Usuario admin_mengano = new Usuario("Jose", "Mengano", "menganito88@gmail.com", "2215558833", "menga123", Rol.ADMIN);
        //Alta de pedidos
        Pedido pedidojuan1 = new Pedido(FormaPago.TRANSFERENCIA, usu_juanperez);
        Pedido pedidojuan2 = new Pedido(FormaPago.TRANSFERENCIA, usu_juanperez);
        Pedido pedidomengano1 = new Pedido(FormaPago.TARJETA, admin_mengano);
        Pedido pedidomengano2 = new Pedido(FormaPago.EFECTIVO, admin_mengano);
        //Carga de productos y cantidades en cada pedido
        pedidojuan1.addDetallePedido(1, prod_pasta2);
        pedidojuan1.addDetallePedido(4, prod_minuta1);
        pedidojuan1.addDetallePedido(5, prod_entrada1);
        pedidojuan2.addDetallePedido(6, prod_pasta1);
        pedidojuan2.addDetallePedido(3, prod_minuta2);
        pedidojuan2.addDetallePedido(3, prod_entrada2);
        pedidomengano1.addDetallePedido(3, prod_entrada1);
        pedidomengano1.addDetallePedido(3, prod_minuta2);
        pedidomengano1.addDetallePedido(2, prod_pasta2);
        pedidomengano2.addDetallePedido(4, prod_entrada2);
        pedidomengano2.addDetallePedido(8, prod_minuta1);
        pedidomengano2.addDetallePedido(2, prod_pasta1);
        //Se crea una lista de usuarios para mostrar los reportes
        List<Usuario> usuarios = new ArrayList<>();
        //Se agregan los usuarios a la lista
        usuarios.add(admin_mengano);
        usuarios.add(usu_juanperez);
        //Se llama al método para mostrar el reporte
        reporteLista(usuarios);
        //Se crea una lista de categorias para mostrar un reporte
        List<Categoria> categorias =  new ArrayList<>();
        //Se agregan las 3 categorías creadas
        categorias.add(pastas);
        categorias.add(minutas);
        categorias.add(entradas);
        //Se llama al método que muestra los reportes
        System.out.println("\n");
        reporteLista(categorias);
        
        // Mover un producto de categoría
        System.out.println("\n--- Mover producto de categoría ---");
        System.out.println("Antes: " + prod_entrada1.getCategoria());
        prod_entrada1.setCategoria(pastas);
        System.out.println("Después: " + prod_entrada1.getCategoria());
        System.out.println("Productos en entradas: " + entradas.getProductos());
        System.out.println("Productos en pastas: " + pastas.getProductos());

        // Buscar un DetallePedido por producto
        System.out.println("\n--- Buscar DetallePedido por producto ---");
        System.out.println("Producto: " + prod_pasta2.getNombre());
        DetallePedido encontrado = pedidojuan1.findDetallePedidoByProducto(prod_pasta2);
        System.out.println("Encontrado: " + (encontrado != null ? encontrado : "no se econtró el producto en el pedido"));
                
        // Buscar un DetallePedido por producto sin DetallePedido asociado
        Producto prod_pasta3 = new Producto("Canelones", 11110.1111, "Canelones de osobuco braseado con salsa de hongos", 0, "fotocanelones.jpg", pastas);
        System.out.println("\n--- Buscar DetallePedido por producto ---");
        System.out.println("Producto: " + prod_pasta3.getNombre());
        DetallePedido encontrado2 = pedidojuan1.findDetallePedidoByProducto(prod_pasta3);
        System.out.println("Encontrado: " + (encontrado2 != null ? encontrado2 : "no se econtró el producto en el pedido"));

        // Borrar un DetallePedido por producto
        System.out.println("\n--- Borrar DetallePedido por producto ---");
        System.out.println("Total antes: $" + String.format("%.2f", pedidojuan1.getTotal()));
        pedidojuan1.deleteDetallePedidoByProducto(prod_pasta2);
        System.out.println("Total después: $" + String.format("%.2f", pedidojuan1.getTotal()));

        // Intentar agregar un producto duplicado
        System.out.println("\n--- Agregar producto duplicado ---");
        pedidojuan2.addDetallePedido(2, prod_pasta1);
        
        // Intentar agregar un producto sin stock
        System.out.println("\n--- Agregar producto sin stock ---");
        pedidojuan1.addDetallePedido(5, prod_pasta3);
        pedidojuan1.mostrarDetalles();
        System.out.println("Actualizando stock....");
        prod_pasta3.setStock(7);
        pedidojuan1.findDetallePedidoByProducto(prod_pasta3).setCantidad(5);
        pedidojuan1.mostrarDetalles();
        
        // Cambiar estado de un pedido
        System.out.println("\n--- Cambiar estado de pedido ---");
        System.out.println("Estado de pedido #" + pedidojuan1.getId() + "antes: " + pedidojuan1.getEstado());
        pedidojuan1.setEstado(Estado.CONFIRMADO);
        System.out.println("Estado #" + pedidojuan1.getId() + "después: " + pedidojuan1.getEstado());
        
        //Se muestra el informe final después de todos los cambios
        System.out.println("\n");
        reporteLista(usuarios);
        
        System.out.println("\n--- FIN DEL PROGRAMA ---\n");
    }
    
    private static void reporteLista(List<? extends Base> lista) { //Se utiliza el mismo método de reportes aprovechando la herencia
        if (lista.isEmpty()) return;
        System.out.println("================================================================");
        for (Base elemento : lista) { 
            System.out.println(elemento);
            if (elemento instanceof Usuario) { //Se utiliza un condicional con instanceOf para usar los métodos específicos de cada clase
                ((Usuario) elemento).mostrarTotalPedidos(); //Se llama al pedido específico de cada usuario (tell, don't ask)
            } 
            else if (elemento instanceof Categoria) {
                System.out.println("--------------------");
                for (Producto p : ((Categoria) elemento).getProductos()) {
                    p.mostrarInfo(); //Se llama al pedido específico de cada producto (tell, don't ask)
                }
                System.out.println("--------------------");
                System.out.println("================================================================");
            }
            }
    }
}
