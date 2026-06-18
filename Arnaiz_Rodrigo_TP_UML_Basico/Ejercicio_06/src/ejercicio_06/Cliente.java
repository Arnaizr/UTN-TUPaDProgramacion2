package ejercicio_06;

/**
 *
 * @author RODRIGO
 */
public class Cliente { 
    private String nombre; 
    private String telefono; 

    //Constructor con atributos propios 
    public Cliente(String nombre, String telefono){ 
    this.setNombre(nombre); 
    this.setTelefono(telefono); 
    } 
    //Setters 
    private void setNombre(String nombre) { 
        if (validarString(nombre)){ 
            this.nombre = nombre; 
        } 
    } 
    private void setTelefono(String telefono) { 
        if (validarString(telefono)){
            this.telefono = telefono; 
        } 
    } 
    
    @Override public String 
    toString() { return "Cliente: " + nombre + " (tel: " + telefono + ")";
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
