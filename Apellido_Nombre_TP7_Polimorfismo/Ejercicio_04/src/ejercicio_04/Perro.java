package ejercicio_04;

/**
 *
 * @author RODRIGO
 */
public class Perro extends Animal{
    @Override
    public void hacerSonido(){
        System.out.println("GUAU GUAU");
    }
    @Override
    public String describirAnimal(){
        return super.describirAnimal() + " Tiene hocico, mueve la cola y es un canino";
    }
}
