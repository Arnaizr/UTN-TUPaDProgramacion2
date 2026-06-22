package arnaiz_rodrigo_trabajo_practico_integrador.Service;
import arnaiz_rodrigo_trabajo_practico_integrador.entities.Base;

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
    public static boolean validarDoublePositivo (double num) {
        return num < 0;
    }
    
    public static boolean validarStringNoVacio(String texto) {
        return (texto != null) && (!texto.trim().equals(""));
    }    
    
    public static boolean compararPorId(Base actual, Object obj) {
        if (actual == obj) return true;
        if (obj == null || actual.getClass() != obj.getClass()) return false;
        Base otro = (Base) obj;
        return actual.getId() == otro.getId();
    }
    
    public static boolean validarFormatoMail(String mail) {
        return mail != null && mail.contains("@") && !mail.contains(" ");
    }

}
