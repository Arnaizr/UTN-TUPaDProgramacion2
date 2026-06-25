package arnaiz_rodrigo_trabajo_practico_integrador.entities;

import arnaiz_rodrigo_trabajo_practico_integrador.Service.Validaciones;
import arnaiz_rodrigo_trabajo_practico_integrador.enums.Rol;
import arnaiz_rodrigo_trabajo_practico_integrador.exceptions.InvalidFieldException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author RODRIGO
 */
public class Usuario extends Base{
    private String nombre;
    private String apellido;
    private String mail;
    private String celular;
    private String contrasenia;
    private Rol rol;
    private final List<Pedido> pedidos;
    private static long contadorId = 0;  //Se crea un contador estático de clase para la instanciación automática del id
    

    public Usuario(String nombre, String apellido, String mail, String celular, String contrasenia, Rol rol) {
        super(++contadorId); //Se envía como parámetro el contador incrementado a la clase base
        this.setNombre(nombre);
        this.setApellido(apellido);
        this.setMail(mail);
        this.setCelular(celular);
        this.setContrasenia(contrasenia);
        this.setRol(rol);
        this.pedidos = new ArrayList<>();
    }
    //Getters
    public String getNombre() {
        return nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public String getMail() {
        return mail;
    }
    public String getCelular() {
        return celular;
    }
    public Rol getRol() {
        return rol;
    }
    public List<Pedido> getPedidos() {
        return Collections.unmodifiableList(pedidos);
    }
    //Setters
    public void setNombre(String nombre) {
        if (!Validaciones.validarStringNoVacio(nombre)){
            throw new InvalidFieldException("El nombre no puede estar vacío.");
        }
        this.nombre = nombre;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public void setMail(String mail) {
        if (!Validaciones.validarStringNoVacio(mail)){
            throw new InvalidFieldException("El mail no puede estar vacío.");
        }
        if (!Validaciones.validarFormatoMail(mail)){
            throw new InvalidFieldException("El formato del mail no es válido.");
        }
        this.mail = mail;
    }
    public void setCelular(String celular) {
        this.celular = celular;
    }
    public void setContrasenia(String contrasenia) {
            this.contrasenia = contrasenia;
    }
    public void setRol(Rol rol) {
        this.rol = rol;
    }
    //Métodos
    //Método para agregar un pedido al usuario garantizando relación bilateral
    public void agregarPedido (Pedido pedido){
        //Verificar que el pedido no sea null
        if (pedido == null){
            System.out.println("\nEl pedido no puede ser nulo.");
            return;
        }
        //Verificación que el pedido no existe ya en la lista de pedidos
        if (!pedidos.contains(pedido)){
            pedidos.add(pedido);
           //Se actualiza el usuario en el pedido agregado
           if (pedido.getUsuario() != this){
               pedido.setUsuario(this);
           }
        }
    }
    //Método para eliminar un pedido del usuario(necesario para la relación bilateral
    public void eliminarPedido(Pedido pedido){
        if (pedido != null && pedidos.contains(pedido)){
            pedidos.remove(pedido);
            if (pedido.getUsuario() == this) {
                pedido.setUsuario(null);
            }
        }
    }
    //Método para verificar si la contraseña ingresada es válida
    public boolean verificarContrasenia(String intento){
        return intento.equals(contrasenia);
    }
    //Método para calcular el total de los pedidos del usuario
    public void mostrarTotalPedidos(){
        double montoTotal = 0.0;
        System.out.println("=======================================================================================================");
        for (Pedido pedido : pedidos) {
            if (!pedido.isEliminado()){
            montoTotal += pedido.getTotal();
            System.out.println(pedido);
            pedido.mostrarDetalles(); //Se llama al pedido específico de cada pedido (tell, don't ask)
            }
        }
        System.out.println("TOTAL ACUMULADO del usuario: $" + String.format("%.2f", montoTotal));
        System.out.println("=======================================================================================================\n");
    }
      
    @Override
    public String toString() {
        return "USUARIO #" + getId() + ": [" + nombre + " " + apellido + "] | Mail: [" + mail + "] | Celular: [" + celular + "] | Rol: [" + rol + "]";
    }
    
    
    
}
