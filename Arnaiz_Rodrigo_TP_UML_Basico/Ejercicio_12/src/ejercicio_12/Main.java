package ejercicio_12;

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
        System.out.println("--- Calculadora ---\n"); 
        //Declaración/incialización de objetos con constructores 
        System.out.println("---- Inicio ----\n"); 
        //Creación de un impuesto nuevo con atributos propios
        Impuesto impuesto1 = new Impuesto(15698.08); 
        //Creación de contribuyente con atributos propios
        Contribuyente contribuyente1 = new Contribuyente("Juan Perez", "20-36516516-1"); 
        //Creación de un calculadora
        Calculadora calculadora1 = new Calculadora();
        //Se hace una impresión para verificar carga correcta
        System.out.println("\nImprimiendo objetos creados...\n"); 
        System.out.println(impuesto1); 
        System.out.println(contribuyente1); 
        
        impuesto1.setContribuyente(contribuyente1); //Se asocia el impuesto al contribuyente
        
        System.out.println("\nImpuesto y contribuyente asociados:\n");
        
        //Se hace una nueva impresión para verificar la asociación 
        System.out.println(impuesto1);
        System.out.println("");
        
        //Se usa el impuesto en la calculadora
        
        calculadora1.calcular(impuesto1);

    }
    
}
