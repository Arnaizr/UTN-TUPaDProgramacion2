package arnaiz_rodrigo_trabajo_practico_integrador.ui;

import arnaiz_rodrigo_trabajo_practico_integrador.Service.CategoriaService;
import arnaiz_rodrigo_trabajo_practico_integrador.Service.PedidoService;
import arnaiz_rodrigo_trabajo_practico_integrador.Service.ProductoService;
import arnaiz_rodrigo_trabajo_practico_integrador.Service.UsuarioService;
import arnaiz_rodrigo_trabajo_practico_integrador.Service.Validaciones;
import java.util.Scanner;

/**
 *
 * @author RODRIGO
 */
public class MenuPrincipal {
    //Inicialización de variable Scanner
    static Scanner sc = new Scanner(System.in);
    
    private static void mostrarOpciones(){
        System.out.println("--- Sistema de pedidos ---");
        System.out.println("--- MENÚ PRINCIPAL ---\n");
        System.out.println("1. Categorías");
        System.out.println("2. Productos");
        System.out.println("3. Usuarios");
        System.out.println("4. Pedidos");
        System.out.println("0. Salir");
    }
    
    public static void seleccionOpciones(CategoriaService categoriaService, ProductoService productoService, UsuarioService usuarioService, PedidoService pedidoService){
        int opcion;
        do {
            mostrarOpciones();
            System.out.println("\nIngrese una opción para continuar: ");
            opcion = leerIntNoNegativo();
            switch (opcion){
                case 1 -> MenuCategoria.seleccionOpciones(categoriaService);
                case 2 -> MenuProducto.seleccionOpciones(productoService);
                case 3 -> MenuUsuario.seleccionOpciones(usuarioService);
                case 4 -> MenuPedido.seleccionOpciones(pedidoService, productoService);
                case 0 -> System.out.println("Gracias por usar el sistema.");
                default -> System.out.println("\"" + opcion + "\" no es una opción válida, inténtelo nuevamente.");
            }
        } while (opcion != 0);
    }
    
    public static int leerIntNoNegativo(){
        int valor = 0;
        boolean valido = false;
        while (!valido){
            try {
                valor = Integer.parseInt(sc.nextLine().trim());
                valido = valor >= 0;
                if (!valido) System.out.println("El valor no puede ser negativo.");
            }
            catch (NumberFormatException e){
                System.out.println("Por favor ingrese un número válido.");
            }
        }
        return valor;
    }
    
    public static String leerAtributo(){
        String texto = "";
        boolean valido = false;
        while (!valido){
                texto = sc.nextLine().trim();
                valido = Validaciones.validarStringNoVacio(texto);
                if (!valido){System.out.println("Error: el campo no puede estar vacío.");}
            }
        return texto;
    }
        public static double leerDoublePositivo(){
        double valor = 0;
        boolean valido = false;
        while (!valido){
            try {
                valor = Double.parseDouble(sc.nextLine().trim());
                valido = valor > 0;
                if (!valido) System.out.println("El valor debe ser positivo.");
            }
            catch (NumberFormatException e){
                System.out.println("Por favor ingrese un número válido.");
            }
        }
        return valor;
    }
    public static boolean confirmacion(String mensaje){
        String texto = "";
        boolean valido = false;
        while (!valido){
                System.out.println(mensaje);
                texto = sc.nextLine().trim();
                valido = (texto.trim().toLowerCase().equals("s") || texto.trim().toLowerCase().equals("n"));
                if (!valido){System.out.println("Opción incorrecta. Ingrese \"S\" o \"N\"");}
            }
        return texto.equals("s");
    }
    
    public static int leerIndiceValido(int cantidadOpciones){
        int indice;
        boolean fueraDeRango;
        do {
            indice = leerIntNoNegativo();
            fueraDeRango = indice < 1 || indice > cantidadOpciones;
            if (fueraDeRango){
                System.out.println("Opción fuera de rango, intente nuevamente.");
            }
        } while (fueraDeRango);
        return indice;
    }
    
    public static void inputParaContinuar(){
        System.out.println("\nPresione ENTER para continuar...\n");
        sc.nextLine();
    }
}
