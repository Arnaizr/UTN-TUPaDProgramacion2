package arnaiz_rodrigo_trabajo_practico_integrador.ui;

import arnaiz_rodrigo_trabajo_practico_integrador.Service.UsuarioService;
import arnaiz_rodrigo_trabajo_practico_integrador.entities.Usuario;
import arnaiz_rodrigo_trabajo_practico_integrador.enums.CampoUsuario;
import arnaiz_rodrigo_trabajo_practico_integrador.enums.Rol;
import arnaiz_rodrigo_trabajo_practico_integrador.exceptions.DuplicateMailException;
import arnaiz_rodrigo_trabajo_practico_integrador.exceptions.EntityNotFoundException;
import arnaiz_rodrigo_trabajo_practico_integrador.exceptions.InvalidFieldException;

/**
 *
 * @author RODRIGO
 */
public class MenuUsuario {

    private static void mostrarOpciones(){
        System.out.println("\n--- USUARIOS ---\n");
        System.out.println("1. Listar");
        System.out.println("2. Crear");
        System.out.println("3. Editar");
        System.out.println("4. Eliminar");
        System.out.println("5. Informar historial de pedidos de un usuario");
        System.out.println("0. Volver al menú anterior");
    }
    
    public static void seleccionOpciones(UsuarioService usuarioService){
        int opcion;
        do {
            mostrarOpciones();
            System.out.println("\nIngrese una opción para continuar: ");
            opcion = MenuPrincipal.leerIntNoNegativo();
            switch (opcion){
                case 1 -> submenuListar(usuarioService);
                case 2 -> submenuCrear(usuarioService);
                case 3 -> submenuEditar(usuarioService);
                case 4 -> submenuEliminar(usuarioService);
                case 5 -> submenuMostrarHistorialDeUsuario(usuarioService);
                case 0 -> System.out.println("");
                default -> System.out.println("\"" + opcion + "\" no es una opción válida, inténtelo nuevamente.");
            }
        } while (opcion != 0);
    }
    
     //Método para listar los usuarios
    public static void submenuListar(UsuarioService usuarioService){
        System.out.println("\n--- Listar Usuarios ---\n");
        usuarioService.listarUsuarios();
    }
    
    //Método para crear un usuario
    public static void submenuCrear (UsuarioService usuarioService){
        System.out.println("\n--- Crear Usuario ---\n");
        //Se listan los usuarios para ver los datos y facilitar las pruebas
        usuarioService.listarUsuarios();
        System.out.println("Por favor, ingrese el nombre del nuevo usuario: ");
        String nombreInput = MenuPrincipal.leerAtributo();
        System.out.println("Por favor, ingrese el apellido del nuevo usuario: ");
        String apellidoInput = MenuPrincipal.leerAtributo();
        System.out.println("Por favor, ingrese el mail del nuevo usuario: ");
        String mailInput = MenuPrincipal.leerAtributo();
        System.out.println("Por favor, ingrese el celular del nuevo usuario: ");
        String celularInput = MenuPrincipal.leerAtributo();
        System.out.println("Por favor, ingrese la contraseña del nuevo usuario: ");
        String contraseniaInput = MenuPrincipal.leerAtributo();
        System.out.println("Por favor, ingrese el rol del usuario: ");
        Rol[] roles = Rol.values();
        for (int i = 0; i < roles.length; i++){
            System.out.println((i + 1) + " - " + roles[i]);
        }
        int indiceRol = MenuPrincipal.leerIndiceValido(roles.length);
        Rol rolInput = roles[indiceRol - 1];
        try{
            Usuario nuevo = usuarioService.createUsuario(nombreInput, apellidoInput, mailInput, celularInput, contraseniaInput, rolInput);
            System.out.println("Se creó el usuario: " + nuevo);
        }catch (InvalidFieldException | DuplicateMailException e){
            System.out.println(e.getMessage());
        }
        MenuPrincipal.inputParaContinuar();
    }
    
    
        //Método para editar un usuario
    public static void submenuEditar (UsuarioService usuarioService){
        System.out.println("\n--- Editar Usuario ---\n");
        //Se listan los usuarios para ver los datos y facilitar las pruebas
        usuarioService.listarUsuarios();
        System.out.println("Por favor, ingrese el id del usuario a editar: ");
        long idInput = MenuPrincipal.leerIntNoNegativo();

        System.out.println("Por favor, ingrese el campo que desea editar: ");
        CampoUsuario[] campos = CampoUsuario.values();
        for (int i = 0; i < campos.length; i++){
            System.out.println((i + 1) + " - " + campos[i]);
        }
        int indice = MenuPrincipal.leerIndiceValido(campos.length);
        CampoUsuario campoAEditar = campos[indice - 1];
        
        if (campoAEditar == CampoUsuario.CONTRASENIA){ //Se llama al método cambiar contraseña dado que recibe dos parámetros
            System.out.println("Ingrese la contraseña actual: ");
            String contraseniaActual = MenuPrincipal.leerAtributo();
            System.out.println("Ingrese la nueva contraseña: ");
            String contraseniaNueva = MenuPrincipal.leerAtributo();
            usuarioService.cambiarContrasenia(idInput, contraseniaActual, contraseniaNueva);
            MenuPrincipal.inputParaContinuar();
            return;
        }
        
        System.out.println("Ingrese el nuevo valor: ");
        String nuevoValor;
        if (campoAEditar == CampoUsuario.ROL){ //Si el campo es rol se convierte a String para enviar por el método
            Rol[] roles = Rol.values();
            for (int i = 0; i < roles.length; i++){
                System.out.println((i + 1) + " - " + roles[i]);
            }
            int indiceRol = MenuPrincipal.leerIndiceValido(roles.length);
            nuevoValor = roles[indiceRol - 1].name();
        }
        else {
            nuevoValor = MenuPrincipal.leerAtributo();
        }

        usuarioService.editUsuario(idInput, campoAEditar, nuevoValor);//Se llama directamente al método porque maneja excepciones internamente
        MenuPrincipal.inputParaContinuar();
}
    
    //Método para eliminar un usuario
    public static void submenuEliminar (UsuarioService usuarioService){
        System.out.println("\n--- Eliminar Usuario ---\n");
        //Se listan los usuarios para ver los datos y facilitar las pruebas
        usuarioService.listarUsuarios();
        System.out.println("Por favor, ingrese el id del usuario a eliminar: ");
        long idInput = MenuPrincipal.leerIntNoNegativo();
        if (MenuPrincipal.confirmacion("¿Desea eliminar el usuario con id #" + idInput + "? (S/N)")){
            usuarioService.deleteUsuarioById(idInput);
        }
        MenuPrincipal.inputParaContinuar();
    }
    
    
    //Método para mostrar el historial de los pedidos activos de un usuario (eliminado o no)
    public static void submenuMostrarHistorialDeUsuario (UsuarioService usuarioService){
        System.out.println("\n--- Mostrar historial de pedidos de Usuario ---\n");
        //Se listan los usuarios todos los usuarios del historial para ver los datos y facilitar las pruebas
        usuarioService.listarUsuariosConEliminados();
        System.out.println("Por favor, ingrese el id del usuario del informe: ");
        long idInput = MenuPrincipal.leerIntNoNegativo();
        try{
            Usuario usuarioInforme = usuarioService.findUsuarioByIdWithEliminados(idInput);
            usuarioInforme.mostrarTotalPedidos();
        }
        catch (EntityNotFoundException e){
            System.out.println(e.getMessage());
        }
        MenuPrincipal.inputParaContinuar();
    }
}