package ejercicio_01;

/**
 *
 * @author RODRIGO
 */
public class Titular {
    private String nombre;
    private String dni;
    private Pasaporte pasaporte;
    
    public Titular (String nombre, String dni) { //Constructor con los atributos propios de la clase
        this.setNombre(nombre);
        this.setDni(dni);
    }
    //Setters propios
    private void setNombre(String nombre) {
        if (validarString(nombre)) {
        this.nombre = nombre;            
        }
    }
    
    private void setDni(String dni) {
        if (validarString(dni)) {
            this.dni = dni;            
        }    
    }
    //Getters 
    //Getter de pasaporte para la asociación bilateral
    public Pasaporte getPasaporte() {
        return pasaporte;
    }
    //Getter de nombre para la impresión de toString del pasaporte
    public String getNombre(){
        return nombre;
    }
    public void setPasaporte(Pasaporte pasaporte) {
        this.pasaporte = pasaporte;
        if (pasaporte != null && pasaporte.getTitular() != this) {
            pasaporte.setTitular(this);
        }
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", DNI: " + dni + ", Pasaporte nº: " + (pasaporte !=null ? pasaporte.getNumero() : null);
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
