package ejercicio_05;

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
        System.out.println("------ Computadora -----\n");

        //Declaración/incialización de objetos con constructores
        System.out.println("---- Inicio ----\n");
        
        //Creación de computadora con atributos propios y atributos para la placa madre
        Computadora computadora1 = new Computadora("ASUS", "55533355888999", "TUF GAMING A17", "FA706IH");
        //Creación de propietario
        Propietario propietario1 = new Propietario("Juan Pérez", "35198132");
        
        //Se hace una impresión para verificar carga correcta y la falta de asociación bilateral
        System.out.println(computadora1);
        System.out.println(propietario1);
        System.out.println("");
        propietario1.setComputadora(computadora1); //Se asocia la computadora al propietario 
        
        System.out.println("Computadora y Propietario asociados:");
        
        //Se hace una nueva impresión para verificar la asociación bilateral
        System.out.println(propietario1.getComputadora());
        System.out.println(computadora1.getPropietario() + "\n");
        
        
    }
    

}
