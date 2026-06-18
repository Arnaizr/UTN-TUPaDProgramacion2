package ejercicio_01;

/**
 *
 * @author RODRIGO
 */
public class Foto {
    
    private String imagen;
    private String formato;
    
    public Foto(String imagen, String formato){
        this.setImagen(imagen);
        this.setFormato(formato);
    }
    
    private void setImagen(String imagen){
        if (validarString(imagen)) {
            this.imagen = imagen;
        }
    }
    
    private void setFormato(String formato){
        if (validarString(formato)) {
            this.formato = formato;
        }
    }

    @Override
    public String toString() {
        return imagen + "." + formato;
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
