package interfaces;

/**
 *
 * @author RODRIGO
 */
public class Cliente implements Notificable{
    private String nombre;
    private String dni;
    private String email;
    private Pedido pedido;

    public Cliente(String nombre, String dni, String email) {
        this.setNombre(nombre);
        this.setDni(dni);
        this.setEmail(email);
    }
    public Pedido getPedido() {
        return pedido;
    }

    public String getEmail() {
        return email;
    }
    
    public void setNombre(String nombre) {
        if (nombre != null && !nombre.strip().equals("")){
        this.nombre = nombre;
        }
    }
    public void setDni(String dni) {
        if (dni != null && !dni.strip().equals("")){
        this.dni = dni;
        }
    }
    public void setEmail(String email) {
        if (email != null && !email.strip().equals("")){
        this.email = email;
        }
    }
    
    public void setPedido(Pedido pedido) { //Setter para asociación bidireccional
        this.pedido = pedido;
        if (pedido != null && pedido.getCliente() != this) {
            pedido.setCliente(this);
        }
    }

    @Override
    public String toString() {
        return "Cliente: " + nombre + ", (DNI: " + dni + ", Mail: " + email + ")";
    }

    @Override
    public void recibirNotificacion(String notificacion) { 
        System.out.println("Se recibió el estado del pedido, se encuentra: \"" + notificacion + "\"");
    }

    
}
