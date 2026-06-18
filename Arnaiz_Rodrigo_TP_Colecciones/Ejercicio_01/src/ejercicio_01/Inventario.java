package ejercicio_01;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author RODRIGO
 */
public class Inventario {
    private final ArrayList<Producto> productos;
    
    public Inventario(){
        this.productos = new ArrayList<>();
    }
    //Métodos
    //Método para agregar un nuevo producto
    public void agregarProducto (Producto p){
        if (p == null) {
        System.out.println("ERROR: El producto no puede ser null.");
        return;
        }
        this.productos.add(p);
    }
    //Métodoo para mostrar todos los productos del inventario
    public void listarProductos(){
        if (productos.isEmpty()){
            System.out.println("No hay productos inventariados");
        }
        else{
            System.out.println("");
            for (Producto producto : productos) {
                producto.mostrarInfo();
            }
        }
    }
    //Método para buscar un producto por ID
    public Producto buscarProductoPorId(String id){
        Producto productoEncontrado = null; //Se inicializa en null la variable de producto encontrado
        Iterator<Producto> it = this.productos.iterator(); //Se crea un iterador para la búsqueda
        while (it.hasNext() && productoEncontrado == null){ //Se repite mientras haya productos en la colección y mientras no encuentre el ID
            Producto p = it.next(); //Se carga el producto actual de la colección
            if (p.getId().equalsIgnoreCase(id)){
                productoEncontrado = p;
            }
        }
        return productoEncontrado;
    }
    
    //Método para eliminar un producto por ID
    public void eliminarProducto(String id){
        Producto productoAEliminar = buscarProductoPorId(id); //Se busca el producto con la ID ingresada
        if (productoAEliminar == null){
            System.out.println("No se encontró un producto con ID " + id);
        }
        else{
            productos.remove(productoAEliminar); //Se elimina el producto de la colección
            System.out.println("Se eliminó el producto con ID " + productoAEliminar.getId());
        }
    }
    
    //Método para actualizar el stock de un producto
    public void actualizarStock(String id, int nuevaCantidad){
        Producto productoAActualizar = buscarProductoPorId(id); //Se busca el producto con la ID ingresada
        if (productoAActualizar == null){
            System.out.println("No se encontró un producto con ID " + id);
        }
        else{
            productoAActualizar.actualizarStock(nuevaCantidad); //Se invoca a la actualización de stock del producto
        }
    }
    
    //Método para filtrar productos por categoria
    public ArrayList<Producto> filtrarPorCategoria(CategoriaProducto categoria){
        ArrayList<Producto> productosFiltrados = new ArrayList<>();
        for (Producto producto : productos) {
            if (producto.getCategoria() == categoria){
                productosFiltrados.add(producto);
            }
        }
        return productosFiltrados;
    }
    
    //Método para obtener el stock de todos los productos
    public int obtenerTotalStock(){
        int totalStock = 0; //Se inicializa un acumulador
        for (Producto producto : productos) {
            totalStock += producto.getCantidad(); //Se recorren todos los productos inventariados y se almacena el stock de cada uno
        }
        return totalStock;
    }
    
    //Método para obtener el producto con mayor stock
    public Producto obtenerProductoConMayorStock(){
        if (productos.isEmpty()){
            System.out.println("No hay productos inventariados");
            return null;
        }
        Producto productoMayorStock = productos.iterator().next(); //Se inicializa como producto con mayor stock el "primero" de la colección
        for (Producto producto : productos) { //Se recorren todos los productos inventariados
            if (producto.getCantidad() > productoMayorStock.getCantidad()){
                productoMayorStock = producto; //Si el stock es mayor se actualiza el producto almacenado
            }
        }
        return productoMayorStock;
    }
    //Método para mostrar las categorías disponibles
    public void mostrarCategoriasDisponibles(){
        CategoriaProducto[] categorias = CategoriaProducto.values();
        System.out.println("\nCategorías Disponibles: ");
        for (CategoriaProducto categoria : categorias) {
            System.out.println("» " + categoria);
        }
        System.out.println("");
    }
    //Método para filtrar productos por precio
    public ArrayList<Producto> filtrarProductosPorPrecio(double min, double max){
        if (min < 0 || max < 0) {
        System.out.println("ERROR: Los precios no pueden ser negativos.");
        return new ArrayList<>();
        }
        if (min > max) {
            System.out.println("ERROR: El precio mínimo no puede ser mayor al máximo.");
            return new ArrayList<>();
        }
        ArrayList<Producto> productosFiltrados = new ArrayList<>(); //Se crea una nueva lista que almacena los precios en el rango
        for (Producto producto : productos) {
            if (min <= producto.getPrecio() && producto.getPrecio() <= max){
                productosFiltrados.add(producto);
            }
        }
        return productosFiltrados;
    }
    
}
