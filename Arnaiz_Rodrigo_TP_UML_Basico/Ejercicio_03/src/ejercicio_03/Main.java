package ejercicio_03;

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
        System.out.println("------ Libro -----\n");

        //Declaración/incialización de objetos con constructores
        System.out.println("---- Inicio ----\n");
        
        //Creación de un autor nuevo
        Autor autor1 = new Autor("J. R. R. Tolkien", "Inglaterra");
        //Creación de editorial
        Editorial editorial1 = new Editorial("Minotauro", "Calle Falsa 123");
        //Creación de libro con atributos con la editorial creada
        Libro libro1 = new Libro("El Hobbit", "8445071416", editorial1);
        
        //Se hace una impresión para verificar carga correcta y la falta de asociación del autor
        System.out.println("\nImprimiendo objetos creados...\n");
        System.out.println(libro1);
        System.out.println(editorial1);
        System.out.println(autor1);
        
        //Se asocia el autor al libro
        libro1.setAutor(autor1);
        System.out.println("\n" + autor1 + " asociado a " + libro1.getTitulo() + ".");
        //Se hace una nueva impresión para verificar la asociación unilateral
        System.out.println("");
        System.out.println(libro1);
        
        
        System.out.println("\nEliminando libro...");
        libro1 = null; //Se elimina el libro para demostrar que la batería sigue existiendo
        System.out.println(libro1);
        System.out.println(autor1);
    }
    
}
