package ejercicio_01;

/**
 *
 * @author RODRIGO
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("\n---INICIO DEL PROGRAMA---\n");
        
        Vehiculo v = new Vehiculo("Fiat", "600");
        System.out.println(v.mostrarInfo());
        
        
        Auto a = new Auto("Ford", "Fiesta", 4);
        System.out.println(a.mostrarInfo());
        
        System.out.println("\n---FIN DEL PROGRAMA---\n");
    }
    
}
