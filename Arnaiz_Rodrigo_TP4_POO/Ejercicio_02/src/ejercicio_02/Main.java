package ejercicio_02;

/**
 *
 * @author RODRIGO
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    //Declaración/incialización de objetos con constructores
    //Inicialización con constructor parcial
    System.out.println("\n--- Cargando libros... ---\n");

    Libro libro1 = new Libro("Infierno", "Dan Brown"); //Carga completa (editorial por defecto)
    Libro libro2 = new Libro("Longitud", " "); //Carga con autor vacio  (editorial por defecto)
    Libro libro3 = new Libro("", "Patrick Rothfuss"); //Carga sin titulo  (editorial por defecto)
    Libro libro4 = new Libro(null, "J. R. R. Tolkien"); //Carga con titulo null  (editorial por defecto)
    
    System.out.println("\n--- Mostrando datos iniciales ---");

    System.out.println(libro1);//Se muestra con editorial independiente
    System.out.println(libro2);//Se muestra con editorial independiente
    System.out.println(libro3);//Se muestra con editorial independiente
    System.out.println(libro4);//Se muestra con editorial independiente
    
    //Inicialización con constructor completo
    Libro libro5 = new Libro("Fisica Conceptual", "Paul G. Hewitt", "Addison-Wesley"); //Carga con nombre vacío y puesto null (sueldo por defecto)
    
    Libro libro6 = new Libro("Juego de Tronos", "George R. R. Martin", null);//Carga con editorial null (sin sobreescribir)

    //Salida inicial 
    System.out.println("\n--- Mostrando datos iniciales ---");

    System.out.println(libro1);//Se muestra con editorial Addison-Wesley
    System.out.println(libro2);//Se muestra con editorial Addison-Wesley
    System.out.println(libro3);//Se muestra con editorial Addison-Wesley
    System.out.println(libro4);//Se muestra con editorial Addison-Wesley
    System.out.println(libro5);//Se muestra con editorial Addison-Wesley
    System.out.println(libro6);//Se muestra con editorial Addison-Wesley

    //Agregando un nuevo libro con todos los datos
    Libro libro7 = new Libro("Harry Potter", "J. K. Rowling", "Emecé"); //Carga completa (Se carga con editorial Emecé)

    System.out.println("\n--- Mostrando datos con libro 7---");
    System.out.println(libro1);//Se muestra con editorial Emecé
    System.out.println(libro2);//Se muestra con editorial Emecé
    System.out.println(libro3);//Se muestra con editorial Emecé
    System.out.println(libro4);//Se muestra con editorial Emecé
    System.out.println(libro5);//Se muestra con editorial Emecé
    System.out.println(libro6);//Se muestra con editorial Emecé
    System.out.println(libro7);//Se muestra con editorial Emecé

    //Carga de datos con setters
    System.out.println("\n--- Cargando datos faltantes ---");

    libro2.setAutor("Dava Sobel");
    
    //Actualizar titulos con método
    
    libro3.actualizarTitulo("El nombre del viento"); //Se actualiza el atributo
    
    libro4.actualizarTitulo(" ", "La comunidad del anillo"); //Se intenta actualizar con un prefijo vacio
    libro4.actualizarTitulo("El señor de los anillos -", "La comunidad del anillo"); //Se actualiza y concatena con el prefijo
    
   
    System.out.println("\n--- Mostrando datos actualizados ---");
    System.out.println(libro1);//Se muestra con editorial Emecé
    System.out.println(libro2);//Se muestra con editorial Emecé
    System.out.println(libro3);//Se muestra con editorial Emecé
    System.out.println(libro4);//Se muestra con editorial Emecé
    System.out.println(libro5);//Se muestra con editorial Emecé
    System.out.println(libro6);//Se muestra con editorial Emecé
    System.out.println(libro7);//Se muestra con editorial Emecé

    System.out.println("\n--- Actualizar editorial ---");
    //Actualizar la editorial con null
    
    Libro.cambiarEditorial(null);
    
    //Actualizar editorial con string válido
    
    Libro.cambiarEditorial("DeBolsillo");
    
    //Salida final de datos        
    System.out.println("\n--- Mostrando datos finales ---");

    System.out.println(libro1);//Se muestra con editorial DeBolsillo
    System.out.println(libro2);//Se muestra con editorial DeBolsillo
    System.out.println(libro3);//Se muestra con editorial DeBolsillo
    System.out.println(libro4);//Se muestra con editorial DeBolsillo
    System.out.println(libro5);//Se muestra con editorial DeBolsillo
    System.out.println(libro6);//Se muestra con editorial DeBolsillo
    System.out.println(libro7);//Se muestra con editorial DeBolsillo

    System.out.println("\n--- FIN DEL PROGRAMA ---");
    }

}

