package ejercicio_08;

/**
 *
 * @author RODRIGO
 */
public class FirmaDigital {
    private String codigoHash;
    private String fecha;
    private Usuario usuario;
    
    public FirmaDigital(String codigoHash, String fecha, Usuario usuario){
        this.setCodigoHash(codigoHash);
        this.setFecha(fecha);
        this.setUsuario(usuario);
    }
    
    private void setCodigoHash(String codigoHash){
        if (validarString(codigoHash)) {
            this.codigoHash = codigoHash;
        }
    }
    
    private void setFecha(String fecha){
        if (validarString(fecha)) {
            this.fecha = fecha;
        }
    }
        private void setUsuario(Usuario usuario){
        if (usuario != null) {
            this.usuario = usuario;
        }
    }

    
    
    @Override
    public String toString() {
        return "Firma: " + codigoHash + "(fecha: " + fecha + "), Usuario: " + (usuario != null ? usuario.getNombre() : "Sin usuario");
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
