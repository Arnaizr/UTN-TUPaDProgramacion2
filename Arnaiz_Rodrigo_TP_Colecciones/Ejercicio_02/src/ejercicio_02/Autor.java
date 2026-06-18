package ejercicio_02;

/**
 *
 * @author RODRIGO
 */
public class Autor {
    private final String id;
    private String nombre;
    private String nacionalidad;
    private static int contadorId = 0; //Se agrega un atributo static para crear un ID autoincremental

    public Autor (String nombre, String nacionalidad){
        contadorId++;
        this.id = String.format("A%03d", contadorId);   
        this.setNombre(nombre);
        this.setNacionalidad(nacionalidad);
    }

    //Setters
    private void setNombre(String nombre) {
        if(validarString(nombre)){
            this.nombre = nombre;
        }
    }
    private void setNacionalidad(String nacionalidad) {
        if(validarString(nacionalidad)){
            this.nacionalidad = nacionalidad;
        }
    }
    
    
    @Override
    public String toString() {
        return "Autor (ID: "+ id + "): " + nombre + ", Nacionalidad: " + nacionalidad;
    }
    
    //Métodos
    //Método para mostrar la info del producto
    public void mostrarInfo() {
        System.out.println(this.toString());
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