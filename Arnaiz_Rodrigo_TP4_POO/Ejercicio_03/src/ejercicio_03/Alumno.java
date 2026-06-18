package ejercicio_03;

/**
 *
 * @author RODRIGO
 */
public class Alumno {
    private String nombre;
    private double promedio;
    private static double notaAprobacion = 6;
    //Constructores
    //Constructor principal (todos los parámetros)
    public Alumno(String nombre, double promedio){
        this.setNombre(nombre); //Se llama al setter para cargar el nombre
        this.setPromedio(promedio); //Se llama al setter para cargar el promedio
    }
    //Constructor secundario
    public Alumno(String nombre){
        this(nombre, 0); //Se crea el objeto con el promedio predeterminado
    }
  /*  
    public String getNombre() { //La consigna no solicita generar getters, se dejan comentados los valores de devuelven por stringTo
        return nombre;
    }
*/
    public void setNombre(String nombre) { //Se deja público 
        if (validarString(nombre)) {       
            this.nombre = nombre;
            return;
        }
        this.nombre = "*Pendiente de carga*";
    }
/*
    public double getPromedio() {//La consigna no solicita generar getters, se dejan comentados los valores de devuelven por stringTo
        return promedio;
    }
*/
    private void setPromedio(double promedio) {
        if (validarCalificacion(promedio)) {       
            this.promedio = promedio;
        }
        
    }
/*
    public static double getNotaAprobacion() { //La consigna no solicita generar getters, se dejan comentados los valores de devuelven por stringTo
        return notaAprobacion;
    }
*/
    private static void setNotaAprobacion(double notaAprobacion) {
        Alumno.notaAprobacion = notaAprobacion;
    }
    //Override de toString
    @Override
    public String toString() {
        return "Alumno{" + "Nombre = " + nombre + ", Promedio = " + promedio + ", Aprueba: " + (aprobo() ? "Si" : "No") + '}';
    }
    
    //Métodos
    //Metodo para actualizar el promedio con un double
    public void actualizarPromedio(double nuevoPromedio) { 
        if (validarCalificacion(nuevoPromedio)){ 
            setPromedio(nuevoPromedio); //Se envía el nuevo promedio al setter         
        }  
    }                  
    //Metodo para actualizar el promedio con un array de notas
    public void actualizarPromedio(double[] notas) {
        double nuevoPromedio = 0; //Se inicializa la variable auxiliar
        for (int i = 0; i < notas.length; i++){ 
            nuevoPromedio += notas[i];  //Se acumulan las notas del array
        }
        nuevoPromedio = nuevoPromedio / notas.length; //Se calcula el promedio con las notas
        if (validarCalificacion(nuevoPromedio)){ 
            setPromedio(nuevoPromedio); //Se envía el nuevo promedio al setter  
        }  
    }                  
    //Metodo para calcular si aprobó según el promedio
    public boolean aprobo(){
        return (this.promedio >= notaAprobacion);
    }
    //Método para cambiar la nota mínima de aprobación
    public static  void cambiarNotaAprobacion(double nueva){
        if (validarCalificacion(nueva)){
            setNotaAprobacion(nueva);
            System.out.println("La nueva nota para aprobar es " + nueva );
        }
    }
    //Validaciones
    //Metodo para verificar que la calificación esté en el rango deseado
    private static boolean validarCalificacion (double num) {
        boolean positivo = true;
        if ((num < 0) || (num > 10)){
            positivo = false;
            System.out.println("El valor ingresado debe estar entre cero y diez.");
        }
    return positivo;
}
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
