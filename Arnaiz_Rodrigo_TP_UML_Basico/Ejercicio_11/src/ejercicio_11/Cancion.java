package ejercicio_11;

/**
 *
 * @author RODRIGO
 */
public class Cancion {
    private String titulo; 
    private Artista artista;
    
    //Constructor con atributos propios 
    public Cancion(String titulo){ 
        this.setTitulo(titulo);  
    }
    //Getters
    public String getTitulo(){ //Getter para salida de datos en reproductor
        return titulo;
    }
    //Setters 
    private void setTitulo(String titulo) { 
        if (validarString(titulo)){ 
            this.titulo = titulo; 
        } 
    }  
    public void setArtista(Artista artista) { //Setter para asociación unidireccional de artista
        if (artista != null) {
            this.artista = artista;
        }
    }
    
    @Override public String 
    toString() { return "Cancion: " + titulo + ", " + (artista !=null ? artista : "Artista: Sin datos");
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
