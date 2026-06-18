package ejercicio_13;

/**
 *
 * @author RODRIGO
 */
public class CodigoQR {
    private String valor; 
    private Usuario usuario;
    
    //Constructor con atributos propios 
    public CodigoQR(String valor){ 
        this.setValor(valor);  
    }
   
    //Setters 
    private void setValor(String valor) { 
        if (validarString(valor)){ 
            this.valor = valor; 
        } 
    }  
    public void setUsuario(Usuario usuario) { //Setter para asociación unidireccional de usuario
        if (usuario != null) {
            this.usuario = usuario;
        }
    }
    
    @Override public String 
    toString() { return "CódigoQR: " + valor + ", " + (usuario !=null ? usuario : "Usuario: Sin datos");
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
