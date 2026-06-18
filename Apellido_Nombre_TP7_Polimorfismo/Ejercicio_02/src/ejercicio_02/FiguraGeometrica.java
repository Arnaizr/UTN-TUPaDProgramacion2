package ejercicio_02;

/**
 *
 * @author RODRIGO
 */
public abstract class FiguraGeometrica {
    private String nombre;
    
    public FiguraGeometrica(String nombre){
        this.setNombre(nombre);
    }
    
    public void setNombre(String nombre) {
        if (validarString(nombre)){
        this.nombre = nombre;
        }
    }
    
    public abstract double calcularArea();

    public void mostrarInfo(){
        System.out.println("Nombre: "+ nombre + ", Area: " + String.format("%.2f",calcularArea()));
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

