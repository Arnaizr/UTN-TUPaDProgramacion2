package ejercicio_02;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author RODRIGO
 */
public class Biblioteca {
    private String nombre;
    private final List<Libro> libros;
    
    public Biblioteca (String nombre){
        this.setNombre(nombre);
        this.libros = new ArrayList<>();
    }
    
    //Setters
    private void setNombre(String nombre) {
        if(validarString(nombre)){
            this.nombre = nombre;
        }
    }

    @Override
    public String toString() {
        return "Biblioteca{" + "nombre=" + nombre + '}';
    }
    
    //Métodos
    //Método para crear un libro y agregarlo a la biblioteca
    public void agregarLibro(String isbn, String titulo,int anioPublicacion, Autor autor){
        this.libros.add(new Libro(isbn, titulo, anioPublicacion, autor));
    }
     //Métodoo para mostrar todos los libros de la biblioteca
    public void listarLibros(){
        if (libros.isEmpty()){
            System.out.println("No hay libros en el catálogo");
        }
        else{
            System.out.println("");
            for (Libro libro : libros) {
                libro.mostrarInfo();
            }
        }
    }
    //Método para buscar un libro por ISBN
    public Libro buscarLibroPorIsbn(String isbn){
        Libro libroEncontrado = null; //Se inicializa en null la variable de libro encontrado
        Iterator<Libro> it = this.libros.iterator(); //Se crea un iterador para la búsqueda
        while (it.hasNext() && libroEncontrado == null){ //Se repite mientras haya libros en la colección y mientras no encuentre el ISBN
            Libro l = it.next(); //Se carga el libro actual de la iteración de la colección
            if (l.getIsbn().equalsIgnoreCase(isbn)){
                libroEncontrado = l;
            }
        }
        return libroEncontrado;
    }
    
    //Método para eliminar un libro por su ISBN
    public void eliminarLibro(String isbn){
        Libro libroAEliminar = buscarLibroPorIsbn(isbn); //Se busca el libro con el ISBN ingresado
        if (libroAEliminar == null){
            System.out.println("No se encontró un libro con ISBN " + isbn);
        }
        else{
            libros.remove(libroAEliminar); //Se elimina el libro de la colección
            System.out.println("Se eliminó el libro con ISBN " + libroAEliminar.getIsbn());
        }
    }
    
    //Método para obtener el total de libros de la biblioteca
    public int obtenerCantidadLibros(){
        return libros.size();
    }
    
     //Método para filtrar libros por año
    public ArrayList<Libro> filtrarLibrosPorAnio(int anio){
        if (anio < 0) {
        System.out.println("ERROR: El año no puede ser negativo.");
        return new ArrayList<>();
        }
        ArrayList<Libro> librosFiltrados = new ArrayList<>(); //Se crea una nueva lista que almacena los libros del año ingresado
        for (Libro libro : libros) {
            if (anio == libro.getAnioPublicacion()){
                librosFiltrados.add(libro);
            }
        }
        return librosFiltrados;
    }
    
    //Método para listar todos los autores
    public void mostrarAutoresDisponibles(){
        ArrayList<Autor> listaAutores = new ArrayList<>(); //Se crea una nueva lista que almacena los autores de los libros en catálogo
        for (Libro libro : libros) {
            Autor autor = libro.getAutor(); //Carga el autor del libro actual
            if (!listaAutores.contains(autor)) {   // Evita duplicados en la lista de autores
                listaAutores.add(autor);
            }
        }
        for (Autor autor : listaAutores) {
            autor.mostrarInfo();
        }
    }
    
    //Validaciones
    //Método para verificar que un String no esté vacío o en null 
    private static boolean validarString(String palabra) {
        boolean valido = true;
        if ((palabra == null) || (palabra.trim().equals(""))) { //Se eliminan espacios antes y delante del String y verifica que no esté vacío
            valido = false;
            System.out.println("ERROR: El campo no puede estar vacío.");
        }
        return valido;
    }
}
