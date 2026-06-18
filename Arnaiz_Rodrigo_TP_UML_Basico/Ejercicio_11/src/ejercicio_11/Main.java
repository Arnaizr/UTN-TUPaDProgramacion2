package ejercicio_11;

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
        System.out.println("--- Reproductor ---\n"); 
        //Declaración/incialización de objetos con constructores 
        System.out.println("---- Inicio ----\n"); 
        //Creación de un titular nuevo 
        Cancion cancion1 = new Cancion("Mesa 4"); 
        //Creación de cuentaBancaria con atributos propios y atributos para la clave de seguridad
        Artista artista1 = new Artista("Kapanga", "Rock"); 
        //Creación de un reproductor
        Reproductor reproductor1 = new Reproductor();
        //Se hace una impresión para verificar carga correcta
        System.out.println("\nImprimiendo objetos creados...\n"); 
        System.out.println(cancion1); 
        System.out.println(artista1); 
        
        cancion1.setArtista(artista1); //Se asocia la canción al artista
        
        System.out.println("\nCancion y artista asociados:\n");
        
        //Se hace una nueva impresión para verificar la asociación 
        System.out.println(cancion1);
        System.out.println("");
        
        //Se usa la canción en el reproductor
        
        reproductor1.reproducir(cancion1);
    }
    
}
