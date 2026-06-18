package interfaces;

/**
 *
 * @author RODRIGO
 */
public class Producto implements Pagable{
    private String nombre;
    private double precio;

    public Producto(String nombre, double precio) {
        this.setNombre(nombre);
        this.setPrecio(precio);
    }

    public void setNombre(String nombre) {
        if (nombre != null && !nombre.strip().equals("")){
        this.nombre = nombre;
        }
    }

    public void setPrecio(double precio) {
        if (precio >= 0){
            this.precio = precio;   
        }    
    }
    
    @Override
    public String toString() {
        return "Producto: " + nombre + ", $" + String.format("%.2f", precio) + ".-";
    }
    
    @Override
    public double calcularTotal() { //Override de la implementación de pagable, cada producto devuelve su unitario
        return precio;
    }
    
}
