package ejercicio_03;


/**
 *
 * @author RODRIGO
 */
public class Curso {
    private final String codigo;
    private String nombre;
    private Profesor profesor;
    private static int contadorCodigo = 0; //Se agrega un atributo static para crear un Codigo autoincremental

    public Curso (String nombre){
        contadorCodigo++;
        this.codigo = String.format("C%04d", contadorCodigo);   
        this.setNombre(nombre);
        
    }
    //Getters
    public Profesor getProfesor() { //Necesario para la asociación bidireccional
        return profesor;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCodigo() { //Necesario para la búsqueda por código
        return codigo;
    }
    
     //Setters
    private void setNombre(String nombre) {
        if(validarString(nombre)){
            this.nombre = nombre;
        }
    }
    public void setProfesor (Profesor profesor){ //Setter que garantiza la asociación bilateral e integridad referencial
        //Se verifica que el profesor no sea el mismo cargado
        if (this.profesor == profesor){
            return;
        }
        //Se verifica que si hay un profesor cargado se elimine
        if (this.profesor != null){
            this.profesor.eliminarCurso(this);
        }
        //Establecer el profesor como responsable del curso
        this.profesor = profesor;
        //Añadir el curso a cargo del profesor (si no es nulo y si no está ya cargado)
        if (profesor != null && !profesor.getCursos().contains(this)){
            profesor.agregarCurso(this);
        }
    }

    @Override
    public String toString() {
        return "Curso: (" + codigo + "), Nombre: " + nombre + ", Profesor: " + (profesor !=null ? profesor.getNombre() : "Sin asignar") + ".";
    }
    //Métodos
    //Método para mostrar la info del curso
    public void mostrarInfo() {
        System.out.println(this.toString());
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
