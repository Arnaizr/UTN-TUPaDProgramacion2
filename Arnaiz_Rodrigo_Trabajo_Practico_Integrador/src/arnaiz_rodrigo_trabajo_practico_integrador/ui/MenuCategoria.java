package arnaiz_rodrigo_trabajo_practico_integrador.ui;

import arnaiz_rodrigo_trabajo_practico_integrador.Service.CategoriaService;
import arnaiz_rodrigo_trabajo_practico_integrador.entities.Categoria;
import arnaiz_rodrigo_trabajo_practico_integrador.enums.CampoCategoria;
import arnaiz_rodrigo_trabajo_practico_integrador.exceptions.DuplicateEntityException;
import arnaiz_rodrigo_trabajo_practico_integrador.exceptions.EntityNotFoundException;
import arnaiz_rodrigo_trabajo_practico_integrador.exceptions.InvalidFieldException;


/**
 *
 * @author RODRIGO
 */
public class MenuCategoria {
    private static void mostrarOpciones(){
        System.out.println("\n--- CATEGORIAS ---");
        System.out.println("1. Listar");
        System.out.println("2. Crear");
        System.out.println("3. Editar");
        System.out.println("4. Eliminar");
        System.out.println("0. Volver al menú anterior");
    }
    
    public static void seleccionOpciones(CategoriaService categoriaService){
        int opcion;
        do {
            mostrarOpciones();
            System.out.println("\nIngrese una opción para continuar: ");
            opcion = MenuPrincipal.leerIntNoNegativo();
            switch (opcion){
                case 1 -> submenuListar(categoriaService);
                case 2 -> submenuCrear(categoriaService);
                case 3 -> submenuEditar(categoriaService);
                case 4 -> submenuEliminar(categoriaService);
                case 0 -> System.out.println("");
                default -> System.out.println("\"" + opcion + "\" no es una opción válida, inténtelo nuevamente.");
            }
        } while (opcion != 0);
    }
    
    //Mëtodo para listar las categorías
    public static void submenuListar(CategoriaService categoriaService){
        System.out.println("--- Listar Categorias ---\n");
        categoriaService.listarCategorias();
        MenuPrincipal.inputParaContinuar();
    }
    
    //Mëtodo para crear una categoría
    public static void submenuCrear (CategoriaService categoriaService){
        System.out.println("--- Crear Categoria ---\n");
        //Se listan las categorías para ver los datos y facilitar las pruebas
        categoriaService.listarCategorias();
        System.out.println("Por favor, ingrese el nombre de la nueva categoría: ");
        String nombreInput = MenuPrincipal.leerAtributo();
        System.out.println("Por favor, ingrese la descripción de la nueva categoría: ");
        String descripcionInput = MenuPrincipal.leerAtributo();
        try{
            Categoria nueva = categoriaService.createCategoria(nombreInput, descripcionInput);
            System.out.println("Se creó la categoría: " + nueva);
        }
        catch (DuplicateEntityException | InvalidFieldException e){
            System.out.println(e.getMessage());
        }
        MenuPrincipal.inputParaContinuar();
    }
    
    //Método para editar una categoría
    public static void submenuEditar (CategoriaService categoriaService){
        System.out.println("--- Editar Categoria ---\n");
        //Se listan las categorías para ver los datos y facilitar las pruebas
        categoriaService.listarCategorias();
        System.out.println("Por favor, ingrese el id de la categoría a editar: ");
        long idInput = MenuPrincipal.leerIntNoNegativo();
        System.out.println("Por favor, ingrese el campo que desea editar: ");
        CampoCategoria[] campos = CampoCategoria.values();
        for (int i = 0; i < campos.length; i++){
            System.out.println((i + 1) + " - " + campos[i]);
        }
        int indice = MenuPrincipal.leerIndiceValido(campos.length);
        CampoCategoria campoAEditar = campos[indice - 1];
        
        System.out.println("Ingrese el nuevo valor: ");
        String nuevoValor = MenuPrincipal.leerAtributo();
        try {
            categoriaService.editCategoria(idInput, campoAEditar, nuevoValor);
        }
        catch (EntityNotFoundException | DuplicateEntityException | InvalidFieldException e){
            System.out.println(e.getMessage());
        }
        MenuPrincipal.inputParaContinuar();
    }
    
    //Método para eliminar una categoría
    public static void submenuEliminar (CategoriaService categoriaService){
        System.out.println("--- Eliminar Categoria ---\n");
        //Se listan las categorías para ver los datos y facilitar las pruebas
        categoriaService.listarCategorias();
        System.out.println("Por favor, ingrese el id de la categoría a eliminar: ");
        long idInput = MenuPrincipal.leerIntNoNegativo();
        if (MenuPrincipal.confirmacion("Desea eliminar la categoría con id #" + idInput + " (S/N)")){
            categoriaService.deleteCategoriaById(idInput);
        }
        MenuPrincipal.inputParaContinuar();
    }
}
