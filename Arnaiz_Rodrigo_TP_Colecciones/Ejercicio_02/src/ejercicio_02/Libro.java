package ejercicio_02;

/**
 *
 * @author RODRIGO
 */
public class Libro {
    private String isbn;
    private String titulo;
    private int anioPublicacion;
    private Autor autor;

    public Libro (String isbn, String titulo, int anioPublicacion, Autor autor){
        this.setIsbn(isbn);
        this.setTitulo(titulo);
        this.setAnioPublicacion(anioPublicacion);
        this.setAutor(autor);
    }

    public Autor getAutor() {
        return autor;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public String getIsbn() {
        return isbn;
    }

    //Setters
    private void setIsbn(String isbn) {
        if(validarString(isbn)){
            this.isbn = isbn;
        }
    }
    private void setTitulo(String titulo) {
        if(validarString(titulo)){
            this.titulo = titulo;
        }
    }
    private void setAnioPublicacion(int anioPublicacion) {
        if(validarIntNoNegativo(anioPublicacion)){
            this.anioPublicacion = anioPublicacion;
        }
    }
    private void setAutor(Autor autor){
        if (autor != null){
            this.autor = autor;
        } 
    }
    
    @Override
    public String toString() {
        return "Libro (ISBN: "+ isbn + "): " + titulo + ", año de publicación: " + anioPublicacion + ", " + autor;
    }
    
    //Métodos
    //Método para mostrar la info del producto
    public void mostrarInfo() {
        System.out.println(this.toString());
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
    //Método para validar que un int no sea negativo
    private static boolean validarIntNoNegativo(int num) {
        boolean valido = true;
        if (num < 0) {
            valido = false;
            System.out.println("ERROR: El valor ingresado no puede ser negativo.");
        }
        return valido;
    }
}
