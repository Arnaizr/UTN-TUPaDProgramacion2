package ejercicio_02;

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
        System.out.println("--------- UML ---------\n");
        System.out.println("------ Celular -----\n");

        //Declaración/incialización de objetos con constructores
        System.out.println("---- Inicio ----\n");
        
        //Creación de una batería nueva
        Bateria bateria1 = new Bateria("BN5A", 5000);
        //Creación de celular con atributos con la bateria creada
        Celular celular1 = new Celular("333555666777555", "Xiaomi", "Redmi 10", bateria1);
        //Creación de usuario
        Usuario usuario1 = new Usuario("Juan Pérez", "35198132");
        
        //Se hace una impresión para verificar carga correcta y la falta de asociación bilateral
        System.out.println(celular1);
        System.out.println(usuario1);
        System.out.println("");
        usuario1.setCelular(celular1); //Se asocia el celular al usuario 
        
        System.out.println("Celular y usuario asociados:");
        
        //Se hace una nueva impresión para verificar la asociación bilateral
        System.out.println(usuario1.getCelular());
        System.out.println(celular1.getUsuario() + "\n");
        
        System.out.println("Batería del celular nº " + celular1.getImei() + ":");
        System.out.println("Bateria: " + bateria1);
        
        System.out.println("\nEliminando celular...");
        celular1 = null; //Se elimina el celular para demostrar que la batería sigue existiendo
        System.out.println(celular1);
        System.out.println("Bateria: " + bateria1);
    }
    
}
