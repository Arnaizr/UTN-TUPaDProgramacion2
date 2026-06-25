package arnaiz_rodrigo_trabajo_practico_integrador.Service;

/**
 *
 * @author RODRIGO
 */
public class Validaciones {
        //Método para validar que un int no sea negativo
    public static boolean validarIntNoNegativo(int num) {
        return num < 0;
    }
    //Método para validar un double positivo
    public static boolean validarDoubleNoNegativo (double num) {
        return num < 0;
    }
    
    public static boolean validarStringNoVacio(String texto) {
        return (texto != null) && (!texto.trim().equals(""));
    }    
    
    
    public static boolean validarFormatoMail(String mail) {
        return mail != null && mail.contains("@") && !mail.contains(" ");
    }
    
    
}
