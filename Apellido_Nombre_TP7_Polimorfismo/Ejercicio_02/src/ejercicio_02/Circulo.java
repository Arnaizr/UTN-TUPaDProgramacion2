package ejercicio_02;

/**
 *
 * @author RODRIGO
 */
public class Circulo extends FiguraGeometrica {
    private double radio;
    
    public Circulo(String nombre, double radio) {
        super(nombre);
        this.setRadio(radio);
    }

    
    private void setRadio(double radio) {
        if (radio > 0){
            this.radio = radio;
        }
    }
    @Override
    public double calcularArea() {
        return Math.pow(radio, 2) * Math.PI;
    }

}
