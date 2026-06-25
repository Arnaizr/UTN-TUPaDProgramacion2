package arnaiz_rodrigo_trabajo_practico_integrador.entities;

import arnaiz_rodrigo_trabajo_practico_integrador.Service.Validaciones;
import arnaiz_rodrigo_trabajo_practico_integrador.exceptions.InvalidFieldException;
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
    private static long contadorId = 0;  //Se crea un contador estático de clase para la instanciación automática del id
    
    public Producto(String nombre, double precio, String descripcion, int stock, String imagen, boolean disponible, Categoria categoria){
        super(++contadorId); //Se envía como parámetro el contador incrementado a la clase base
        this.setNombre(nombre);
        this.setPrecio(precio);
        this.setDescripcion(descripcion);
        this.setStock(stock);
        this.setImagen(imagen);
        this.setDisponible(disponible);
        this.setCategoria(categoria);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (!Validaciones.validarStringNoVacio(nombre)){
            throw new InvalidFieldException("El nombre no puede estar vacío.");
        }
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        if (Validaciones.validarDoubleNoNegativo(precio)){
            throw new InvalidFieldException("El precio debe ser positivo.");
        }
        this.precio = precio;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
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
        if (Validaciones.validarIntNoNegativo(stock)){
            throw new InvalidFieldException("El stock no puede ser negativo.");
        }
        this.stock = stock;
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
    
    @Override
    public String toString() {
        return "Producto: #[" + getId() + "] | [" + nombre + "] | Precio: [$" + String.format("%.2f", precio) + "] | Stock: [" + stock + "]" + " | Categoria: " + categoria.getNombre();
    }
    

}
