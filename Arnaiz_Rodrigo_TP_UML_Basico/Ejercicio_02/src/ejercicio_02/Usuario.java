package ejercicio_02;

/**
 *
 * @author RODRIGO
 */
public class Usuario {
    private String nombre;
    private String dni;
    private Celular celular;
    
    public Usuario (String nombre, String dni) { //Constructor con atributos propios
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

    public Celular getCelular() { //Getter para asociación bidireccional
        return celular;
    }
    public String getNombre() { //Getter para mostrar datos por toString de Celular
        return nombre;
    }

    public void setCelular(Celular celular) { //Setter para asociación bidireccional
        this.celular = celular;
        if (celular != null && celular.getUsuario() != this) {
            celular.setUsuario(this);
        }
    }
    //Overrid de toString para mostrar datos
    @Override
    public String toString() {
        return "Nombre: " + nombre + ", DNI: " + dni + ", Celular imei Nº: " + (celular !=null ? celular.getImei() : null);
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
