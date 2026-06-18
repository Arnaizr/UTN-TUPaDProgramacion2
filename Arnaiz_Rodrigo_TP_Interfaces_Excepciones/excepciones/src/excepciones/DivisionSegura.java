package excepciones;

import java.util.Scanner;

/**
 *
 * @author RODRIGO
 */
public class DivisionSegura {
    
    public int division (){
        Scanner sc = new Scanner(System.in);
        int resultado = 0;
        try{
            System.out.print("\nIngrese un número: ");
            int a = Integer.parseInt(sc.nextLine());
            System.out.print("Ingrese otro número: ");
            int b = Integer.parseInt(sc.nextLine());
            resultado = a/b;
        }
        catch (ArithmeticException exc0){
            System.out.println("\nNo se puede dividir por cero!!");
        }
        catch (NumberFormatException excformato){
            System.out.println("Sólo se aceptan números!!");
        }
        return resultado;
    }
}
