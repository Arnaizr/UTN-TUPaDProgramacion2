package ejercicio_03;

/**
 *
 * @author RODRIGO
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
            System.out.println("\n---INICIO DEL PROGRAMA---\n");
        //Carga de profesores
        Profesor profe1 = new Profesor("Juan Perez", "Programación");
        Profesor profe2 = new Profesor("Pedro Juarez", "Arquitectura");
        Profesor profe3 = new Profesor("Choly Erquiaga", "Matemática");
        Profesor profe4 = new Profesor("Chichita de Berreteaga", "Química");

        //Carga de cursos
        Curso curso1 = new Curso("Programación I");
        Curso curso2 = new Curso("Programación II");
        Curso curso3 = new Curso("Álgebra");
        Curso curso4 = new Curso("Base de Datos");
        Curso curso5 = new Curso("Arquitectura de computadoras");
        Curso curso6 = new Curso("Química I");
        Curso curso7 = new Curso("Matemática I");
        Curso curso8 = new Curso("Química II");
        
        //Creación de una nueva universidad
        Universidad uni1 = new Universidad("UTN - FRLP");
        
        //Incorporación de profesores a la universidad
        System.out.println("\n--- Agregando profesores...\n");
        uni1.agregarProfesor(profe1);
        uni1.agregarProfesor(profe2);
        uni1.agregarProfesor(profe2);
        uni1.agregarProfesor(profe3);
        uni1.agregarProfesor(profe4);
        
        //Incorporación de cursos a la universidad
        System.out.println("\n--- Agregando cursos...\n");
        uni1.agregarCurso(curso1);
        uni1.agregarCurso(curso2);
        uni1.agregarCurso(curso3);
        uni1.agregarCurso(curso4);
        uni1.agregarCurso(curso5);
        uni1.agregarCurso(curso6);
        uni1.agregarCurso(curso6);
        uni1.agregarCurso(curso7);
        uni1.agregarCurso(curso8);
        
        System.out.println("\n--- Asociando profesores a cursos...\n");
        
        uni1.asignarProfesorACurso(curso1.getCodigo(), profe1.getId());
        uni1.asignarProfesorACurso(curso2.getCodigo(), profe1.getId());
        uni1.asignarProfesorACurso(curso3.getCodigo(), profe3.getId());
        uni1.asignarProfesorACurso(curso4.getCodigo(), profe1.getId());
        uni1.asignarProfesorACurso(curso5.getCodigo(), profe2.getId());
        uni1.asignarProfesorACurso(curso6.getCodigo(), profe4.getId());
        uni1.asignarProfesorACurso(curso7.getCodigo(), profe3.getId());
        uni1.asignarProfesorACurso(curso8.getCodigo(), profe4.getId());
        
        //Mostrando el total de las cargas
        System.out.println("\n--- Listando profesores...");
        uni1.listarProfesores();
        
        System.out.println("\n--- Listando cursos...");
        uni1.listarCursos();
        
        //Reemplazando profesor en curso
        System.out.println("\n--- Reemplazando profesor del curso " + curso5.getNombre() + "...\n");

        uni1.asignarProfesorACurso(curso5.getCodigo(), profe1.getId());
        
        System.out.println("\n--- Mostrando resultados: \n");
        
        System.out.println("Datos de los profesores:");
        profe2.mostrarInfo();
        profe2.listarCursos(); //Se muestran los cursos del antiguo profesor titular
        profe1.mostrarInfo();
        profe1.listarCursos(); //Se muestran los cursos del nuevo profesor titular
        System.out.println("\nDatos del curso: ");
        curso5.mostrarInfo();
        
        //Eliminación de un curso
        System.out.println("\n--- Eliminando al curso con código " + curso2.getCodigo() + "...\n");
        uni1.eliminarCurso(curso2.getCodigo());
        System.out.println("Mostrando resultados: \n");
        uni1.listarProfesores();
        uni1.listarCursos();
        
        //Eliminación de un profesor
        System.out.println("\n--- Eliminando al profesor con ID " + profe3.getId() + "...\n");
        uni1.eliminarProfesor(profe3.getId());
        System.out.println("\nMostrando resultados: \n");
        uni1.listarProfesores();
        uni1.listarCursos();
        
        //Reporte de cursos de los profesores
        
        uni1.reporteCursosDeProfesor();
        
        System.out.println("\n\n---FIN DEL PROGRAMA---\n");
    }
    
}
