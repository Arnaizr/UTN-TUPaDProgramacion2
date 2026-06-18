package ejercicio_03;

/**
 *
 * @author RODRIGO
 */
public class Libro {
    private String titulo;
    private String isbn;
    private Autor autor;
    private Editorial editorial;
    
    public Libro(String titulo, String isbn, Editorial editorial){ //Constructor con atributos propios y editorial como agregacion
        this.setTitulo(titulo);
        this.setIsbn(isbn);
        this.setEditorial(editorial);
    }
    public String getTitulo(){//Getter para mensaje de asociación de autor
        return titulo;
    }
    //Setters
    private void setTitulo(String titulo) {
        if (validarString(titulo)){
            this.titulo = titulo;
        }
    }

    private void setIsbn(String isbn) {
        if (validarString(isbn)){    
            this.isbn = isbn;
        }
    }

    private void setEditorial(Editorial editorial) {
        if (editorial != null){
            this.editorial = editorial;
        }
    }
    
    public void setAutor(Autor autor) { //Settter independiente del constructor para asociación unilateral
        if (autor != null){
            this.autor = autor;
        }
    }


    @Override
    public String toString() {
        return "Libro: \"" + titulo + "\", ISBN: " + isbn + ", " + (autor !=null ? autor : " Autor: ¿Anónimo?") + ", " + editorial;
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
