package ejercicio_04;

/**
 *
 * @author RODRIGO
 */
public class TarjetaDeCredito {
    private String numero;
    private String fechaVencimiento;
    private Banco banco;
    private Cliente cliente;

    public TarjetaDeCredito(String numero, String fechaVencimiento, Banco banco) { //Constructor de atributos propios
        this.setNumero(numero);
        this.setFechaVencimiento(fechaVencimiento);
        this.setBanco(banco);
    } 
    
    public Cliente getCliente(){ //Getter para relación bidireccional con cliente
        return cliente;
    }
    public String getNumero(){ //Getter para mostrar datos en toString del cliente
        return numero;
    }
    
    private void setNumero(String numero) { //Setter privado para constructor
        if (validarString(numero)) {
            this.numero = numero;            
        }
    }
   
    private void setFechaVencimiento(String fechaVencimiento) { //Setter privado para constructor
        if (validarString(fechaVencimiento)) {
            this.fechaVencimiento = fechaVencimiento;
        }
    }
    private void setBanco(Banco banco) { //Setter privado para constructor
        if (banco != null) {
            this.banco = banco;            
        }
    }    
    public void setCliente(Cliente cliente) { //Setter bidireccional para cliente
        this.cliente = cliente;
        if (cliente != null && cliente.getTarjeta() != this) {
            cliente.setTarjeta(this);
        }
    }
    //override de toString para mostrar atributos
    @Override
    public String toString() {
        return "Tarjeta Nº: " + numero + ", Vencimiento: " + fechaVencimiento + ", " + banco + ", Cliente: " + (cliente !=null ? cliente.getNombre() : null) + ".";
    }
    
    
    
     //Validaciones
    //Método para verificar que un String no esté vacío o en null
    private static boolean validarString(String palabra) {
        boolean valido = true;
        if ((palabra == null) || (palabra.trim().equals(""))) { //Se eliminan espacios antes y delante del String y verifica que no esté vacío
            valido = false;
            System.out.println("ERROR: El campo no puede estar vacío.");
        }
        return valido;
}
    
}
