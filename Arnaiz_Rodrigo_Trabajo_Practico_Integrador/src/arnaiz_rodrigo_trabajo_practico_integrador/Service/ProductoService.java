package arnaiz_rodrigo_trabajo_practico_integrador.Service;

import arnaiz_rodrigo_trabajo_practico_integrador.entities.Categoria;
import arnaiz_rodrigo_trabajo_practico_integrador.entities.Producto;
import arnaiz_rodrigo_trabajo_practico_integrador.exceptions.DeletedEntityException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author RODRIGO
 */
public class ProductoService {
    private final List<Producto> productos;
    
    public ProductoService(){
        this.productos = new ArrayList<>();
    }
    public void listarProductos(){
        List<Producto> activos = new ArrayList<>();
        for (Producto producto : productos) {
            if (!producto.isEliminado()){
                activos.add(producto);
            }
        }
        if (activos.isEmpty()){
            System.out.println("No hay productos cargados en el sistema.");
            return;
        }
        System.out.println("================================================================");
        for (Producto producto : activos) {
            System.out.println(producto);
        }
        System.out.println("================================================================");
    }
    
    public Producto createProducto(String nombre, double precio, String descripcion, int stock, String imagen, boolean disponible, long idCategoria){
        Categoria categoriaAInstanciar = findCategoriaById(idCategoria);
        if (categoriaAInstanciar.isEliminado()){
            throw new DeletedEntityException("La categoría " + categoriaAInstanciar.getNombre() + " fue eliminada." );
        }
        Producto nuevo = new Producto(nombre, precio, descripcion, stock, imagen, disponible, categoriaAInstanciar);
        productos.add(nuevo);
        return nuevo;        
    }
    
}
