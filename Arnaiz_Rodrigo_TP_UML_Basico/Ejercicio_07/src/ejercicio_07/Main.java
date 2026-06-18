package ejercicio_07;

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
        System.out.println("------ Vehiculo -----\n"); 
        //Declaración/incialización de objetos con constructores 
        System.out.println("---- Inicio ----\n"); 
        //Creación de un conductor nuevo 
        Conductor conductor1 = new Conductor("Juan Perez", "31516165");
        //Creación de motor
        Motor motor1 = new Motor("Nafta", "HXJCH5559030"); 
        //Creación de vehiculo con atributos con el motor creado
        Vehiculo vehiculo1 = new Vehiculo("AA000ZZ", "Fiesta", motor1); 
        //Se hace una impresión para verificar carga correcta y la falta de asociación del conductor
        System.out.println("\nImprimiendo objetos creados...\n"); 
        System.out.println(vehiculo1); 
        System.out.println(motor1);
        System.out.println(conductor1); 
        
        conductor1.setVehiculo(vehiculo1); //Se asocia el vehiculo al conductor
        
        System.out.println("\nVehiculo y Conductor asociados:\n");
        
        //Se hace una nueva impresión para verificar la asociación bilateral
        System.out.println(conductor1);
        System.out.println(vehiculo1);
        System.out.println("");
        
        vehiculo1 = null; //Se elimina el vehiculo para demostrar que el motor sigue existiendo
        System.out.println("\nEliminando vehiculo..."); 
        System.out.println(vehiculo1); 
        System.out.println(motor1); 
    }
    
}
