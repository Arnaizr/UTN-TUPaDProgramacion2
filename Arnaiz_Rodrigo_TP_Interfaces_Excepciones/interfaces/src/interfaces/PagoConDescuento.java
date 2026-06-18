package interfaces;

/**
 *
 * @author RODRIGO
 */
public interface PagoConDescuento extends Pago{
    public static final double DESCUENTO = 0.1; //Descuento general que se aplica por pago en una cuota 
    public abstract double aplicarDescuento(double importe);
}
