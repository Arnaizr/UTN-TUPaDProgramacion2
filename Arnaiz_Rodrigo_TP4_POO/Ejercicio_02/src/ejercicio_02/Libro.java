package ejercicio_02;

/**
 *
 * @author RODRIGO
 */
public class Libro {
 //Atributos
    private String titulo;
    private String autor;
    private static String editorial = "Independiente";

    //Constructores
    //Constructor principal (todos los parámetros)
    public Libro(String titulo, String autor, String editorial){
        this.setTitulo(titulo); //Se llama al setter para cargar el titulo
        this.setAutor(autor); //Se llama al setter para cargar el/la autor/a
        this.setEditorial(editorial); //Se llama al setter para cargar la editorial

    }
    //Constructor secundario
    public Libro(String titulo, String autor){
        this(titulo, autor, "Independiente"); //Se crea el objeto con la editorial predeterminada
    }

    //Getters y setters
    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }
    
    public static String getEditorial() {
        return editorial;
    }
  
    private void setTitulo(String titulo) { 
        if (validarString(titulo)) {       
            this.titulo = titulo;
            return;
        }
        this.titulo = "*Pendiente de carga*";
    }
    public void setAutor(String autor) {
        if (validarString(autor)){
            this.autor = autor;
            return;
        }
        this.autor = "*Pendiente de carga*";
    }
    private static void setEditorial(String editorial) {
        if (validarString(editorial)){
            Libro.editorial = editorial;
        }
    }
    
    //Métodos
    //Método para actualizar la editorial de los libros
    public static void cambiarEditorial (String nueva) {
        if (validarString(nueva)){ 
            setEditorial(nueva); //Se envía la nueva editorial al setter
            return;            
        }                     
        nueva = "*vacío*";
        System.out.println("No se pudo actualizar la editorial con el valor " + nueva + ".");
    }

    //Método para actualizar el titulo con un nuevo valor
    public void actualizarTitulo(String nuevoTitulo) { 
        if (validarString(nuevoTitulo)){ 
            setTitulo(nuevoTitulo); //Se envía el nuevo título al setter
            return;            
        }                     
        nuevoTitulo = "*vacío*";
        System.out.println("No se pudo actualizar titulo de " + titulo + " con el valor " + nuevoTitulo + ".");
    }                                 

    //Método para actualizar el titulo con un prefijo y un nuevo valor
    public void actualizarTitulo(String prefijo, String nuevoTitulo) { 
        if (validarString(nuevoTitulo) && validarString(prefijo)){ 
            nuevoTitulo = prefijo + " " + nuevoTitulo; //Si ambos string son válidos se concatenan
            setTitulo(nuevoTitulo); //Se envía el prefijo con el nuevo título concatenados al setter
            return;            
        }                                 
        else if ((prefijo == null) || (prefijo.trim().equals(""))){
            prefijo = "*vacío*";
        }
        else if ((nuevoTitulo == null) || (nuevoTitulo.trim().equals(""))){
            nuevoTitulo = "*vacío*";
        }
        System.out.println("No se pudo actualizar titulo de " + titulo + " con los valores " + prefijo + " y " + nuevoTitulo + ".");
    }

    @Override
    public String toString() {
        return "Libro {" + "Titulo = " + titulo + ", Autor/a = " + autor + ", Editorial = " + editorial + '}';
    }

    //Validadores
    private static boolean validarString(String palabra) {
        boolean valido = true;
        if ((palabra == null) || (palabra.trim().equals(""))) { //Se eliminan espacios antes y delante del String y verifica que no esté vacío
            valido = false;
            System.out.println("ERROR: El campo no puede estar vacío.");
        }
        return valido;
    }
       
}
