package arnaiz_rodrigo_trabajo_practico_integrador.entities;

import arnaiz_rodrigo_trabajo_practico_integrador.Service.Validaciones;
/**
 *
 * @author RODRIGO
 */
public class Producto extends Base{
    private String nombre;
    private double precio;
    private String descripcion;
    private int stock;
    private String imagen;
    private boolean disponible;
    private Categoria categoria;
    
    public Producto(String nombre, double precio, String descripcion, int stock, String imagen, boolean disponible, Categoria categoria){
        super(); 
        this.setNombre(nombre);
        this.setPrecio(precio);
        this.setDescripcion(descripcion);
        this.setStock(stock);
        this.setImagen(imagen);
        this.disponible = disponible;
        this.setCategoria(categoria);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        if (Validaciones.validarDoublePositivo(precio)){ //Se incorpora una validación simple para que el precio no sea negativo
        this.precio = precio;
        }
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        if (Validaciones.validarIntNoNegativo(stock)){ //Se incorpora una validacion simple para que el stock no sea negativo
        this.stock = stock;
        }
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria (Categoria categoria){ //Setter que garantiza la agregación bilateral e integridad referencial
        //Se verifica que la categoría no sea la misma que la cargada
        if (this.categoria == categoria){
            return;
        }
        //Se verifica que si hay una categoria cargada se elimine
        if (this.categoria != null){
            this.categoria.eliminarProducto(this);
        }
        //Establecer la categoria como la que contiene al producto
        this.categoria = categoria;
        //Añadir el producto a la categoría (si no es nula y si no está ya cargado)
        if (categoria != null && !categoria.getProductos().contains(this)){
            categoria.agregarProducto(this);
        }
    }
    //Métodos
    //Método para mostrar información completa del producto
    public void mostrarInfo(){
        System.out.println("Producto: #[" + getId() + "] | [" + nombre + "] | Precio: [$" + String.format("%.2f", precio) + "]| Stock: [" + stock + "]\n" +
                imagen + "\nDescripción: [" + descripcion + ".\nDisponible: " + (disponible ? "Si" : "No") + "\n");
    }
    //Método para cambiar la disponibilidad del producto
    public boolean isDisponible(){
               disponible = stock > 0; //Si hay al menos un producto en stock se considera disponible
           return disponible;
    }
     
    @Override
    public String toString() {
        return "Producto: #[" + getId() + "] | [" + nombre + "] | Precio: [$" + String.format("%.2f", precio) + "] | Stock: [" + stock + "]" + " | Categoria: " + categoria.getNombre();
    }
    

}
