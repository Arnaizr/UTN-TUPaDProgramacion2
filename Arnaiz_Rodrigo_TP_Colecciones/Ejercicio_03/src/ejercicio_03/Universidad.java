package ejercicio_03;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author RODRIGO
 */
public class Universidad {
    private String nombre;
    private final List<Profesor> profesores;
    private final List<Curso> cursos;
    
    public Universidad(String nombre){
        this.setNombre(nombre);
        this.profesores = new ArrayList<>();
        this.cursos = new ArrayList<>();
    }
    
     //Setters
    private void setNombre(String nombre) {
        if(validarString(nombre)){
            this.nombre = nombre;
        }
    }

    @Override
    public String toString() {
        return "Universidad{" + "nombre=" + nombre + '}';
    }
    
    //Métodos
    //Método para agregar un nuevo profesor
    public void agregarProfesor (Profesor p){
        if (p == null) {
            System.out.println("ERROR: El profesor no puede ser null.");
            return;
        }
        if (profesores.contains(p)){
            System.out.println("ERROR: El profesor " + p.getNombre() + " ya se encuentra cargado.");
            return;
        }
        this.profesores.add(p);
        System.out.println("Se agregó el profesor " + p.getNombre());
    }
    //Método para agregar un nuevo curso a la lista de cursos
    public void agregarCurso (Curso c){
        if (c == null) {
            System.out.println("ERROR: El curso no puede ser null.");
            return;
        }
        if (cursos.contains(c)){
            System.out.println("ERROR: El curso " + c.getNombre() + " ya se encuentra cargado.");
            return;
        }
        this.cursos.add(c);
        System.out.println("Se agregó el curso " + c.getNombre());
    }
        //Método para buscar un profesor por su ID
    public Profesor buscarProfesorPorId(String id){
        Profesor profEncontrado = null; //Se inicializa en null la variable de profesor encontrado
        Iterator<Profesor> it = this.profesores.iterator(); //Se crea un iterador para la búsqueda
        while (it.hasNext() && profEncontrado == null){ //Se repite mientras haya profesores en la colección y mientras no encuentre el ID
            Profesor p = it.next(); //Se carga el profesor actual de la iteración de la colección
            if (p.getId().equalsIgnoreCase(id)){
                profEncontrado = p; //Si coincide el id se asocia a profEncontrado
            }
        }
        return profEncontrado;
    }
    //Método para buscar un curso por su código
    public Curso buscarCursoPorCodigo(String codigo){
        Curso cursoEncontrado = null; //Se inicializa en null la variable de curso encontrado
        Iterator<Curso> it = this.cursos.iterator(); //Se crea un iterador para la búsqueda
        while (it.hasNext() && cursoEncontrado == null){ //Se repite mientras haya cursos en la colección y mientras no encuentre el codigo
            Curso c = it.next(); //Se carga el curso actual de la iteración de la colección
            if (c.getCodigo().equalsIgnoreCase(codigo)){
                cursoEncontrado = c; //Si coinciden los códigos  se asigna a cursoEncontrado
            }
        }
        return cursoEncontrado;
    }
    //Método para asignar un profesor a un curso
    public void asignarProfesorACurso(String codigoCurso, String idProfesor){
        Curso cursoAAsignar = buscarCursoPorCodigo(codigoCurso);
        if (cursoAAsignar == null){
            System.out.println("ERROR: No hay curso con código: " + codigoCurso);
            return;
        }
        Profesor profAAsignar = buscarProfesorPorId(idProfesor);
        if (profAAsignar == null){
            System.out.println("ERROR: No hay profesor con id: " + idProfesor);
            return;
        }
        cursoAAsignar.setProfesor(profAAsignar);
        System.out.println("Se asignó el profesor " + profAAsignar.getNombre() + " al curso " + cursoAAsignar.getNombre());
    }
    //Método para eliminar un curso de la universidad
    public void eliminarCurso (String codigo){
        Curso cursoAEliminar = buscarCursoPorCodigo(codigo);
        if (cursoAEliminar == null){
            System.out.println("ERROR: No hay curso con código: " + codigo);
            return;
        }
        Profesor profeDelCurso = cursoAEliminar.getProfesor(); //Se obtiene el profesor del curso
        if (profeDelCurso != null){
            profeDelCurso.eliminarCurso(cursoAEliminar); //Si el curso tiene un profesor asignado se desasocia de sus cursos
        }
        cursos.remove(cursoAEliminar); //Finalmente se elimina el curso de la lista de cursos (no se elimina el objeto en si)
    }
    //Mëtodo para eliminar un profesor de la universidad (y desvincular los cursos)
    public void eliminarProfesor (String id){
        Profesor profeAEliminar = buscarProfesorPorId(id);
        if (profeAEliminar == null){
            System.out.println("ERROR: No hay profesor con id: " + id);
            return;
        }
        List<Curso> cursosProfe = new ArrayList<>(profeAEliminar.getCursos()); //Se obtiene la lista de cursos del profesor
        for (Curso curso : cursosProfe) {
            curso.setProfesor(null); //Se setea en null el profesor responsable de cada uno de los cursos
        }
        profesores.remove(profeAEliminar); //Se elimina el profesor de la lista de profesores
    }
    //Método para mostrar todos los profesores de la universidad
    public void listarProfesores(){
        if (profesores.isEmpty()){
            System.out.println("No hay profesores registrados");
        }
        else{
            System.out.println("");
            for (Profesor profesor : profesores) {
                profesor.mostrarInfo();
                profesor.listarCursos();
            }
        }
    }
    //Método para mostrar todos los cursos de la universidad
    public void listarCursos(){
        if (cursos.isEmpty()){
            System.out.println("No hay cursos registrados");
        }
        else{
            System.out.println("");
            for (Curso curso : cursos) {
                curso.mostrarInfo();
            }
        }
    }
    //Método para mostrar únicamente el reporte de profesores con cantidad de cursos
    public void reporteCursosDeProfesor(){
        System.out.println("\nReporte de cursos de cada profesor: \n");
        if (profesores.isEmpty()){
            System.out.println("No hay profesores registrados");
        }
        else{
            for (Profesor profesor : profesores) {
                System.out.println(profesor.getNombre() + " (ID: " + profesor.getId() + "), Cursos a cargo: " + profesor.getCursos().size() + ".");
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
