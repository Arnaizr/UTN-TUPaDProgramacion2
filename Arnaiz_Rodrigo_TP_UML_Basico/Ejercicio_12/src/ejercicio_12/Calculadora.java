package ejercicio_12;

/**
 *
 * @author RODRIGO
 */
public class Calculadora {
    public Calculadora(){ //Constructor sin atributos
    }
    public void calcular(Impuesto impuesto){ //Dependencia de uso para calcular el impuesto
        System.out.println("IVA: $" + String.format("%.2f" , impuesto.getMonto()*0.21) + ".");
    }
}
