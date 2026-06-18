package ejercicio_11;

/**
 *
 * @author RODRIGO
 */
public class Reproductor {
    public Reproductor(){ //Constructor sin atributos
    }
    public void reproducir(Cancion cancion){ //Dependencia de uso para reproducir clase cancion
        System.out.println("Reproduciendo: ♫♫ " + cancion.getTitulo() + " ♫♫");
    }
}
