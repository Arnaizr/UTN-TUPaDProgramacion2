package ejercicio_05;

/**
 *
 * @author RODRIGO
 */
public class Propietario {
    private String nombre;
    private String dni;
    private Computadora computadora;
    
    public Propietario (String nombre, String dni) { //Constructor con atributos propios
        this.setNombre(nombre);
        this.setDni(dni);
    }

    private void setNombre(String nombre) { //Setter para el constructor
        if (validarString(nombre)) {
        this.nombre = nombre;            
        }
    }
    
    private void setDni(String dni) { //Setter para el constructor
        if (validarString(dni)) {
            this.dni = dni;            
        }    
    }

    public Computadora getComputadora() { //Getter para asociación bidireccional
        return computadora;
    }
    public String getNombre() { //Getter para mostrar datos por toString de Computadora
        return nombre;
    }

    public void setComputadora(Computadora computadora) { //Setter para asociación bidireccional
        this.computadora = computadora;
        if (computadora != null && computadora.getPropietario() != this) {
            computadora.setPropietario(this);
        }
    }
    //Overrid de toString para mostrar datos
    @Override
    public String toString() {
        return "Nombre: " + nombre + ", DNI: " + dni + ", Computadora Nº: " + (computadora !=null ? computadora.getNumeroSerie() : "Sin computadora" + ".");
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
