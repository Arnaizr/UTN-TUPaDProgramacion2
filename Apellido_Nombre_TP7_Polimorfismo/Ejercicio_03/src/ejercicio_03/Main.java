package ejercicio_03;

import java.util.ArrayList;
import java.util.List;

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
        List<Empleado> empleados = new ArrayList<>();
        
        empleados.add(new EmpleadoPlanta("Juan Perez", 3));
        empleados.add(new EmpleadoPlanta("Mengano García", 2));
        empleados.add(new EmpleadoPlanta("José Dubal", 8));
        empleados.add(new EmpleadoTemporal("Johan Sebastian Mastropiero", "Locacion de obra"));
        empleados.add(new EmpleadoTemporal("Ali Baba", "Locacion de servicio"));
        empleados.add(new EmpleadoTemporal("Jafar Washington", "Pasantía"));
        
        System.out.println("---Listando empleados calculando el sueldo....\n");        
        //Se recorre el array, se calcula el sueldo, muestra el tipo de empleado y se muestra el resultado
        for (Empleado empleado : empleados) {
            if (empleado instanceof EmpleadoPlanta){
                System.out.println("[PLANTA]");
            }
            else if(empleado instanceof EmpleadoTemporal){
                System.out.println("[TEMPORAL]");
            }
            empleado.calcularSueldo();
            System.out.println(empleado);
        }
         System.out.println("\n---FIN DEL PROGRAMA---\n");
    }
    
}
