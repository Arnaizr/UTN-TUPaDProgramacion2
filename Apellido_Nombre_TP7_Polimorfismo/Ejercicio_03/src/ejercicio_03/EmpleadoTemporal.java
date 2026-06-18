package ejercicio_03;

/**
 *
 * @author RODRIGO
 */
public class EmpleadoTemporal extends Empleado{
    private String tipoContrato;
    
    public EmpleadoTemporal(String nombre, String tipoContrato) {
        super(nombre);
        this.setTipoContrato(tipoContrato);
        
    }

    private void setTipoContrato(String tipoContrato) {
        if (validarString(tipoContrato)){
            this.tipoContrato = tipoContrato;
        }
    }

    @Override
    public String toString() {
        return super.toString() + "tipo de Contrato = " + tipoContrato + '}';
    }
    
    @Override
    public void calcularSueldo() {
        this.sueldo = SUELDO_BASE;
    }
    
}
