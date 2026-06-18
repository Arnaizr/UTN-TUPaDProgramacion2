package ejercicio_14;

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
        System.out.println("--- Editor Video ---\n"); 
        //Declaración/incialización de objetos con constructores 
        System.out.println("---- Inicio ----\n"); 
        //Creación de un usuario nuevo 
        Proyecto proyecto1 = new Proyecto("Videoprueba", 3.5);  
        //Creación de un editor de video
        EditorVideo editor1 = new EditorVideo();
        //Se hace una impresión para verificar carga correcta
        System.out.println("\nImprimiendo objetos creados...\n"); 
        System.out.println(proyecto1); 
        System.out.println("");
        //Se genera una renderización con el formato y el video creado
        editor1.exportar("mp4", proyecto1); 
    }
    
}
