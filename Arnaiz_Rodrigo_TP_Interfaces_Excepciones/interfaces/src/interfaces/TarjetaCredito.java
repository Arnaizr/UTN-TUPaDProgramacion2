package interfaces;

/**
 *
 * @author RODRIGO
 */
public class TarjetaCredito extends MedioDePago
{
    private String bancoEmisor;
    private String numero;

    public TarjetaCredito(boolean pagoConCuotas, double saldo, String bancoEmisor, String numero) {
        super(pagoConCuotas, saldo);
        this.setBancoEmisor(bancoEmisor);
        this.setNumero(numero);
    }
    //Setters
    public void setBancoEmisor(String bancoEmisor) {
        if (bancoEmisor != null && !bancoEmisor.strip().equals("")){
        this.bancoEmisor = bancoEmisor;
        }
    }

    public void setNumero(String numero) {
        if (numero != null && !numero.strip().equals("")){
        this.numero = numero;
        }
    }

    @Override
    public String toString() {
        return "Tarjeta: " + "(Banco: " + bancoEmisor + "), Nº: " + numero + ".";
    }
    
    

    @Override
    public boolean procesarPago(double importe) {
        double total = aplicarDescuento(importe); //Se recibe el monto a pagar y se llama al método de aplicar descuento
            System.out.println("Con el medio de pago " + this + "El total es $" + String.format("%.2f", total));
            return (saldo >= total); //Se devuelve si el saldo en el medio de pago es suficiente 
    }

    @Override
    public double aplicarDescuento(double importe) {
        if (!pagoConCuotas){  //Se recibe el importe y se aplica el descuento si corresponde (en caso de ser en una cuota)
            importe -= importe*DESCUENTO;
            System.out.println("Se aplica un descuento del " + DESCUENTO*100 + "%");
        }
        return importe;
    }
}
