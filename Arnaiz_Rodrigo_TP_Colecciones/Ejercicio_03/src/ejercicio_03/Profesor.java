package ejercicio_03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author RODRIGO
 */
public class Profesor {
    private final String id;
    private String nombre;
    private String especialidad;
    private final List<Curso> cursos;
    private static int contadorId = 0; //Se agrega un atributo static para crear un ID autoincremental

    public Profesor (String nombre, String especialidad){
        contadorId++;
        this.id = String.format("P%03d", contadorId);   
        this.setNombre(nombre);
        this.setEspecialidad(especialidad);
        this.cursos = new ArrayList<>();
    }
    //Gettters
    public String getId() { //Necesario para la búsqueda por ID
        return id;
    }

    public String getNombre() { //Necesario para mostrar info de cursos
        return nombre;
    }
    
    public List<Curso> getCursos() { //Necesario para la validación en asociación bidireccional
        return Collections.unmodifiableList(cursos);
    }
     //Setters
    private void setNombre(String nombre) {
        if(validarString(nombre)){
            this.nombre = nombre;
        }
    }
    private void setEspecialidad(String especialidad) {
        if(validarString(especialidad)){
            this.especialidad = especialidad;
        }
    }
    //Métodos
    @Override
    public String toString() {
        return "Profesor: (ID: " + id + "), Nombre: " + nombre + ", Especialidad: " + especialidad + ".";
    }

    //Método para mostrar la info del profesor
    public void mostrarInfo() {
        System.out.println(this.toString() + " Cursos a cargo: " + cursos.size() + ".");
    }
    //Método para agregar un curso a cargo del profesor garantizando asociación bilateral
    public void agregarCurso (Curso curso){
        //Verificar que el curso no sea null
        if (curso == null){
            System.out.println("\nEl curso no puede ser nulo.");
            return;
        }
        //Verificación que el curso no existe ya en la lista de cursos
        if (!cursos.contains(curso)){
            cursos.add(curso);
           //Se actualiza el profesor en el curso agregado
           if (curso.getProfesor() != this){
               curso.setProfesor(this);
           }
        }
    }
    //Métoddo para eliminar un curso de los cursos a cargo
    public void eliminarCurso(Curso curso){
        if (curso != null && cursos.contains(curso)){
            cursos.remove(curso);
            if (curso.getProfesor() == this) {
                curso.setProfesor(null);
            }
        }
    }
    //Método para mostrar todos los cursos del profesor
    public void listarCursos(){
        if (cursos.isEmpty()){
            System.out.println("No hay cursos a cargo");
        }
        else{
            System.out.println("Cursos a cargo:");
            for (Curso curso : cursos) {
                curso.mostrarInfo();
            }
        }
    }
    //Validaciones
    //Método para verificar que un String no esté vacío o en null 
    private static boolean validarString(String palabra) {
        boolean valido = true;
        if ((palabra == null) || (palabra.trim().equals(""))) { //Se eliminan espacios antes y delante del String y verifica que no esté vacío
            valido = false;
            System.out.println("ERROR: El campo no puede estar vacío.");
        }
        return valido;
    }
}
