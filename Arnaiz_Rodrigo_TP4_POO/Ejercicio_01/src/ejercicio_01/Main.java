package ejercicio_01;

/**
 *
 * @author RODRIGO
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

    //Declaración/incialización de objetos con constructores
    //Inicialización con constructor completo
    System.out.println("\n--- Cargando empleados... ---\n");
    
    Empleado emp1 = new Empleado("Jorge", "Tesorero", 350000); //Carga completa
    Empleado emp2 = new Empleado("Javier", " ", 260000.35); //Carga con puesto vacio
    Empleado emp3 = new Empleado("José", "Contador", -1000); //Carga con saldo negativo
    Empleado emp7 = new Empleado(null, "Ensamblador", 402540.23); //Carga con nombre null
    //Inicialización con constructor parcial
    Empleado emp4 = new Empleado("Jorgelina", "Jefa"); //Carga completa (sueldo por defecto)
    Empleado emp5 = new Empleado("", "Recrutadora");//Carga con nombre vacío (sueldo por defecto)
    Empleado emp6 = new Empleado("", null); //Carga con nombre vacío y puesto null (sueldo por defecto)
    Empleado emp8 = new Empleado("Juana", "Programadora"); //Carga completa (sueldo por defecto)
    //Salida inicial 
    System.out.println("\n--- Mostrando datos iniciales ---");
    
    System.out.println(emp1);
    System.out.println(emp2);
    System.out.println(emp3);
    System.out.println(emp4);
    System.out.println(emp5);
    System.out.println(emp6);
    System.out.println(emp7);
    System.out.println(emp8);
    
    //Carga de datos con setters
    System.out.println("\n--- Cargando datos faltantes ---");
    
    emp2.setPuesto("Cocinero");
    emp3.setSalario(250000);
    emp5.setNombre("Javiera");
    emp6.setNombre("Josefina");
    emp6.setPuesto("Carpintera");

    System.out.println("\n--- Mostrando datos actualizados ---");
    System.out.println(emp2);
    System.out.println(emp3);
    System.out.println(emp5);
    System.out.println(emp6);
    System.out.println(emp7);
    
    System.out.println("\n--- Actualizar salarios ---");
    //Actualizar salario con porcentajes
    emp2.actualizarSalario(10.5); //Se actualiza con un importe correcto
    emp6.actualizarSalario(-15.2); //Se intenta actualizar con porcentaje negativo
    emp1.actualizarSalario(0.5); //Se actualiza con un flotante entre 0 y 1 
    emp5.actualizarSalario(0); //Se actualiza con 0 
    emp8.actualizarSalario(66.66);
    //Actualizar salario con importes
    emp4.actualizarSalario(30000); //Se actualiza con monto fijo
    emp3.actualizarSalario(-150000);//Se intenta actualizar con monto negativo
    emp7.actualizarSalario(8080);
            
    //Salida final de datos        
    System.out.println("\n--- Mostrando datos finales ---");
    System.out.println(emp1);
    System.out.println(emp2);
    System.out.println(emp3);
    System.out.println(emp4);
    System.out.println(emp5);
    System.out.println(emp6);
    System.out.println(emp7);
    System.out.println(emp8);

    System.out.println("\n--- Mostrando total de empleados ---");

    System.out.println("El total de personal hasta el momento es " + Empleado.mostrarTotalEmpleados() + " empleados.");            

    
    System.out.println("\n--- FIN DEL PROGRAMA ---");
    }
    
}
