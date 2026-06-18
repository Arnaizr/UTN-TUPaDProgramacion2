package arnaiz_rodrigo_segundo_parcial.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author RODRIGO
 */
public class Categoria extends Base{
    private String nombre;
    private String descripcion;
    private final List<Producto> productos;
    private static long contadorId = 0;  //Se crea un contador estático de clase para la instanciación automática del id

    public Categoria(String nombre, String descripcion) {
        super(++contadorId); //Se envía como parámetro el contador incrementado a la clase base
        this.setNombre(nombre);
        this.setDescripcion(descripcion);
        this.productos = new ArrayList<>();
    }
    //Getters
    public String getNombre() {
        return nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }

    public List<Producto> getProductos() {
        return Collections.unmodifiableList(productos);
    }
    //Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    //Métodos
    //Método para agregar un producto a la categoría garantizando relación bilateral
    public void agregarProducto (Producto producto){
        //Verificar que el producto no sea null
        if (producto == null){
            System.out.println("\nEl producto no puede ser nulo.");
            return;
        }
        //Verificación que el producto no existe ya en la categoría
        if (!productos.contains(producto)){
            productos.add(producto);
           //Se actualiza la categoria en el producto agregado
           if (producto.getCategoria() != this){
               producto.setCategoria(this);
           }
        }
    }
    //Método para eliminar un producto de la categoría (necesario para la relación bilateral
    public void eliminarProducto(Producto producto){
        if (producto != null && productos.contains(producto)){
            productos.remove(producto);
            if (producto.getCategoria() == this) {
                producto.setCategoria(null);
            }
        }
    }
    
    @Override
    public String toString() {
        return "Categoria: #[" + getId() + "] | Nombre: [" + nombre + "] | Descripcion: [" + descripcion + "].";
    }
    
    
}
