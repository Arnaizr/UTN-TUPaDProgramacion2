package ejercicio_08;

/**
 *
 * @author RODRIGO
 */
public class Documento {
    private String titulo;
    private String contenido;
    private final FirmaDigital firma;


    public Documento(String titulo, String contenido, String codigoHash, String fecha, Usuario usuario) { //Constructor de atributos propios y datos para la firma
        this.setTitulo(titulo);
        this.setContenido(contenido);
        this.firma = new FirmaDigital(codigoHash, fecha, usuario); //Se crea la computadora con la clase FirmaDigital como Composición
    }                                                               //Se envía el usuario para la agregación a la firma digital
    
    
    private void setTitulo(String titulo) { //Setter privado para constructor
        if (validarString(titulo)) {
            this.titulo = titulo;            
        }
    }
   
    private void setContenido(String contenido) { //Setter privado para constructor
        if (validarString(contenido)) {
            this.contenido = contenido;
        }
    }

    //override de toString para mostrar atributos
    @Override
    public String toString() {
        return "Documento: " + titulo + " (contenido: " + contenido + "), " + firma + ".";
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
