package ejercicio_12;

/**
 *
 * @author RODRIGO
 */
public class Impuesto {
    private double monto; 
    private Contribuyente contribuyente;
    
    //Constructor con atributos propios 
    public Impuesto(double monto){ 
        this.setMonto(monto);  
    }
    //Getters
    public double getMonto(){ //Getter para salida de datos en calculadora
        return monto;
    }
    //Setters 
    private void setMonto(double monto) { 
        if (validarDoublePositivo(monto)){ 
            this.monto = monto; 
        } 
    }  
    public void setContribuyente(Contribuyente contribuyente) { //Setter para asociación unidireccional de contribuyente
        if (contribuyente != null) {
            this.contribuyente = contribuyente;
        }
    }
    
    @Override public String 
    toString() { return "Impuesto (monto): " + monto + ", " + (contribuyente !=null ? contribuyente : "Contribuyente: Sin datos");
    } 
    //Validaciones 
    //Método para validar un double positivo
    private static boolean validarDoublePositivo (double num) {
        boolean positivo = true;
        if (num < 0){
            positivo = false;
            System.out.println("ERROR: El valor ingresado debe ser mayor o igual a cero.");
        }
    return positivo;
    }    
}
