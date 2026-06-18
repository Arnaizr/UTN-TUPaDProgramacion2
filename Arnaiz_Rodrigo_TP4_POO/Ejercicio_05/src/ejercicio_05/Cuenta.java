package ejercicio_05;

/**
 *
 * @author RODRIGO
 */
public class Cuenta {
    private final int numero;
    private String titular;
    private double saldo = 0;
    private static int ultimoNumero = 100;
    private static int totalCuentas = 0;
    //Constructores
    //Constructor principal (todos los parámetros)
    public Cuenta(String titular, double saldoInicial){
        this.numero =++ultimoNumero;
        totalCuentas++;
        this.setTitular(titular);
        this.setSaldo(saldoInicial);
    }
    //Constructor secundario (sólo titular)
    public Cuenta(String titular){
        this(titular, 0);
    }

    public int getNumero() {
        return numero;
    }

    public void setTitular(String titular) {
        if (validarString(titular)){
            this.titular = titular;
            return;
        }
        this.titular = "*Pendiente de carga*";
    }

    private void setSaldo(double saldo) {
        if (validarDoublePositivo(saldo)){
            this.saldo = saldo;
        }
    }
    //Override de toString
    @Override
    public String toString() {
        return "Cuenta{" + "Nº de cuenta = " + numero + ", Titular = " + titular + ", Saldo = $" + String.format("%.2f" , saldo) + '}';
    }
    //Metodos
    //Metodo para consultar el saldo en pesos
    public double consultarSaldo(){ //Se genera de este modo dado que la consigna solicita la devolución de un double
        return saldo;
    }
    //Método para informar saldo en dólares según la cotización actual
    public double consultarSaldo(double cotizacionDolar){
        if (validarDoublePositivo(cotizacionDolar)){
            return saldo/cotizacionDolar; //Se genera de este modo dado que la consigna solicita la devolución de un double
        }
        System.out.println(String.format("%.2f", cotizacionDolar) + " es incorrecto, se informa saldo en pesos.");
        return saldo; //Se genera de este modo dado que la consigna solicita la devolución de un double
    }
    //Método para depositar dinero en cuenta
    public void depositar(double monto){
        if (validarDoublePositivo(monto)){
            saldo += monto;
            System.out.println("Se han depositado $" + String.format("%.2f" , monto) + " en la cuenta Nº " + numero + ".");
        }
    }
    //Método para extraer dinero de la cuenta
    public void extraer(double monto){
        if (validarDoublePositivo(monto)){
           if (monto <= saldo){ //Si el monto a retirar es menor o igual al saldo se procede a la extracción
               saldo -= monto;
                System.out.println("Se retiraron $" + String.format("%.2f" , monto) + " de la cuenta Nº " + numero + ".");
               return;
           } 
            System.out.println("SALDO INSUFICIENTE. No se puede retirar $"  + String.format("%.2f" , monto) + " de la cuenta Nº " + numero + ".");
        }
    }
   
    //Mëtodo para mostrar la cantidad de cuentas creadas
    public static void mostrarTotalCuentas(){
        System.out.println("\nSe han creado un total de " + totalCuentas + " cuentas.");
    }
    //Validaciones
    //Método para validar un double positivo
    private static boolean validarDoublePositivo (double num) {
        boolean positivo = true;
        if (num < 0){
            positivo = false;
            System.out.println("ERROR: El valor ingresado debe ser mayor o igual a cero.");
        }
    return positivo;
    }
    
    //Método para verificar que un String no esté vacío o en null
    private static boolean validarString(String palabra) {
        boolean valido = true;
        if ((palabra == null) || (palabra.trim().equals(""))) { //Se eliminan espacios antes y delante del String y verifica que no esté vacío
            valido = false;
            System.out.println("ERROR: El campo no puede estar vacío.");
        }
        return valido;
    }
}
