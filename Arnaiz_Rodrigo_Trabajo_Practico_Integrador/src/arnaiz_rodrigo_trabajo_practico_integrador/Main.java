package arnaiz_rodrigo_trabajo_practico_integrador;

import arnaiz_rodrigo_trabajo_practico_integrador.Service.CategoriaService;
import arnaiz_rodrigo_trabajo_practico_integrador.Service.PedidoService;
import arnaiz_rodrigo_trabajo_practico_integrador.Service.ProductoService;
import arnaiz_rodrigo_trabajo_practico_integrador.Service.UsuarioService;
import arnaiz_rodrigo_trabajo_practico_integrador.entities.Categoria;
import arnaiz_rodrigo_trabajo_practico_integrador.entities.Pedido;
import arnaiz_rodrigo_trabajo_practico_integrador.entities.Producto;
import arnaiz_rodrigo_trabajo_practico_integrador.entities.Usuario;
import arnaiz_rodrigo_trabajo_practico_integrador.enums.FormaPago;
import arnaiz_rodrigo_trabajo_practico_integrador.enums.Rol;
import arnaiz_rodrigo_trabajo_practico_integrador.ui.MenuPrincipal;
import java.util.ArrayList;
 
/**
 *
 * @author RODRIGO
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("---------- PROGRAMACIÓN II ----------");
        System.out.println("---- TRABAJO PRÁCTICO INTEGRADOR ----\n");
        System.out.println("------------ Food Store -------------\n");
        
        //Se inicializan los servicios de las entidades para la ejecución del programa
        System.out.println("Iniciando servicios...\n...\n..\n.\n");
        UsuarioService usuarioService = new UsuarioService();
        CategoriaService categoriaService = new CategoriaService();
        ProductoService productoService = new ProductoService(categoriaService);
        PedidoService pedidoService = new PedidoService(usuarioService);
        
        //Carga de datos de prueba (hardcodeados) para validar el funcionamiento del sistema
        System.out.println("Cargando datos de prueba...\n");

        //Categorías
        Categoria verduras = categoriaService.createCategoria("Verduras", "Tubérculos, raíces, bulbos, hojas");
        Categoria carnes = categoriaService.createCategoria("Carnes", "Vacuna, porcina, aviar");
        Categoria lacteos = categoriaService.createCategoria("Lácteos", "Quesos, leches, yogures");

        //Productos
        Producto papa = productoService.createProducto("Papa", 5, "Tubérculo", 30, "C:/Imagenes/papa.jpg", true, verduras.getId());
        Producto zanahoria = productoService.createProducto("Zanahoria", 3.5, "Raíz", 20, "C:/Imagenes/zanahoria.jpg", true, verduras.getId());
        Producto cebolla = productoService.createProducto("Cebolla", 4, "Bulbo", 25, "C:/Imagenes/cebolla.jpg", true, verduras.getId());
        Producto carne = productoService.createProducto("Carne", 8500, "Vacuna", 18, "C:/Imagenes/carne.jpg", true, carnes.getId());
        Producto pollo = productoService.createProducto("Pollo", 4200, "Aviar", 22, "C:/Imagenes/pollo.jpg", true, carnes.getId());
        Producto queso = productoService.createProducto("Queso", 6300, "Cremoso", 16, "C:/Imagenes/queso.jpg", true, lacteos.getId());

        //Usuarios
        Usuario juanPerez = usuarioService.createUsuario("Juan", "Perez", "juanperez@mailfalso.com", "2214444444", "clavefalsa123", Rol.USUARIO);
        Usuario adminMengano = usuarioService.createUsuario("Jose", "Mengano", "menganito88@mailfalso.com", "2215558833", "menga123", Rol.ADMIN);

        //Pedido 1 de Juan: papa + carne
        ArrayList<Integer> cantidadesJuan1 = new ArrayList<>();
        cantidadesJuan1.add(5);
        cantidadesJuan1.add(10);
        ArrayList<Producto> productosJuan1 = new ArrayList<>();
        productosJuan1.add(papa);
        productosJuan1.add(carne);
        Pedido pedidoJuan1 = pedidoService.createPedido(FormaPago.EFECTIVO, juanPerez.getId(), cantidadesJuan1, productosJuan1);

        //Pedido 2 de Juan: zanahoria + queso
        ArrayList<Integer> cantidadesJuan2 = new ArrayList<>();
        cantidadesJuan2.add(8);
        cantidadesJuan2.add(2);
        ArrayList<Producto> productosJuan2 = new ArrayList<>();
        productosJuan2.add(zanahoria);
        productosJuan2.add(queso);
        Pedido pedidoJuan2 = pedidoService.createPedido(FormaPago.TRANSFERENCIA, juanPerez.getId(), cantidadesJuan2, productosJuan2);

        //Pedido 1 de Mengano: cebolla + pollo
        ArrayList<Integer> cantidadesMengano1 = new ArrayList<>();
        cantidadesMengano1.add(6);
        cantidadesMengano1.add(3);
        ArrayList<Producto> productosMengano1 = new ArrayList<>();
        productosMengano1.add(cebolla);
        productosMengano1.add(pollo);
        Pedido pedidoMengano1 = pedidoService.createPedido(FormaPago.TARJETA, adminMengano.getId(), cantidadesMengano1, productosMengano1);

        //Pedido 2 de Mengano: carne + queso
        ArrayList<Integer> cantidadesMengano2 = new ArrayList<>();
        cantidadesMengano2.add(2);
        cantidadesMengano2.add(1);
        ArrayList<Producto> productosMengano2 = new ArrayList<>();
        productosMengano2.add(carne);
        productosMengano2.add(queso);
        Pedido pedidoMengano2 = pedidoService.createPedido(FormaPago.EFECTIVO, adminMengano.getId(), cantidadesMengano2, productosMengano2);

        System.out.println("Datos de prueba cargados correctamente.\n");
        
        MenuPrincipal.seleccionOpciones(categoriaService, productoService, usuarioService, pedidoService);
        
    }
    
}
