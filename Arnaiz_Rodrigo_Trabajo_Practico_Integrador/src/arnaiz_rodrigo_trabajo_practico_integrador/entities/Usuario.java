package arnaiz_rodrigo_trabajo_practico_integrador.entities;

import arnaiz_rodrigo_trabajo_practico_integrador.enums.Rol;
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
    

    public Usuario(String nombre, String apellido, String mail, String celular, String contrasenia, Rol rol) {
        super(); 
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
        this.nombre = nombre;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }
    public void setCelular(String celular) {
        this.celular = celular;
    }
    public void setContrasenia(String contrasenia) {
        if (this.contrasenia == null){
            this.contrasenia = contrasenia;
        }
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
    //Método para eliminar un producto de la categoría (necesario para la relación bilateral
    public void eliminarPedido(Pedido pedido){
        if (pedido != null && pedidos.contains(pedido)){
            pedidos.remove(pedido);
            if (pedido.getUsuario() == this) {
                pedido.setUsuario(null);
            }
        }
    }
    //Método para calcular el total de los pedidos del usuario
    public void mostrarTotalPedidos(){
        double montoTotal = 0.0;
        System.out.println("================================================================");
        for (Pedido pedido : pedidos) {
            montoTotal += pedido.getTotal();
            System.out.println(pedido);
            pedido.mostrarDetalles(); //Se llama al pedido específico de cada pedido (tell, don't ask)
        }
        System.out.println("TOTAL ACUMULADO del usuario: $" + String.format("%.2f", montoTotal));
        System.out.println("================================================================");
    }
      
    @Override
    public String toString() {
        return "USUARIO: [" + nombre + " " + apellido + "] | Mail: [" + mail + "] | Celular: [" + celular + "] | Rol: [" + rol + "]";
    }
    
    
    
}
