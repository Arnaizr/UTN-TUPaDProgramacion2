package arnaiz_rodrigo_trabajo_practico_integrador.ui;

import arnaiz_rodrigo_trabajo_practico_integrador.Service.PedidoService;
import arnaiz_rodrigo_trabajo_practico_integrador.Service.ProductoService;
import arnaiz_rodrigo_trabajo_practico_integrador.entities.DetallePedido;
import arnaiz_rodrigo_trabajo_practico_integrador.entities.Pedido;
import arnaiz_rodrigo_trabajo_practico_integrador.entities.Producto;
import arnaiz_rodrigo_trabajo_practico_integrador.enums.CampoPedido;
import arnaiz_rodrigo_trabajo_practico_integrador.enums.Estado;
import arnaiz_rodrigo_trabajo_practico_integrador.enums.FormaPago;
import arnaiz_rodrigo_trabajo_practico_integrador.exceptions.DuplicateProductException;
import arnaiz_rodrigo_trabajo_practico_integrador.exceptions.EntityNotFoundException;
import arnaiz_rodrigo_trabajo_practico_integrador.exceptions.InvalidFieldException;
import java.util.ArrayList;

/**
 *
 * @author RODRIGO
 */
public class MenuPedido {
    private static void mostrarOpciones(){
        System.out.println("\n--- PEDIDOS ---\n");
        System.out.println("1. Listar");
        System.out.println("2. Crear");
        System.out.println("3. Editar");
        System.out.println("4. Eliminar");
        System.out.println("5. Mostrar detalles de un pedido");
        System.out.println("6. Agregar producto a un pedido");
        System.out.println("7. Modificar cantidad del producto de un pedido");
        System.out.println("0. Volver al menú anterior");
    }
    
    //Método para navegar por los submenús
    public static void seleccionOpciones(PedidoService pedidoService, ProductoService productoService){
        int opcion;
        do {
            mostrarOpciones();
            System.out.println("\nIngrese una opción para continuar: ");
            opcion = MenuPrincipal.leerIntNoNegativo();
            switch (opcion){
                case 1 -> submenuListar(pedidoService);
                case 2 -> submenuCrear(pedidoService, productoService);
                case 3 -> submenuEditar(pedidoService);
                case 4 -> submenuEliminar(pedidoService);
                case 5 -> submenuMostrarDetalles(pedidoService);
                case 6 -> submenuAgregarDetalle(pedidoService, productoService);
                case 7 -> submenuModificarCantidad(pedidoService, productoService);
                case 0 -> System.out.println("");
                default -> System.out.println("\"" + opcion + "\" no es una opción válida, inténtelo nuevamente.");
            }
        } while (opcion != 0);
    }
    
    //Método para listar los pedidos activos
    public static void submenuListar(PedidoService pedidoService){
        System.out.println("\n--- Listar Pedidos ---\n");
        pedidoService.listarPedidos();
        MenuPrincipal.inputParaContinuar();
    }
    
    //Método para crear un pedido nuevo
    public static void submenuCrear (PedidoService pedidoService, ProductoService productoService){
        System.out.println("\n--- Crear Pedido ---\n");
        //Se listan los pedidos para ver los datos y facilitar las pruebas
        pedidoService.listarPedidos();
        System.out.println("Por favor, ingrese el id del usuario que realiza el pedido: ");
        long idUsuarioInput = MenuPrincipal.leerIntNoNegativo();

        System.out.println("Seleccione la forma de pago: ");
        FormaPago[] formasPago = FormaPago.values();
        for (int i = 0; i < formasPago.length; i++){
            System.out.println((i + 1) + " - " + formasPago[i]);
        }
        int indiceFormaPago = MenuPrincipal.leerIndiceValido(formasPago.length);
        FormaPago formaPagoInput = formasPago[indiceFormaPago - 1];

        ArrayList<Integer> cantidades = new ArrayList<>();
        ArrayList<Producto> productos = new ArrayList<>();
        boolean seguirAgregando = true;
        while (seguirAgregando){
            productoService.listarProductos();
            System.out.println("Ingrese el id del producto a agregar: ");
            long idProductoInput = MenuPrincipal.leerIntNoNegativo();
            try {
                Producto productoEncontrado = productoService.findProductoById(idProductoInput);
                System.out.println("Ingrese la cantidad: ");
                int cantidadInput = MenuPrincipal.leerIntNoNegativo();
                productos.add(productoEncontrado);
                cantidades.add(cantidadInput);
            }
            catch (EntityNotFoundException e){
                System.out.println(e.getMessage());
            }
            seguirAgregando = MenuPrincipal.confirmacion("¿Desea agregar otro producto? (S/N)");
        }
        if (cantidades.isEmpty() || productos.isEmpty()){ //Si hubo una excepción y se salió del bucle se vuelve
            System.out.println("No se agregaron productos para cargar.");
            MenuPrincipal.inputParaContinuar();
            return;
        }

        try {
            Pedido nuevo = pedidoService.createPedido(formaPagoInput, idUsuarioInput, cantidades, productos);
            System.out.println("Se creó el pedido: " + nuevo);
        }
        catch (EntityNotFoundException | DuplicateProductException | InvalidFieldException e){
            System.out.println(e.getMessage());
        }
        MenuPrincipal.inputParaContinuar();
    }
    
    //Método para editar un pedido
    public static void submenuEditar (PedidoService pedidoService){
        System.out.println("\n--- Editar Pedido ---\n");
        //Se listan los pedidos para ver los datos y facilitar las pruebas
        pedidoService.listarPedidos();
        System.out.println("Por favor, ingrese el id del pedido a editar: ");
        long idInput = MenuPrincipal.leerIntNoNegativo();
        System.out.println("Por favor, ingrese el campo que desea editar: ");
        CampoPedido[] campos = CampoPedido.values();
        for (int i = 0; i < campos.length; i++){
            System.out.println((i + 1) + " - " + campos[i]);
        }
        int indice = MenuPrincipal.leerIndiceValido(campos.length);
        CampoPedido campoAEditar = campos[indice - 1];
        
        System.out.println("Ingrese el nuevo valor: ");
        String nuevoValor = "";
        if (campoAEditar == CampoPedido.FORMAPAGO){ //Si el campo es forma de pago se convierte a String para enviar por el método
            FormaPago[] medios = FormaPago.values();
            for (int i = 0; i < medios.length; i++){
                System.out.println((i + 1) + " - " + medios[i]);
            }
            int indiceFormaPago = MenuPrincipal.leerIndiceValido(medios.length);
            nuevoValor = medios[indiceFormaPago - 1].name();
        }
        if (campoAEditar == CampoPedido.ESTADO){ //Si el campo es el estado se convierte a String para enviar por el método
            Estado[] estados = Estado.values();
            for (int i = 0; i < estados.length; i++){
                System.out.println((i + 1) + " - " + estados[i]);
            }
            int indiceEstado = MenuPrincipal.leerIndiceValido(estados.length);
            nuevoValor = estados[indiceEstado - 1].name();
        }
        //Se llama directamente al método porque maneja excepciones internamemte        
        pedidoService.editPedido(idInput, campoAEditar, nuevoValor); 
        MenuPrincipal.inputParaContinuar();
    }
    
    //Método para eliminar un pedido
    public static void submenuEliminar (PedidoService pedidoService){
        System.out.println("\n--- Eliminar Pedido ---\n");
        //Se listan los pedidos para ver los datos y facilitar las pruebas
        pedidoService.listarPedidos();
        System.out.println("Por favor, ingrese el id del pedido a eliminar: ");
        long idInput = MenuPrincipal.leerIntNoNegativo();
        if (MenuPrincipal.confirmacion("¿Desea eliminar el pedido con id #" + idInput + "? (S/N)")){
            pedidoService.deletePedidoById(idInput);
        }
        MenuPrincipal.inputParaContinuar();
    }
    
    //Método que muestra todos los detalles de un  pedido
    public static void submenuMostrarDetalles(PedidoService pedidoService){
        System.out.println("\n--- Mostrar Detalles de Pedido ---\n");
        pedidoService.listarPedidos();
        //Se listan los pedidos para ver los datos y facilitar las pruebas
        System.out.println("Por favor, ingrese el id del pedido: ");
        long idInput = MenuPrincipal.leerIntNoNegativo();
        try {
            Pedido pedidoEncontrado = pedidoService.findPedidoById(idInput);
            pedidoEncontrado.mostrarDetalles();
        }
        catch (EntityNotFoundException e){
            System.out.println(e.getMessage());
        }
        MenuPrincipal.inputParaContinuar();
    }
    
    
    //Método para agregar un nuevo detallePedido al pedido
    public static void submenuAgregarDetalle(PedidoService pedidoService, ProductoService productoService){
        System.out.println("\n--- Agregar Detalle a Pedido ---\n");
        pedidoService.listarPedidos();
        //Se listan los pedidos para ver los datos y facilitar las pruebas
        System.out.println("Por favor, ingrese el id del pedido: ");
        long idPedidoInput = MenuPrincipal.leerIntNoNegativo();
        try {
            Pedido pedidoEncontrado = pedidoService.findPedidoById(idPedidoInput);
            productoService.listarProductos();
            //Se listan los productos para ver los datos y facilitar las pruebas
            System.out.println("Ingrese el id del producto a agregar: ");
            long idProductoInput = MenuPrincipal.leerIntNoNegativo();
            Producto productoEncontrado = productoService.findProductoById(idProductoInput);
            System.out.println("Ingrese la cantidad: ");
            int cantidadInput = MenuPrincipal.leerIntNoNegativo();
            pedidoEncontrado.addDetallePedido(cantidadInput, productoEncontrado);
            System.out.println("Se agregó el detalle correctamente.");
        }
        catch (EntityNotFoundException | DuplicateProductException | InvalidFieldException e){
            System.out.println(e.getMessage());
        }
        MenuPrincipal.inputParaContinuar();
    }
    
    
    //Método para modificar la cantidad de un detallePedido
    public static void submenuModificarCantidad(PedidoService pedidoService, ProductoService productoService){
        System.out.println("\n--- Modificar Cantidad de Detalle ---\n");
        pedidoService.listarPedidos();
        //Se listan los pedidos para ver los datos y facilitar las pruebas
        System.out.println("Por favor, ingrese el id del pedido: ");
        long idPedidoInput = MenuPrincipal.leerIntNoNegativo();
        try {
            Pedido pedidoEncontrado = pedidoService.findPedidoById(idPedidoInput);
            pedidoEncontrado.mostrarDetalles();
            //Se listan los detalles para ver los datos y facilitar las pruebas
            System.out.println("Ingrese el id del producto cuyo detalle desea modificar: ");
            long idProductoInput = MenuPrincipal.leerIntNoNegativo();
            Producto productoEncontrado = productoService.findProductoById(idProductoInput);
            DetallePedido detalleEncontrado = pedidoEncontrado.findDetallePedidoByProducto(productoEncontrado);
            if (detalleEncontrado == null){
                System.out.println("No se encontró un detalle con ese producto en el pedido.");
                MenuPrincipal.inputParaContinuar();
                return;
            }
            System.out.println("Ingrese la nueva cantidad: ");
            int cantidadInput = MenuPrincipal.leerIntNoNegativo();
            detalleEncontrado.setCantidad(cantidadInput);
            pedidoEncontrado.calcularTotal();
            System.out.println("Se actualizó la cantidad correctamente.");
        }
        catch (EntityNotFoundException | InvalidFieldException e){
            System.out.println(e.getMessage());
        }
        MenuPrincipal.inputParaContinuar();
    }
    
}
