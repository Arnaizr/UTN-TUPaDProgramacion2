package ejercicio_02;

/**
 *
 * @author RODRIGO
 */
public class Rectangulo extends FiguraGeometrica {
    private double base;
    private double altura;

    public Rectangulo(String nombre, double base, double altura) {
        super(nombre);
        this.setBase(base);
        this.setAltura(altura);
    }

   
    private void setBase(double base) {
        if (base > 0){
            this.base = base;
        }
                
    }

    private void setAltura(double altura) {
        if (altura > 0){
            this.altura = altura;
        }
                
    }
     @Override
    public double calcularArea() {
        return base * altura;
    }

}
