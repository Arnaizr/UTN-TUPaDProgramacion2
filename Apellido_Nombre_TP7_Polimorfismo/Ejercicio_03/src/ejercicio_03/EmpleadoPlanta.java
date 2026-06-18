package ejercicio_03;

/**
 *
 * @author RODRIGO
 */
public class EmpleadoPlanta extends Empleado{
    private int antiguedad;

    public EmpleadoPlanta(String nombre, int antiguedad) {
        super(nombre);
        this.setAntiguedad(antiguedad);
    }

    private void setAntiguedad(int antiguedad) {
        if (antiguedad >= 0){
            this.antiguedad = antiguedad;
        }
    }
    
    @Override
    public String toString() {
        return super.toString() + "antiguedad = " + antiguedad + '}';
    }

    @Override
    public void calcularSueldo() {
        this.sueldo = SUELDO_BASE + SUELDO_BASE * 0.15;
    }
    
    
}
