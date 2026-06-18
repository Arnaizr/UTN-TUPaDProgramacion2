package ejercicio_06;

/**
 *
 * @author RODRIGO
 */
public class Reserva { 
    private String fecha; 
    private String hora; 
    private Cliente cliente; 
    private Mesa mesa; 
    
    //Constructor con atributos propios y editorial como agregacion 
    public Reserva(String fecha, String hora, Mesa mesa){ 
    this.setFecha(fecha); 
    this.setHora(hora); 
    this.setMesa(mesa); 
    } 
    //Setters 
    private void setFecha(String fecha) { 
        if (validarString(fecha)){ 
            this.fecha = fecha; 
        } 
    } 
    private void setHora(String hora) { 
        if (validarString(hora)){
            this.hora = hora; 
        } 
    } 
    private void setMesa(Mesa mesa) {
        if (mesa != null){ 
            this.mesa = mesa; 
        }
    } 
    public void setCliente(Cliente cliente) { //Settter independiente del constructor para asociación unilateral 
    if (cliente != null){
        this.cliente = cliente; 
        } 
    }
    
    @Override public String 
    toString() { return "Reserva (fecha: " + fecha + ", hora: " + hora + "), " + (cliente !=null ? cliente : " Cliente: Sin datos") + ", " + mesa;
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

