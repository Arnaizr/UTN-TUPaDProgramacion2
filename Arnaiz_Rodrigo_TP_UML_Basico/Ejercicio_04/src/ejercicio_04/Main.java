package ejercicio_04;

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
        System.out.println("------ Tarjeta -----\n");

        //Declaración/incialización de objetos con constructores
        System.out.println("---- Inicio ----\n");
        
        //Creación de un banco nuevo
        Banco banco1 = new Banco("Banco Río", "30-55500888-0");
        //Creación de tarjeta con atributos con el banco creado
        TarjetaDeCredito tarjeta1 = new TarjetaDeCredito("3335 5566 6777 5555", "05/26", banco1);
        //Creación de cliente
        Cliente cliente1 = new Cliente("Juan Pérez", "35198132");
        
        //Se hace una impresión para verificar carga correcta y la falta de asociación bilateral
        System.out.println(tarjeta1);
        System.out.println(cliente1);
        System.out.println("");
        cliente1.setTarjeta(tarjeta1); //Se asocia el tarjeta al cliente 
        
        System.out.println("Tarjeta y Cliente asociados:");
        
        //Se hace una nueva impresión para verificar la asociación bilateral
        System.out.println(cliente1.getTarjeta());
        System.out.println(tarjeta1.getCliente() + "\n");
        
        System.out.println("Banco de la Tarjeta nº " + tarjeta1.getNumero() + ":");
        System.out.println(banco1);
        
        System.out.println("\nEliminando tarjeta...");
        tarjeta1 = null; //Se elimina el tarjeta para demostrar que la banco sigue existiendo
        System.out.println(tarjeta1);
        System.out.println(banco1);
    }
    
}
