package arnaiz_rodrigo_trabajo_practico_integrador.ui;

import arnaiz_rodrigo_trabajo_practico_integrador.Service.ProductoService;
import arnaiz_rodrigo_trabajo_practico_integrador.entities.Producto;
import arnaiz_rodrigo_trabajo_practico_integrador.exceptions.EntityNotFoundException;
import arnaiz_rodrigo_trabajo_practico_integrador.exceptions.InvalidFieldException;

/**
 *
 * @author RODRIGO
 */
public class MenuProducto {
    private static void mostrarOpciones(){
        System.out.println("\n--- PRODUCTOS ---\n");
        System.out.println("1. Listar");
        System.out.println("2. Crear");
        System.out.println("3. Editar");
        System.out.println("4. Eliminar");
        System.out.println("0. Volver al menú anterior");
    }
    
    public static void seleccionOpciones(ProductoService productoService){
        int opcion;
        do {
            mostrarOpciones();
            System.out.println("\nIngrese una opción para continuar: ");
            opcion = MenuPrincipal.leerIntNoNegativo();
            switch (opcion){
                case 1 -> submenuListar(productoService);
                case 2 -> submenuCrear(productoService);
                case 3 -> submenuEditar(productoService);
                case 4 -> submenuEliminar(productoService);
                case 0 -> System.out.println("");
                default -> System.out.println("\"" + opcion + "\" no es una opción válida, inténtelo nuevamente.");
            }
        } while (opcion != 0);
    }
    
    
     //Método para listar los productos
    public static void submenuListar(ProductoService productoService){
        System.out.println("\n--- Listar Productos ---\n");
        productoService.listarProductos();
        MenuPrincipal.inputParaContinuar();
    }
    
    
    //Método para crear un producto
    public static void submenuCrear (ProductoService productoService){
        System.out.println("\n--- Crear Producto ---\n");
        //Se listan los productos para ver los datos y facilitar las pruebas
        productoService.listarProductos();
        System.out.println("Por favor, ingrese el nombre del nuevo producto: ");
        String nombreInput = MenuPrincipal.leerAtributo();
        System.out.println("Por favor, ingrese la descripción del nuevo producto: ");
        String descripcionInput = MenuPrincipal.leerAtributo();
        System.out.println("Por favor, ingrese el precio del nuevo producto: ");
        double precioInput = MenuPrincipal.leerDoublePositivo();
        System.out.println("Por favor, ingrese el stock inicial del nuevo producto: ");
        int stockInput = MenuPrincipal.leerIntNoNegativo();
        System.out.println("Por favor, ingrese la ruta de la imagen del nuevo producto: ");
        String imagenInput = MenuPrincipal.leerAtributo();
        boolean disponibilidadInput = MenuPrincipal.confirmacion("Por favor, ingrese la disponibilidad inicial del nuevo producto (S/N): ");
        System.out.println("Por favor, ingrese el id de la categoría asociada al nuevo producto: ");
        long idCategoriaInput = MenuPrincipal.leerIntNoNegativo();
        try{
            Producto nuevo = productoService.createProducto(nombreInput, precioInput, descripcionInput, stockInput, imagenInput, disponibilidadInput, idCategoriaInput);
            System.out.println("Se creó el producto: " + nuevo);
        }
        catch (InvalidFieldException | EntityNotFoundException e){
            System.out.println(e.getMessage());
        }
        MenuPrincipal.inputParaContinuar();
    }
    
    
    //Método para editar un producto
    public static void submenuEditar (ProductoService productoService){
        System.out.println("\n--- Editar Producto ---\n");
        //Se listan los productos para ver los datos y facilitar las pruebas
        productoService.listarProductos();
        System.out.println("Por favor, ingrese el id del producto a editar: ");
        long idInput = MenuPrincipal.leerIntNoNegativo();
        //Se inicializan todos los atributos del producto en null para enviar como parámetros
        String nombreInput = null;
        Double precioInput = null;
        String descripcionInput = null;
        Integer stockInput = null;
        String imagenInput = null;
        Boolean disponibleInput = null;
        Long idCategoriaInput = null;
        //Se pregunta por todos los atributos que se desean modificar
        if (MenuPrincipal.confirmacion("¿Desea modificar el nombre? (S/N)")){
            System.out.println("Ingrese el nuevo nombre: ");
            nombreInput = MenuPrincipal.leerAtributo();
        }
        if (MenuPrincipal.confirmacion("¿Desea modificar el precio? (S/N)")){
            System.out.println("Ingrese el nuevo precio: ");
            precioInput = MenuPrincipal.leerDoublePositivo();
        }
        if (MenuPrincipal.confirmacion("¿Desea modificar la descripción? (S/N)")){
            System.out.println("Ingrese la nueva descripción: ");
            descripcionInput = MenuPrincipal.leerAtributo();
        }
        if (MenuPrincipal.confirmacion("¿Desea modificar el stock? (S/N)")){
            System.out.println("Ingrese el nuevo stock: ");
            stockInput = MenuPrincipal.leerIntNoNegativo();
        }
        if (MenuPrincipal.confirmacion("¿Desea modificar la imagen? (S/N)")){
            System.out.println("Ingrese la nueva ruta de imagen: ");
            imagenInput = MenuPrincipal.leerAtributo();
        }
        if (MenuPrincipal.confirmacion("¿Desea modificar la disponibilidad? (S/N)")){
            disponibleInput = MenuPrincipal.confirmacion("¿El producto está disponible? (S/N)");
        }
        if (MenuPrincipal.confirmacion("¿Desea modificar la categoría? (S/N)")){
            System.out.println("Ingrese el id de la nueva categoría: ");
            idCategoriaInput = (long) MenuPrincipal.leerIntNoNegativo();
        }

        try {
            //Se envían todos los parámetros y productoService maneja internamente cuáles son != null y los edita
            productoService.editProducto(idInput, nombreInput, precioInput, descripcionInput, stockInput, imagenInput, disponibleInput, idCategoriaInput);
        }
        catch (EntityNotFoundException | InvalidFieldException e){
            System.out.println(e.getMessage());
        }
        MenuPrincipal.inputParaContinuar();
    }
    
    
    //Método para eliminar un producto
    public static void submenuEliminar(ProductoService productoService){
        System.out.println("\n--- Eliminar Producto ---\n");
        productoService.listarProductos();
        System.out.println("Por favor, ingrese el id del producto a eliminar: ");
        long idInput = MenuPrincipal.leerIntNoNegativo();
        if (MenuPrincipal.confirmacion("¿Desea eliminar el producto con id #" + idInput + "? (S/N)")){
            productoService.deleteProductoById(idInput);
        }
        MenuPrincipal.inputParaContinuar();
    }
}