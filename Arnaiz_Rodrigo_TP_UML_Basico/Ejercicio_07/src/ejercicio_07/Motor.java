package ejercicio_07;

/**
 *
 * @author RODRIGO
 */
public class Motor { 
    private String tipo; 
    private String numeroSerie; 

    //Constructor con atributos propios 
    public Motor(String tipo, String numeroSerie){ 
        this.setTipo(tipo); 
        this.setNumeroSerie(numeroSerie); 
    } 
    //Setters 
    private void setTipo(String tipo) { 
        if (validarString(tipo)){ 
            this.tipo = tipo; 
        } 
    } 
    private void setNumeroSerie(String numeroSerie) { 
        if (validarString(numeroSerie)){
            this.numeroSerie = numeroSerie; 
        } 
    } 
    
    @Override public String 
    toString() { return "Motor: " + tipo + " (numero: " + numeroSerie + ")";
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