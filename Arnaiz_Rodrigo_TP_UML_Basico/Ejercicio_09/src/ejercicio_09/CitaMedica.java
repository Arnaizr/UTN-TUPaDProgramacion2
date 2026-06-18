package ejercicio_09;

/**
 *
 * @author RODRIGO
 */
public class CitaMedica {
    private String fecha;
    private String hora;
    private Paciente paciente;
    private Profesional profesional;
    
    public CitaMedica(String fecha, String hora){
        this.setFecha(fecha);
        this.setHora(hora);
    }
    
    private void setFecha(String fecha){
        if (validarString(fecha)) {
            this.fecha = fecha;
        }
    }
    
    private void setHora(String hora){
        if (validarString(hora)) {
            this.hora = hora;
        }
    }
    public void setPaciente(Paciente paciente){
        if (paciente != null) {
            this.paciente = paciente;
        }
    }

    public void setProfesional(Profesional profesional){
        if (profesional != null) {
            this.profesional = profesional;
        }
    }

    
    
    @Override
    public String toString() {
        return "Cita: (" + fecha + ", hora: " + hora + "), " + 
        (paciente != null ? paciente : "Sin paciente") + ", " + 
        (profesional != null ? profesional : "Sin profesional");
    }
    
    
    
    //Validaciones
    //Método para verificar que un String no esté vacío o en null    
    private static boolean validarString(String palabra) {
        boolean valido = true;
        if ((palabra == null) || (palabra.trim().equals(""))) { //Se eliminan espacios antes y delante del String y verifica que no esté vacío
            valido = false;
            System.out.println("ERROR: El campo no puede estar vacío.");
        }
        return valido;
    }   
}
