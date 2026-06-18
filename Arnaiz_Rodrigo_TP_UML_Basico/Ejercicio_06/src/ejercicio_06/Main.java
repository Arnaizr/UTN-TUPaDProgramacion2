package ejercicio_06;

/**
 *
 * @author RODRIGO
 */
public class Main {

    public static void main(String[] args) {
        
        System.out.println("---- PROGRAMACIÓN II ----"); 
        System.out.println("--------- UML ---------\n"); 
        System.out.println("------ Reserva -----\n"); 
        //Declaración/incialización de objetos con constructores 
        System.out.println("---- Inicio ----\n"); 
        //Creación de un cliente nuevo 
        Cliente cliente1 = new Cliente("Juan Perez", "+5492213333333");
        //Creación de mesa
        Mesa mesa4 = new Mesa(4, 4); //Obviar comentario: Sale sale sale cuarteto express
        //Creación de reserva con atributos con la mesa creada
        Reserva reserva1 = new Reserva("15/05/26", "20:00", mesa4); 
        //Se hace una impresión para verificar carga correcta y la falta de asociación del cliente
        System.out.println("\nImprimiendo objetos creados...\n"); 
        System.out.println(reserva1); 
        System.out.println(mesa4);
        System.out.println(cliente1); 
        
        //Se asocia el cliente a la reserva 
        reserva1.setCliente(cliente1); 
        //Se hace una nueva impresión para verificar la asociación unilateral 
        System.out.println(""); 
        System.out.println(reserva1); 
        reserva1 = null; //Se elimina el libro para demostrar que la batería sigue existiendo
        System.out.println("\nEliminando reserva..."); 
        System.out.println(reserva1); 
        System.out.println(mesa4); 
    }
 }


