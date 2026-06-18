package ejercicio_04;

/**
 *
 * @author RODRIGO
 */
public class Vaca extends Animal{
    
    @Override
    public void hacerSonido(){
        System.out.println("MUUUUUU");
    }
    @Override
    public String describirAnimal(){
        return super.describirAnimal() + " Tiene cuernos, ubre y es un rumiante";
    }
}
