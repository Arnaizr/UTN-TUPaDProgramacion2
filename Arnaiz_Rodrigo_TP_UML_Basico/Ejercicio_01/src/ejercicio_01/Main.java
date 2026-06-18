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
        System.out.println("---- PROGRAMACIÓN II ----");
        System.out.println("--------- UML ---------\n");
        System.out.println("------ Pasaporte -----\n");

        //Declaración/incialización de objetos con constructores
        System.out.println("---- Inicio ----\n");
        //Creación de pasaporte con atributos para foto
        Pasaporte pasaporte1 = new Pasaporte("A35198132", "12/05/2026", "fotofrontal", "png");
        //Creación de titular
        Titular titular1 = new Titular("Juan Pérez", "35198132");
        
        //Se hace una impresión para verificar carga correcta y la falta de asociación bilateral
        System.out.println(pasaporte1);
        System.out.println(titular1);
        System.out.println("");
        titular1.setPasaporte(pasaporte1); //Se hace la asignación del pasaporte al titular
        
        //Se hace una nueva impresión para verificar la asociación bilateral
        System.out.println("Pasaporte y titular asociados: ");
        System.out.println(titular1.getPasaporte()); //Se puede ver que el titular también se asoció al pasaporte
        System.out.println(pasaporte1.getTitular()); //Se puede ver que el pasaporte está asociado al titular
    }
    
}
