package interfaces;

/**
 *
 * @author RODRIGO
 */
public abstract class MedioDePago implements PagoConDescuento{ //Todos los medios de pago implementan PagoConDescuento (y consecuentemente Pago por herencia)
    
    protected final boolean pagoConCuotas; //Determina si el pago es en cuotas y por lo tanto si aplica descuento o no
    protected double saldo;
    
    public MedioDePago(boolean pagoConCuotas, double saldo) {
        this.pagoConCuotas = pagoConCuotas;
        this.setSaldo(saldo);
    }

    public void setSaldo(double saldo) {
        if (saldo >= 0){
        this.saldo = saldo;
        }
    }
    
    
}
