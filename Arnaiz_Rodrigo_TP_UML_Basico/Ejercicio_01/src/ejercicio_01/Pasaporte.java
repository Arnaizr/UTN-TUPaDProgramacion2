package ejercicio_01;

/**
 *
 * @author RODRIGO
 */
public class Pasaporte {
    private String numero;
    private String fechaEmision;
    private final Foto foto;
    private Titular titular;

    public Pasaporte(String numero, String fechaEmision, String foto, String formato) { //Constructor de atributos propios
        this.setNumero(numero);
        this.setFechaEmision(fechaEmision);
        this.foto = new Foto(foto, formato); //Se crea el pasaporte con la clase foto como Composición
    } 
    
    public Titular getTitular(){ //Getter para relación bidireccional con titular
        return titular;
    }
    
    public String getNumero(){ //Getter para mostrar info en toString de titular
        return numero;
    }
    
    private void setNumero(String numero) { //Setter privado para constructor
        if (validarString(numero)) {
            this.numero = numero;            
        }
    }
    
    private void setFechaEmision(String fechaEmision) { //Setter privado para constructor
        if (validarString(fechaEmision)) {
            this.fechaEmision = fechaEmision;
        }
    }

    public void setTitular(Titular titular) { //Setter bidireccional para titular
        this.titular = titular;
        if (titular != null && titular.getPasaporte() != this) {
            titular.setPasaporte(this);
        }
    }

    @Override
    public String toString() {
        return "Pasaporte {" + "Numero: " + numero + ", Emision: " + fechaEmision + ", Foto: " + foto + ", Titular: " + (titular != null ? titular.getNombre() : null) + '}';
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
