package ejercicio_03;

/**
 *
 * @author RODRIGO
 */
public class Editorial {
    private String nombre;
    private String direccion;
    
    public Editorial (String nombre, String direccion){
        this.setNombre(nombre);
        this.setDireccion(direccion);
    }

    public void setNombre(String nombre) {
        if (validarString(nombre)){
            this.nombre = nombre;
        }
    }

    public void setDireccion(String direccion) {
        if (validarString(direccion)){
        this.direccion = direccion;
        }
    }

    @Override
    public String toString() {
        return "Editorial: " + nombre;
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
