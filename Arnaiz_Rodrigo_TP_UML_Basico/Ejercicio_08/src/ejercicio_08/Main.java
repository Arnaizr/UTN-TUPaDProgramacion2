package ejercicio_08;

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
        System.out.println("------ Documento -----\n"); 
        //Declaración/incialización de objetos con constructores 
        System.out.println("---- Inicio ----\n"); 
        //Creación de un usuario nuevo 
        Usuario usuario1 = new Usuario("Juan Perez", "juancitoperezito85@yahoo.com"); 
        //Creación de documento con atributos propios, atributos para la firmaDigital y agregación del usuario creado a la firma
        Documento documento1 = new Documento("Escritura 10293/26", "Escritura traslativa de dominio", "9c8245e6e0b74cfccg97e8714u3234228fb4xcd2", "16/05/26", usuario1); 
        //Se hace una impresión para verificar carga correcta
        System.out.println("\nImprimiendo objetos creados...\n"); 
        System.out.println(documento1); 
        System.out.println(usuario1); 
        
        documento1 = null; //Se "elimina" el documento para demostrar que la firma también se "destruye" pero el usuario sigue existiendo
        System.out.println("\nEliminando documento..."); 
        System.out.println(documento1); 
        System.out.println(usuario1); 
    }
    
}
