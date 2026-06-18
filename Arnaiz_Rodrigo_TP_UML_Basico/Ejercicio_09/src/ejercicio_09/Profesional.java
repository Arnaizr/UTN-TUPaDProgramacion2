package ejercicio_09;

/**
 *
 * @author RODRIGO
 */
public class Profesional {
    private String nombre;
    private String especialidad;
    
    public Profesional(String nombre, String especialidad){
        this.setNombre(nombre);
        this.setEspecialidad(especialidad);
    }
    
    private void setNombre(String nombre){
        if (validarString(nombre)) {
            this.nombre = nombre;
        }
    }
    
    private void setEspecialidad(String especialidad){
        if (validarString(especialidad)) {
            this.especialidad = especialidad;
        }
    }
    
    
    @Override
    public String toString() {
        return "Profesional: " + nombre + ", (especialidad: " + especialidad + ")";
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
