package ejercicio_01;

/**
 *
 * @author RODRIGO
 */
public enum CategoriaProducto {
    ALIMENTOS ("Productos comestibles"),
    ELECTRONICA ("Dispositivos electronicos"),
    ROPA ("Prendas de vestir"),
    HOGAR ("Artículos para el hogar");
    
    private final String descripcion;
    
    private CategoriaProducto(String descripcion) { 
        this.descripcion = descripcion;
        }
    
    public String getDescripcion(){
        return descripcion;
    }

    @Override
    public String toString() {
        return name() + " (" + descripcion + ")";
    }

}
