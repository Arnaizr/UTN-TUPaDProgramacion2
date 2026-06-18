package ejercicio_04;

/**
 *
 * @author RODRIGO
 */
public class Gato extends Animal{
    @Override
    public void hacerSonido(){
        System.out.println("MAU MAU");
    }
    @Override
    public String describirAnimal(){
        return super.describirAnimal() + " Tiene garras, bigotes y es un felino";
    }
}
