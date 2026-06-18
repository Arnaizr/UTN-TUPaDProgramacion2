package ejercicio_14;

/**
 *
 * @author RODRIGO
 */
public class Render {
    private String formato; 
    private Proyecto proyecto;
    
    //Constructor con atributos propios 
    public Render(String formato){ 
        this.setFormato(formato);  
    }
   
    //Setters 
    private void setFormato(String formato) { 
        if (validarString(formato)){ 
            this.formato = formato; 
        } 
    }  
    public void setProyecto(Proyecto proyecto) { //Setter para asociación unidireccional de proyecto
        if (proyecto != null) {
            this.proyecto = proyecto;
        }
    }
    
    @Override public String 
    toString() { return "Formato: " + formato + ", " + (proyecto !=null ? proyecto : "Proyecto: Sin datos");
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
