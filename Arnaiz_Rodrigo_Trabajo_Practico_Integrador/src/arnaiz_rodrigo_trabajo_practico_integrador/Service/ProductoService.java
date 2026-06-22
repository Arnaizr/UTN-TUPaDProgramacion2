package arnaiz_rodrigo_trabajo_practico_integrador.Service;

import arnaiz_rodrigo_trabajo_practico_integrador.entities.Categoria;
import arnaiz_rodrigo_trabajo_practico_integrador.entities.Producto;
import arnaiz_rodrigo_trabajo_practico_integrador.exceptions.EntityNotFoundException;
import arnaiz_rodrigo_trabajo_practico_integrador.exceptions.InvalidFieldException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author RODRIGO
 */
public class ProductoService {
    private final List<Producto> productos;
    private final CategoriaService categoriaService;
    
    public ProductoService(CategoriaService categoriaService){
        this.productos = new ArrayList<>();
        this.categoriaService = categoriaService;
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
        Categoria categoriaAInstanciar = categoriaService.findCategoriaById(idCategoria);
        Producto nuevo = new Producto(nombre, precio, descripcion, stock, imagen, disponible, categoriaAInstanciar);
        productos.add(nuevo);
        return nuevo;
    }
    
    //Método para buscar un producto por su id asociado
    public Producto findProductoById(long id){
        Producto productoEncontrado = null; //Se inicializa en null la variable de producto encontrado
        Iterator<Producto> it = this.productos.iterator(); //Se crea un iterador para la búsqueda
        while (it.hasNext() && productoEncontrado == null){ //Se repite mientras haya productos en la colección y mientras no encuentre el producto
            Producto productoBucle = it.next(); //Se carga el producto actual de la iteración de la colección
            if (id == productoBucle.getId()&& !productoBucle.isEliminado()){
                productoEncontrado = productoBucle;
            }
        }
        if (productoEncontrado == null){
            throw new EntityNotFoundException ("No se encontró un producto con id: " + id);
        }
        return productoEncontrado;
    }
    
    public void editProducto(long id, String nombre, Double precio, String descripcion, Integer stock, String imagen, Boolean disponible, Long idCategoria){
        try {
            Producto productoAEditar = findProductoById(id);
            Categoria categoriaAInstanciar = null;
            
            if (idCategoria != null) {
                categoriaAInstanciar = categoriaService.findCategoriaById(idCategoria); // si falla lanza la excepción EntityNotFound y no se modificaron los otros atributos
            }
            if (precio != null && !Validaciones.validarDoublePositivo(precio)){ // si falla lanza la excepción antes de editar nada
                throw new InvalidFieldException("El precio debe ser positivo.");
            }
            if (stock != null && !Validaciones.validarIntNoNegativo(stock)){ //si falla lanza la excepción antes de editar nada
                throw new InvalidFieldException("El stock no puede ser negativo.");
            }
            if (nombre != null && !Validaciones.validarStringNoVacio(nombre)){ //si falla lanza la excepción antes de editar nada
                throw new InvalidFieldException("El nombre no puede ser negativo.");
            }
            if (nombre != null){
                productoAEditar.setNombre(nombre);
                System.out.println("Se actualizó el nombre a: " + nombre + ".");
            }
            if (precio != null){
                productoAEditar.setPrecio(precio);
                System.out.println("Se actualizó el precio a: $" + String.format("%.2f", precio) + ".");
            }
            if (descripcion != null){
                productoAEditar.setDescripcion(descripcion);
                System.out.println("Se actualizó la descripción.");
            }
            if (stock != null){
                productoAEditar.setStock(stock);
                System.out.println("Se actualizó el stock a: " + stock + ".");
            }
            if (imagen != null){
                productoAEditar.setImagen(imagen);
                System.out.println("Se actualizó la imagen.");
            }
            if (disponible != null){
                productoAEditar.setDisponible(disponible);
                System.out.println("Se actualizó la disponibilidad a: " + (disponible ? "Sí" : "No") + ".");
            }
            if (categoriaAInstanciar != null){
                productoAEditar.setCategoria(categoriaAInstanciar);
                System.out.println("Se actualizó la categoría a: " + categoriaAInstanciar.getNombre() + ".");
            }
        }
        catch (EntityNotFoundException | InvalidFieldException e){
            System.out.println(e.getMessage());
        }
    }
    
    public void deleteProductoById(long id){
        try {
            Producto productoAEliminar = findProductoById(id);
            productoAEliminar.setEliminado(true);
            System.out.println("Se eliminó el producto con id: " + id);
        }
        catch (EntityNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
}
