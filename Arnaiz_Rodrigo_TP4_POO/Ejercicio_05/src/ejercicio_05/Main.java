package ejercicio_05;

/**
 *
 * @author RODRIGO
 */
public class Main {


    public static void main(String[] args) {
      //Declaración/incialización de objetos con constructores
        
        System.out.println("\n--- Cargando cuentas... ---\n");
        //Inicialización con constructor completo
        Cuenta cuenta1 = new Cuenta("Ricardo Ruben", 7035.89); //Carga completa 
        Cuenta cuenta2 = new Cuenta(null, 30000); //Carga con titular en null
        Cuenta cuenta3 = new Cuenta("Roberto Rojas", -8000); //Carga con saldo inicial negativo 
        //Inicialización con constructor parcial
        Cuenta cuenta4 = new Cuenta("    "); //Carga con titular vacío y saldo predeterminado
        
        System.out.println("\n--- Mostrando datos iniciales ---\n");

        System.out.println(cuenta1);
        System.out.println(cuenta2);
        System.out.println(cuenta3);
        System.out.println(cuenta4);
    
        //Carga de datos con setters
        System.out.println("\n--- Cargando datos faltantes ---\n");
        
        cuenta2.setTitular("Rodolfo Rodriguez");
        cuenta4.setTitular("Rodrigo Rodolfez");
        System.out.println(cuenta2);
        System.out.println(cuenta4);

        //Consultar saldo en pesos
        System.out.println("\n--- Consultar saldo en pesos ---\n");

        System.out.println("El saldo en pesos de la cuenta Nº " + cuenta1.getNumero() + " es: $" + String.format("%.2f" , cuenta1.consultarSaldo()));
        System.out.println("El saldo en pesos de la cuenta Nº " + cuenta2.getNumero() + " es: $" + String.format("%.2f" , cuenta2.consultarSaldo()));
    
        //Depositar dinero en cuenta
        
        System.out.println("\n--- DEPOSITAR ---\n");
        
        cuenta2.depositar(50000.591951); //Se deposita un monto válido
        cuenta4.depositar(-875403.26516); //Se intenta depositar un negativo
        cuenta4.depositar(3000); //Se deposita un monto correcto
        cuenta3.depositar(80000);//Se deposita un monto correcto
        
        System.out.println("\n--- Mostrando datos actualizados ---\n");

        System.out.println(cuenta1);
        System.out.println(cuenta2);
        System.out.println(cuenta3);
        System.out.println(cuenta4);

        cuenta4.depositar(8000.561);
        System.out.println(cuenta4); //Se muestra una vez más luego de un segundo depósito
        
        //Consultar saldo en dolares
        System.out.println("\n--- Consultar saldo en dolares ---\n");
        
        //Se consultan los saldos en dólares con valor negativo
        System.out.println("El saldo en dolares de la cuenta Nº " + cuenta3.getNumero() + " es: USD " + String.format("%.2f" , cuenta3.consultarSaldo(-1590.00)));
        
        //Se consultan los saldos en dólares con distintas cotizaciones
        System.out.println("El saldo en dolares de la cuenta Nº " + cuenta4.getNumero() + " es: USD " + String.format("%.2f" , cuenta4.consultarSaldo(1390.00)));
        System.out.println("El saldo en dolares de la cuenta Nº " + cuenta3.getNumero() + " es: USD " + String.format("%.2f" , cuenta3.consultarSaldo(1400.00)));
        /*
        Respecto a los métodos de consultar saldo considero que queda mucho más prolijo que se genere el informe dentro
        del método y que sea sólo un void, sin embargo la consigna (a menos que la haya interpretado mal) solicita que 
        el retorno sea un double..
        */
        
        System.out.println("\n--- EXTRAER ---\n");
        
        cuenta1.extraer(55655); //Se intenta extraer más del saldo de la cuenta
        cuenta1.extraer(3000); //Se intenta extraer un monto acorde
        cuenta2.extraer(-9000); //Se intenta extraer con parámetros negativos
        
        //Consultar saldo en dolares
        System.out.println("\n--- Mostrar datos finales ---\n");
        
        System.out.println(cuenta1);
        System.out.println(cuenta2);
        System.out.println(cuenta3);
        System.out.println(cuenta4);
        
        //Se muestra el contador de cuentas
        Cuenta.mostrarTotalCuentas();
        
        System.out.println("\n--- FIN DEL PROGRAMA ---\n");

    }
    
}
