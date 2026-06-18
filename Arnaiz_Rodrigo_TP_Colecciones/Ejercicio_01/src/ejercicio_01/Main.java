package ejercicio_01;

import java.util.ArrayList;

/**
 *
 * @author RODRIGO
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("\n---INICIO DEL PROGRAMA---\n\n");
        //Carga de nuevos productos con constructor completo
        Producto prod1 = new Producto("Papa", 1500, 150, CategoriaProducto.ALIMENTOS);
        Producto prod2 = new Producto("Tomate", 2000, 90, CategoriaProducto.ALIMENTOS);
        Producto prod3 = new Producto("Remera", 20000, 10, CategoriaProducto.ROPA);
        Producto prod4 = new Producto("Buzo", 35000, 15, CategoriaProducto.ROPA);
        Producto prod5 = new Producto("Plato", 2800, 60, CategoriaProducto.HOGAR);
        //Carga de nuevos productos con constructor parcial (sin stock)
        Producto prod6 = new Producto("Vaso", 4800, CategoriaProducto.HOGAR);
        Producto prod7 = new Producto("Mandarina", 3200, CategoriaProducto.ALIMENTOS);
        Producto prod8 = new Producto("Mouse", 9800, CategoriaProducto.ELECTRONICA);
        Producto prod9 = new Producto("Monitor", 200000, CategoriaProducto.ELECTRONICA);
        //Creación de un nuevo inventario
        Inventario inventario1 = new Inventario();
        //Incorporación de los productos al inventario
        inventario1.agregarProducto(prod1);
        inventario1.agregarProducto(prod2);
        inventario1.agregarProducto(prod3);
        inventario1.agregarProducto(prod4);
        inventario1.agregarProducto(prod5);
        inventario1.agregarProducto(prod6);
        inventario1.agregarProducto(prod7);
        inventario1.agregarProducto(prod8);
        inventario1.agregarProducto(prod9);
        //Listado de todos los productos del inventario
        System.out.println("Listando todos los productos inventariados...");
        inventario1.listarProductos();
        //Buscar producto por ID
        System.out.println("\nMostrando información del producto con ID E003:");
        Producto productoBuscado = inventario1.buscarProductoPorId("E003");
        System.out.println(productoBuscado == null ? "No existe el item con ID E003" : productoBuscado);
        //Buscamos un producto con ID inexistente
        System.out.println("\nMostrando información del producto con ID E023:");
        productoBuscado = inventario1.buscarProductoPorId("E023");
        System.out.println(productoBuscado == null ? "No existe el item con ID E023" : productoBuscado);

        //Filtrar productos por categoria
        System.out.println("\nMostrando productos de la categoría " + CategoriaProducto.ALIMENTOS.name());
        ArrayList<Producto> catAlimentos = inventario1.filtrarPorCategoria(CategoriaProducto.ALIMENTOS);
        mostrarFiltrados(catAlimentos);
        
        //Eliminación de un producto por su ID
        System.out.println("\nEliminando el producto de ID E009");
        inventario1.eliminarProducto("E009");
        //Intento de eliminacion de un producto inexistente
        System.out.println("\nEliminando el producto de ID E029");
        inventario1.eliminarProducto("E029");
        //Mostrando la lista actualizada
        inventario1.listarProductos();
        //Actualizar el stock de un producto
        System.out.println("\nActualizando stock del producto E007");
        inventario1.actualizarStock("E007", 400);
        //Intento de actualización con un valor negativo
        System.out.println("\nActualizando stock del producto E008");
        inventario1.actualizarStock("E008", -8);
        inventario1.actualizarStock("E008", 8);
        //Mostrar el stock de todos los productos
        System.out.println("\nEl total de stock de todos los productos es: " + inventario1.obtenerTotalStock() + ".");
        //Mostrar el producto con mayor stock
        Producto productoMayorStock = inventario1.obtenerProductoConMayorStock();
        System.out.println(productoMayorStock == null ? "\nNo hay stock máximo" : "\nEl producto con mayor stock es: \n" + productoMayorStock);
       //Mostrar los productos con precio en un rango de $1500 a $3000
        System.out.println("\nMostrando productos en un rango de precio de $1500 a $3000:");
       ArrayList<Producto> productosEnRango = inventario1.filtrarProductosPorPrecio(1500, 3000);
       mostrarFiltrados(productosEnRango);
       
       //Mostrando categorías disponibles
   
       inventario1.mostrarCategoriasDisponibles();
        System.out.println("\n\n----FIN DEL PROGRAMA----\n");
    }
    
    
    public static void mostrarFiltrados (ArrayList<Producto> filtrado){ //Método para mostrar el array con valores filtrados
        if (filtrado.isEmpty()){
            System.out.println("No se encontraron productos.");
        return;
    }
        for (Producto producto : filtrado) {
            producto.mostrarInfo();
        }
    }
}
