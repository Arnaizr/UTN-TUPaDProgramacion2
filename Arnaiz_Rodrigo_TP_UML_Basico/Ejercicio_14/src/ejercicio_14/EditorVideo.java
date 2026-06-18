package ejercicio_14;

/**
 *
 * @author RODRIGO
 */
public class EditorVideo {
    public EditorVideo(){
    }
    public void exportar (String formato, Proyecto proyecto){ //Se reciben los atributos para el método
        Render render = new Render(formato); //Se crea el render con el formato recibido
        render.setProyecto(proyecto); //Se setea el proyecto aparte por ser una asociación unilateral
        System.out.println("Renderizando...\n" + render); //Se muestra el objeto creado
    }
}
