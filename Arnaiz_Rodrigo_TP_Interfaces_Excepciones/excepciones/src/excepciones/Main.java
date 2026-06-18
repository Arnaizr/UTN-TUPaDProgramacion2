package excepciones;

/**
 *
 * @author RODRIGO
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
          
        //Testeando métodos
        
        System.out.println("Probando método de división segura: ");
        
        DivisionSegura metodo1 = new DivisionSegura();
        
        System.out.println(metodo1.division());

        System.out.println("\nProbando método de conversión a texto: ");
        
        ConversionNumero metodo2 = new ConversionNumero();
        
        System.out.println(metodo2.convertirNumero());
        
        System.out.println("\nProbando método de lectura de archivo: ");
        
        LecturaArchivo metodo3 = new LecturaArchivo();
        
        metodo3.leerArchivo("D:\\Mis Documentos\\mensaje.txt");
        
        System.out.println("\nProbando excepción de edad inválida: ");
        
        Persona pers1 = new Persona();
        
        try{
            pers1.ingresarEdad(666);
        }
        catch (EdadInvalidaException e){
            System.out.println(e.getMessage());
        }
        
        System.out.println("\nProbando método de lectura de archivo: ");
        
        PruebaTryWithResources metodo4 = new PruebaTryWithResources();
        
        metodo4.lecturaArchivoAutoClose("D:\\Mis Documentos\\mensaje.txt");
       
    }
    
}
