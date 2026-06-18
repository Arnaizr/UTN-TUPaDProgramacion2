package ejercicio_03;

/**
 *
 * @author RODRIGO
 */
public class Autor {
    private String nombre;
    private String nacionalidad;
    
    public Autor (String nombre, String nacionalidad){
        this.setNombre(nombre);
        this.setNacionalidad(nacionalidad);
    }

    public void setNombre(String nombre) {
        if (validarString(nombre)){
            this.nombre = nombre;
        }
    }
    
    public void setNacionalidad(String nacionalidad) {
        if (validarString(nacionalidad)){
            this.nacionalidad = nacionalidad;
        }
    }

    @Override
    public String toString() {
        return "Autor: " + nombre;
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
