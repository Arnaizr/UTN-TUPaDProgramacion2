package ejercicio_09;

/**
 *
 * @author RODRIGO
 */
public class Paciente {
    private String nombre;
    private String obraSocial;
    
    public Paciente(String nombre, String obraSocial){
        this.setNombre(nombre);
        this.setObraSocial(obraSocial);
    }
    
   private void setNombre(String nombre){
        if (validarString(nombre)) {
            this.nombre = nombre;
        }
    }
    
    private void setObraSocial(String obraSocial){
        if (validarString(obraSocial)) {
            this.obraSocial = obraSocial;
        }
    }
    
    @Override
    public String toString() {
        return "Paciente: " + nombre + " (Obra Social: " + obraSocial + ")";
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
