package ejercicio_02;


/**
 *
 * @author RODRIGO
 */
public class Celular {
    private String imei;
    private String marca;
    private String modelo;
    private Bateria bateria;
    private Usuario usuario;

    public Celular(String imei, String marca, String modelo, Bateria bateria) { //Constructor de atributos propios
        this.setImei(imei);
        this.setMarca(marca);
        this.setModelo(modelo);
        this.setBateria(bateria);
    } 
    
    public Usuario getUsuario(){ //Getter para relación bidireccional con usuario
        return usuario;
    }
    public String getImei(){ //Getter para mostrar datos en toString del usuario
        return imei;
    }
    
    private void setImei(String imei) { //Setter privado para constructor
        if (validarString(imei)) {
            this.imei = imei;            
        }
    }
   
    private void setMarca(String marca) { //Setter privado para constructor
        if (validarString(marca)) {
            this.marca = marca;
        }
    }
    private void setModelo(String modelo) { //Setter privado para constructor
        if (validarString(modelo)) {
            this.modelo = modelo;            
        }
    }
    private void setBateria(Bateria bateria) { //Setter privado para constructor
        if (bateria != null) {
            this.bateria = bateria;            
        }
    }    
    public void setUsuario(Usuario usuario) { //Setter bidireccional para usuario
        this.usuario = usuario;
        if (usuario != null && usuario.getCelular() != this) {
            usuario.setCelular(this);
        }
    }
    //override de toString para mostrar atributos
    @Override
    public String toString() {
        return "Celular {" + "Imei: " + imei + ", Marca: " + marca + ", Modelo: " + modelo + ", Bateria: " + bateria + ", Usuario: " + (usuario !=null ? usuario.getNombre() : null) + '}';
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
