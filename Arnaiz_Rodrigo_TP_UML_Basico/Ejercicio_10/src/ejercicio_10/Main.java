package ejercicio_10;

/**
 *
 * @author RODRIGO
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("---- PROGRAMACIÓN II ----"); 
        System.out.println("--------- UML ---------"); 
        System.out.println("--- Cuenta Bancaria ---\n"); 
        //Declaración/incialización de objetos con constructores 
        System.out.println("---- Inicio ----\n"); 
        //Creación de un titular nuevo 
        Titular titular1 = new Titular("Juan Perez", "31516165"); 
        //Creación de cuentaBancaria con atributos propios y atributos para la clave de seguridad
        CuentaBancaria cuentaBancaria1 = new CuentaBancaria("2850590940090418135201", 13589.56, "Clavefalsa.535", "Clavefalsa534"); 
        //Se hace una impresión para verificar carga correcta
        System.out.println("\nImprimiendo objetos creados...\n"); 
        System.out.println(cuentaBancaria1); 
        System.out.println(titular1); 
        
        cuentaBancaria1.setTitular(titular1); //Se asocia el titular a la cuenta
        
        System.out.println("\nCuenta Bancaria y Titular asociados:\n");
        
        //Se hace una nueva impresión para verificar la asociación bilateral
        System.out.println(titular1);
        System.out.println(cuentaBancaria1);
        System.out.println("");
        
        
       
    }
    
}
