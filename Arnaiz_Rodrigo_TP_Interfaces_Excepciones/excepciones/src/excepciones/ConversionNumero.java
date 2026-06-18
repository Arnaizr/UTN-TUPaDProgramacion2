package excepciones;

import java.util.Scanner;

/**
 *
 * @author RODRIGO
 */
public class ConversionNumero {
    public int convertirNumero(){
        Scanner sc = new Scanner(System.in);
        int convertido = -1;
        try{
            System.out.print("\nIngrese un texto: ");
            String texto = sc.nextLine();
            convertido = Integer.parseInt(texto);
        }
        catch (NumberFormatException nfe){
            System.out.println("Sólo se aceptan números!!");
        }
        return convertido;
    }
}
