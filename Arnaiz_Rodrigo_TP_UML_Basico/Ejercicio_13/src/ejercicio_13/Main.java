package ejercicio_13;

/**
 *
 * @author RODRIGO
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("---- PROGRAMACIÓN II ----"); 
        System.out.println("--------- UML ---------"); 
        System.out.println("--- CodigoQR ---\n"); 
        //Declaración/incialización de objetos con constructores 
        System.out.println("---- Inicio ----\n"); 
        //Creación de un usuario nuevo 
        Usuario usuario1 = new Usuario("Juan Perez", "juancitoperez85@yahoo.com.ar");  
        //Creación de un generador de QR
        GeneradorQR generador1 = new GeneradorQR();
        //Se hace una impresión para verificar carga correcta
        System.out.println("\nImprimiendo objetos creados...\n"); 
        System.out.println(usuario1); 
        System.out.println("");
        //Se genera un códigoQR con un valor y el usuario creado
        generador1.generar("alsgdkjbaljbvakjdfvn", usuario1); 
                
    
    }
    
}
