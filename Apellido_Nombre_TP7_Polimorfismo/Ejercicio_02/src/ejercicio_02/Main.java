package ejercicio_02;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author RODRIGO
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("\n---INICIO DEL PROGRAMA---\n");
        List<FiguraGeometrica> figuras = new ArrayList<>();
        
        figuras.add(new Circulo("Circulo 1", 1.5));
        figuras.add(new Circulo("Circulo 2", 2.3));
        figuras.add(new Circulo("Circulo 3", 3.2));
        figuras.add(new Rectangulo("Rectangulo 1", 2.2, 3));
        figuras.add(new Rectangulo("Rectangulo 2", 4.2, 2));
        figuras.add(new Rectangulo("Rectangulo 3", 3, 4));
    
        System.out.println("---Calculando áreas del array...\n");
        
        for (FiguraGeometrica figura : figuras) {
            figura.mostrarInfo();    
        }
        
        //Se verifica que el método mostrarInfo funciona en las subclases creando objetos específicos con downcasting
        System.out.println("\nCalculando áreas de figuras específicas...\n");
        Circulo c = (Circulo) figuras.get(0);
        c.mostrarInfo();
        Rectangulo r = (Rectangulo) figuras.get(3);
        r.mostrarInfo();
         System.out.println("\n---FIN DEL PROGRAMA---\n");
    }
    
}
