package ejercicio_09;

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
        System.out.println("------ Cita Médica -----\n"); 
        //Declaración/incialización de objetos con constructores 
        System.out.println("---- Inicio ----\n"); 
        //Creación de un paciente nuevo 
        Paciente paciente1 = new Paciente("Juan Perez", "OSPE"); 
        //Creación de un profesional nuevo 
        Profesional profesional1 = new Profesional("Pedro Juanes ", "Nefrología"); 
        //Creación de cita con atributos propios
        CitaMedica cita1 = new CitaMedica("16/05/26", "18:00"); 
        //Se hace una impresión para verificar carga correcta
        System.out.println("\nImprimiendo objetos creados...\n"); 
        System.out.println(paciente1); 
        System.out.println(profesional1); 
        System.out.println(cita1); 
        
        //Se asigna el paciente y el profesional a la cita
        cita1.setPaciente(paciente1);
        cita1.setProfesional(profesional1);
        System.out.println("\nPaciente y profesional asignados!");
        System.out.println(cita1);
        
    }
    
}
