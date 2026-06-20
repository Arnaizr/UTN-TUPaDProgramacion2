package arnaiz_rodrigo_trabajo_practico_integrador.Service;

import arnaiz_rodrigo_trabajo_practico_integrador.entities.Base;

/**
 *
 * @author RODRIGO
 */
public class Validaciones {
        //Método para validar que un int no sea negativo
    public static boolean validarIntNoNegativo(int num) {
        boolean valido = true;
        if (num < 0) {
            valido = false;
            System.out.println("ERROR: El valor ingresado no puede ser negativo.");
        }
        return valido;
    }
    //Método para validar un double positivo
    public static boolean validarDoublePositivo (double num) {
        boolean positivo = true;
        if (num <= 0){
            positivo = false;
            System.out.println("ERROR: El valor ingresado debe ser positivo.");
        }
    return positivo;
    }
    
    public static boolean compararPorId(Base actual, Object obj) {
    if (actual == obj) return true;
    if (obj == null || actual.getClass() != obj.getClass()) return false;
    Base otro = (Base) obj;
    return actual.getId() == otro.getId();
}
}
