package arnaiz_rodrigo_trabajo_practico_integrador.Service;

import arnaiz_rodrigo_trabajo_practico_integrador.entities.Usuario;
import arnaiz_rodrigo_trabajo_practico_integrador.enums.CampoUsuario;
import arnaiz_rodrigo_trabajo_practico_integrador.enums.Rol;
import arnaiz_rodrigo_trabajo_practico_integrador.exceptions.IncorrectPasswordException;
import arnaiz_rodrigo_trabajo_practico_integrador.exceptions.DuplicateMailException;
import arnaiz_rodrigo_trabajo_practico_integrador.exceptions.EntityNotFoundException;
import arnaiz_rodrigo_trabajo_practico_integrador.exceptions.InvalidFieldException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author RODRIGO
 */
public class UsuarioService {
    private final List<Usuario> usuarios;
    
    public UsuarioService(){
        this.usuarios = new ArrayList<>();
    }
    
    public void listarUsuarios(){
        List<Usuario> activos = new ArrayList<>();
        for (Usuario usuario : usuarios) {
            if (!usuario.isEliminado()){
                activos.add(usuario);
            }
        }
        if (activos.isEmpty()){
            System.out.println("No hay usuarios cargados en el sistema.");
            return;
        }
        System.out.println("================================================================");
        for (Usuario usuario : activos) {
            System.out.println(usuario);
        }
        System.out.println("================================================================");
    }
    
    public Usuario createUsuario(String nombre, String apellido, String mail, String celular, String contrasenia, Rol rol){
        if (existeMail(mail)){
            throw new DuplicateMailException("Ya existe un usuario con el mail: " + mail);
        }
        Usuario nuevo = new Usuario(nombre, apellido, mail, celular, contrasenia, rol);
        usuarios.add(nuevo);
        return nuevo;        
    }
    //Método para buscar un usuario por su id asociado
    public Usuario findUsuarioById(long id){
        Usuario usuarioEncontrado = null; //Se inicializa en null la variable de usuario encontrado
        Iterator<Usuario> it = this.usuarios.iterator(); //Se crea un iterador para la búsqueda
        while (it.hasNext() && usuarioEncontrado == null){ //Se repite mientras haya usuarios en la colección y mientras no encuentre el usuario
            Usuario usuarioBucle = it.next(); //Se carga el usuario actual de la iteración de la colección
            if (id == usuarioBucle.getId()&& !usuarioBucle.isEliminado()){
                usuarioEncontrado = usuarioBucle;
            }
        }
        if (usuarioEncontrado == null){
            throw new EntityNotFoundException ("No se encontró un usuario con id: " + id);
        }
        return usuarioEncontrado;
    }
    //Método para eliminar un usuario por su id
    public void deleteUsuarioById(long id){
        try {
            Usuario usuarioAEliminar = findUsuarioById(id); //Se busca el usuario con el id ingresado
            usuarioAEliminar.setEliminado(true); //Se hace la baja lógica del usuario
            System.out.println("Se eliminó el usuario con id: " + id);
        }
        catch (EntityNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
    
    public void editUsuario(long id, CampoUsuario campo, String nuevoValor){
        try{
            Usuario usuarioAEditar = findUsuarioById(id);
            switch (campo){
                case NOMBRE -> usuarioAEditar.setNombre(nuevoValor);
                case APELLIDO -> usuarioAEditar.setApellido(nuevoValor);
                case MAIL -> {
                            if (existeMail(nuevoValor)){ throw new DuplicateMailException("Ya existe un usuario con el mail: " + nuevoValor);}
                            usuarioAEditar.setMail(nuevoValor);
                            }
                case CELULAR -> usuarioAEditar.setCelular(nuevoValor);
                case ROL -> usuarioAEditar.setRol(Rol.valueOf(nuevoValor));
                }
            System.out.println("Se cambió el atributo " + campo.name() + " del usuario : #" + usuarioAEditar.getId() + " por: " + nuevoValor + ".");
        }
        catch (EntityNotFoundException | DuplicateMailException | InvalidFieldException e){
            System.out.println(e.getMessage());
        }
    }
    
    public void cambiarContrasenia(long id, String contraseniaActual, String contraseniaNueva){
        try{
            Usuario usuario = findUsuarioById(id);
            if (!usuario.verificarContrasenia(contraseniaActual)){
                throw new IncorrectPasswordException("La contraseña actual ingresada no es correcta.");
            }
            usuario.setContrasenia(contraseniaNueva);
            System.out.println("Se cambió la contraseña del usuario : #" + id + ".");
        }
        catch (EntityNotFoundException | IncorrectPasswordException e){
            System.out.println(e.getMessage());
        }
    }
    
    private boolean existeMail(String mail){
        boolean existe = false;
        for (Usuario usuario : usuarios) {
            if (usuario.getMail().equals(mail)){
                existe = true;
            }
        }
        return existe;
    }
}
