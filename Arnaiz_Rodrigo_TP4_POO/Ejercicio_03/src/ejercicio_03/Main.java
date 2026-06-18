package ejercicio_03;

/**
 *
 * @author RODRIGO
 */
public class Main {

    public static void main(String[] args) {
    //Declaración/incialización de objetos con constructores
    //Inicialización con constructor completo
    System.out.println("\n--- Cargando alumnos... ---\n");

    Alumno alum1 = new Alumno("Jorge", 7.5); //Carga completa 
    Alumno alum2 = new Alumno("José", -4.5); //Carga con promedio negativo
    Alumno alum3 = new Alumno("", 4); //Carga sin nombre
    Alumno alum4 = new Alumno("Juan",  11); //Carga con promedio mayor a 10
    
    //Inicialización con constructor parcial
    Alumno alum5 = new Alumno("Jonás"); //Carga con nombre (promedio predeterminado)
    Alumno alum6 = new Alumno(null); //Carga con null (promedio predeterminado)
    
    
    System.out.println("\n--- Mostrando datos iniciales ---");

    System.out.println(alum1);
    System.out.println(alum2);
    System.out.println(alum3);
    System.out.println(alum4);
    System.out.println(alum5);
    System.out.println(alum6);
    
    //Carga de datos con setters
    System.out.println("\n--- Cargando datos faltantes ---");
    
    alum6.setNombre("Jerónimo");
    alum3.setNombre("Javier");
    
    //Declaración de notas del alumno Jonás
    double notasJonas[] = {10,3,7,3,10};
    //Declaración de notas del alumno Jerónimo
    double notasJeronimo[] = {6,1,2,3};
    //Actualizar promedios con métodos
    //Actulizar promedio con double
    alum2.actualizarPromedio(6.0);
    alum4.actualizarPromedio(-8); //No admite negativos
    alum4.actualizarPromedio(5);
    alum5.actualizarPromedio(notasJonas);
    alum6.actualizarPromedio(notasJeronimo);
    
    System.out.println("\n--- Mostrando datos cargados ---");
    
    System.out.println(alum1);
    System.out.println(alum2);
    System.out.println(alum3);
    System.out.println(alum4);
    System.out.println(alum5);
    System.out.println(alum6);
    
    System.out.println("\n--- Actualizando nota mínima para aprobar ---");
    
    Alumno.cambiarNotaAprobacion(4);
    
    System.out.println("\n--- Verificando aprobados ---");
    
    System.out.println(alum1);
    System.out.println(alum2);
    System.out.println(alum3);
    System.out.println(alum4);
    System.out.println(alum5);
    System.out.println(alum6);
    
        System.out.println("\n ----- FIN DEL PROGRAMA -----");
    }
    
}
