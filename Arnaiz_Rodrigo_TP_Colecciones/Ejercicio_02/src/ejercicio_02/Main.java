package ejercicio_02;
import java.util.ArrayList;
/**
 *
 * @author RODRIGO
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("\n---INICIO DEL PROGRAMA---\n\n");
        //Carga de nuevos libros con constructor completo
        Autor autor1 = new Autor("George R. R. Martin", "Estadounidense");
        Autor autor2 = new Autor("J. R. R. Tolkien", "Inglés");
        Autor autor3 = new Autor("Ernesto Sábato", "Argentino");
        Autor autor4 = new Autor("Luis María Pescetti", "Argentino");
        Autor autor5 = new Autor("Marcela Serrano Pérez", "Chilena");
        //Creación de una nueva biblioteca
        Biblioteca biblio1 = new Biblioteca("Tupac Amaru");
        //Creación e incorporación de libros a la biblioteca
        biblio1.agregarLibro("9789863578650", "Juego de Tronos", 1996, autor1);
        biblio1.agregarLibro("9789874598540", "Choque de Reyes", 1998, autor1);
        biblio1.agregarLibro("9789874450350", "Festín de Cuervos", 2005, autor1);
        biblio1.agregarLibro("9785557771210", "Danza de Dragones", 2011, autor1);
        biblio1.agregarLibro("9788445013557", "La Comunidad del Anillo", 1954, autor2);
        biblio1.agregarLibro("9786125027597", "El Túnel", 1948, autor3);
        biblio1.agregarLibro("9789877254259", "Nosotras que nos queremos tanto", 1991, autor5);
        biblio1.agregarLibro("9789504646549", "Caperucita Roja (tal como se lo contaron a Jorge)", 1996, autor4);
        //Listado de todos los libros en la biblioteca
        System.out.println("Listando todos los libros inventariados...");
        biblio1.listarLibros();
        //Buscar libro por ISBN
        System.out.println("\nMostrando información del libro con ISBN 9785557771210:");
        Libro libroBuscado = biblio1.buscarLibroPorIsbn("9785557771210");
        System.out.println(libroBuscado == null ? "No existe el item con ISBN 9785557771210" : libroBuscado);
        //Buscamos un libro con ID inexistente
        System.out.println("\nMostrando información del libro con ISBN 9785557771215:");
        libroBuscado = biblio1.buscarLibroPorIsbn("9785557771215");
        System.out.println(libroBuscado == null ? "No existe el item con ISBN 9785557771215" : libroBuscado);

        //Filtrar libros por año
        System.out.println("\nMostrando libros del año 1996");
        ArrayList<Libro> libros1996 = biblio1.filtrarLibrosPorAnio(1996);
        mostrarFiltrados(libros1996);
        
        //Eliminación de un libro por su ISBN
        System.out.println("\nEliminando el libro de ID 9789877254259");
        biblio1.eliminarLibro("9789877254259");
        //Intento de eliminacion de un libro inexistente
        System.out.println("\nEliminando el libro de ID 9789877254250");
        biblio1.eliminarLibro("9789877254259");
        //Mostrando la lista actualizada
        biblio1.listarLibros();
        //Mostrar el stock de todos los libros
        System.out.println("\nEl total de libros en la biblioteca es: " + biblio1.obtenerCantidadLibros() + ".\n");
       
       //Mostrando autores disponibles (No aparece el autor 5 dado que ya no está el libro en la biblioteca)
        System.out.println("Autores disponibles:");
       biblio1.mostrarAutoresDisponibles();
        System.out.println("\n\n----FIN DEL PROGRAMA----\n");
    }
    
    
    public static void mostrarFiltrados (ArrayList<Libro> filtrado){ //Método para mostrar el array con valores filtrados
        if (filtrado.isEmpty()){
            System.out.println("No se encontraron libros.");
        return;
    }
        for (Libro libro : filtrado) {
            libro.mostrarInfo();
        }
    }
}
