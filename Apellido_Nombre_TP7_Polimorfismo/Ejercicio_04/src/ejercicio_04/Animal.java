package ejercicio_04;

/**
 *Animales y comportamiento sobrescrito
● Clase: Animal con método hacerSonido() y describirAnimal()
● Subclases: Perro, Gato, Vaca sobrescriben hacerSonido() con @Override
● Tarea: Crear lista de animales y mostrar sus sonidos con polimorfismo 
* No se declara la clase animal como abstracta dado que la consigna no lo especifica, a pesar
* de considerarse que debería hacerse de tal forma, de la misma manera se considera que los métodos
* hacerSonido y describirAnimal también deberían ser abstractos.
* También hubiese agregado atributos genéricos para la clase principal (como int cantidadPatas, boolean tieneCola o String color)
* y específicos para las subclases (String raza para perro, boolean esLechera para la vaca, etc.) para poder sobrecargar
* los constructores de las subclases con esos atributos y usando el constructor de la superclase con super() y también para
* hacer más versátil la salida del método describirAnimal.
 * @author RODRIGO
 */
public class Animal {
    public void hacerSonido(){
        
    }
    public String describirAnimal(){
        return "Es un animal.";
    }
}
