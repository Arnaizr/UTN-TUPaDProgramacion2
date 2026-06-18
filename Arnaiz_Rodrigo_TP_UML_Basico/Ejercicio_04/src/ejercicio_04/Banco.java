package ejercicio_04;

/**
 *
 * @author RODRIGO
 */
public class Banco {
    private String nombre;
    private String cuit;
    
    public Banco(String nombre, String cuit){ //Constructor de atributos propios
        this.setNombre(nombre);
        this.setCuit(cuit);
    }
    //Setters
    private void setNombre(String nombre){
        if (validarString(nombre)) {
            this.nombre = nombre;
        }
    }
    
    private void setCuit(String cuit){
        if (validarString(cuit)) {
            this.cuit = cuit;
        }
    }
    //override de toString para mostrar atributos
    @Override
    public String toString() {
        return "Banco: " + nombre;
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
