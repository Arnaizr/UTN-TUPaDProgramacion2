package interfaces;

/**
 *
 * @author RODRIGO
 */
public class PayPal extends MedioDePago{
    private String email;

    public PayPal(double saldo, String email) {
        super(false, saldo); //Se pasa como parámetro false porque es un medio que no admite cuotas
        this.setEmail(email);
    }

    public void setEmail(String email) {
        if (email != null && !email.strip().equals("")){
            this.email = email;
        }
    }

    @Override
    public String toString() {
        return "PayPal - " + "(E-mail: " + email + ")";
    }

    @Override
    public boolean procesarPago(double importe) {
        double total = aplicarDescuento(importe); //Se recibe el monto a pagar y se llama al método de aplicar descuento
        System.out.println("Con el medio de pago " + this + "El total es $" + String.format("%.2f", total));
            return (saldo >= total); //Se devuelve si el saldo en el medio de pago es suficiente 
    }
    
    @Override
    public double aplicarDescuento(double importe) { //Se recibe el importe y se aplica el descuento si corresponde (Siempre con PayPal)
        System.out.println("Se aplica un descuento del " + DESCUENTO*100 + "%");
        return importe - importe*DESCUENTO;
    }

}
