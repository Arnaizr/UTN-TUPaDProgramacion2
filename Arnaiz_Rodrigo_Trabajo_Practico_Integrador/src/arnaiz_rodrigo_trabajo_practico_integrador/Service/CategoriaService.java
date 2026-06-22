 package arnaiz_rodrigo_trabajo_practico_integrador.Service;

import arnaiz_rodrigo_trabajo_practico_integrador.entities.Categoria;
import arnaiz_rodrigo_trabajo_practico_integrador.enums.CampoCategoria;
import arnaiz_rodrigo_trabajo_practico_integrador.exceptions.DuplicateEntityException;
import arnaiz_rodrigo_trabajo_practico_integrador.exceptions.EntityNotEmptyException;
import arnaiz_rodrigo_trabajo_practico_integrador.exceptions.EntityNotFoundException;
import arnaiz_rodrigo_trabajo_practico_integrador.exceptions.InvalidFieldException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author RODRIGO
 */
public class CategoriaService {
    private final List<Categoria> categorias;
    
    public CategoriaService(){
        this.categorias = new ArrayList<>();
    }
    
    public void listarCategorias(){
        List<Categoria> activas = new ArrayList<>();
        for (Categoria categoria : categorias) {
            if (!categoria.isEliminado()){
                activas.add(categoria);
            }
        }
        if (activas.isEmpty()){
            System.out.println("No hay categorias cargadas en el sistema.");
            return;
        }
        System.out.println("================================================================");
        for (Categoria categoria : activas) {
            System.out.println(categoria);
        }
        System.out.println("================================================================");
    }
    
    
    public Categoria createCategoria(String nombre, String descripcion){
        if (existeNombre(nombre)){ //Se llama al método que busca si existe el nombre en la lista de categorias
            throw new DuplicateEntityException("Ya existe una categoría con el nombre: " + nombre);
        }
        Categoria nueva = new Categoria(nombre, descripcion);
        categorias.add(nueva);
        return nueva;        
    }
    
    //Método para buscar un categoria por su id asociado
    public Categoria findCategoriaById(long id){
        Categoria categoriaEncontrada = null; //Se inicializa en null la variable de categoria encontrada
        Iterator<Categoria> it = this.categorias.iterator(); //Se crea un iterador para la búsqueda
        while (it.hasNext() && categoriaEncontrada == null){ //Se repite mientras haya categorias en la colección y mientras no encuentre la categoria
            Categoria categoriaBucle = it.next(); //Se carga la categoria actual de la iteración de la colección
            if (id == categoriaBucle.getId()&& !categoriaBucle.isEliminado()){
                categoriaEncontrada = categoriaBucle;
            }
        }
        if (categoriaEncontrada == null){
            throw new EntityNotFoundException ("No se encontró una categoria con id: " + id);
        }
        return categoriaEncontrada;
    }
    
    //Método para eliminar una categoria por su id
    public void deleteCategoriaById(long id){
        try {
            Categoria categoriaAEliminar = findCategoriaById(id); //Se busca la categoria con el id ingresado
            if (!categoriaAEliminar.getProductos().isEmpty()){ //Se verifica que la categoría esté vacía y se lanza una excepción si no lo está
                throw new EntityNotEmptyException("La categoría " + categoriaAEliminar.getNombre() + " tiene productos asociados");
            }
            categoriaAEliminar.setEliminado(true); //Se hace la baja lógica de la categoria
            System.out.println("Se eliminó la categoria con id: " + id);
        }
        catch (EntityNotFoundException | EntityNotEmptyException e){ //Se atrapa la excepción de no encontrar la categoría o que no está vacía
            System.out.println(e.getMessage());
        }
    }
    
    public void editCategoria(long id, CampoCategoria campo, String nuevoValor){
        try{
            Categoria categoriaAEditar = findCategoriaById(id);
            switch (campo){
                case NOMBRE -> {
                            if (existeNombre(nuevoValor)){ 
                               throw new DuplicateEntityException("Ya existe la categoría con el nombre: "  + nuevoValor);
                            }
                            categoriaAEditar.setNombre(nuevoValor);
                            }
                case DESCRIPCION -> categoriaAEditar.setDescripcion(nuevoValor);
                }
            System.out.println("Se cambió el atributo " + campo.name() + " de la categoria : #" + categoriaAEditar.getId() + " por: " + nuevoValor + ".");
        }
        catch (EntityNotFoundException | DuplicateEntityException | InvalidFieldException e){
            System.out.println(e.getMessage());
        }
    }
     
    //Método que recorre todas las categorías en busca de un nombre que ya existe
    private boolean existeNombre(String nombre){
        boolean existe = false;
        for (Categoria categoria : categorias) {
            if (categoria.getNombre().equals(nombre)){
                existe = true;
            }
        }
        return existe;
    }
}
