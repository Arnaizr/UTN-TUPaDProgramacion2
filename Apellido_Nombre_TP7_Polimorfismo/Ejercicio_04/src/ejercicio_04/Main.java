package ejercicio_04;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author RODRIGO
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("\n---INICIO DEL PROGRAMA---\n");
        List<Animal> animales = new ArrayList<>();
        
        animales.add(new Vaca());
        animales.add(new Gato());
        animales.add(new Perro());
    
        System.out.println("---Recorriendo los animales del array...\n");
        
        for (Animal animal : animales) {
            animal.hacerSonido();
            System.out.println(animal.describirAnimal());
        }
        System.out.println("\n---FIN DEL PROGRAMA---\n");
    }
    
}
