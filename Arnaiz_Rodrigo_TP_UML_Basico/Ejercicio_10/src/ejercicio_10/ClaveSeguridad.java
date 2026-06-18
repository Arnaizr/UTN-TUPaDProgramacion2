package ejercicio_10;

/**
 *
 * @author RODRIGO
 */
public class ClaveSeguridad {
    private String codigo;
    private String ultimaModificacion;
    
    public ClaveSeguridad(String codigo, String ultimaModificacion){
        this.setCodigo(codigo);
        this.setUltimaModificacion(ultimaModificacion);
    }
    
    private void setCodigo(String codigo){
        if (validarString(codigo)){
            this.codigo = codigo;
        }
    }
    private void setUltimaModificacion(String ultimaModificacion){
        if (validarString(ultimaModificacion)){
            this.ultimaModificacion = ultimaModificacion;
        }
    }
    
    @Override public String 
    toString() { return "Clave: " + codigo + " (Ultima modificacion:  " + ultimaModificacion + ")";
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
