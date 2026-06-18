package ejercicio_04;

/**
 *
 * @author RODRIGO
 */
public class Main {

   
    public static void main(String[] args) {
      //Declaración/incialización de objetos con constructores
        //Inicialización con constructor completo
        System.out.println("\n--- Cargando productos... ---\n");

        Producto prod1 = new Producto("Jabón", 735.89); //Carga completa 
        Producto prod2 = new Producto("Shampoo", -300.15); //Carga con precio negativo
        Producto prod3 = new Producto("", 250.99); //Carga sin nombre


        //Inicialización con constructor parcial
        Producto prod4 = new Producto("Queso cremoso"); //Carga con nombre (precio predeterminado)
        Producto prod5 = new Producto(null); //Carga con null (precio predeterminado)


        System.out.println("\n--- Mostrando datos iniciales ---\n");

        System.out.println(prod1);
        System.out.println(prod2);
        System.out.println(prod3);
        System.out.println(prod4);
        System.out.println(prod5);
        
        //Carga de datos con setters
        System.out.println("\n--- Cargando datos faltantes ---\n");
        
        prod5.setNombre("Tomate");
        prod3.setNombre("Pollo");
        System.out.println(prod5);
        System.out.println(prod3);
        

        System.out.println("\n--- Aplicar descuentos ---\n");
        //Aplicando metodos para descuentos
        //Metodo para descuento con porcentaje
        prod5.aplicarDescuento(30); //Se aplica directamente un 30% de descuento
        prod1.aplicarDescuento(-0.5); //Se intenta aplicar un porcentaje negativo
        prod1.aplicarDescuento(200); //Se intenta aplicar un porcentaje mayor al 100%
        //Metodo para descuento con porcentaje y precio mínimo
        
        prod4.aplicarDescuento(30, 90); //Se aplica un 30% con un precio mínimo de 90
        prod2.aplicarDescuento(30, 60); //Se aplica un 30% con un precio mínimo de 60
        prod1.aplicarDescuento(20, 900); //Se intenta aplicar un monto mínimo mayor al precio base
        prod3.aplicarDescuento(0, 250); //Se intenta aplicar un 0% de descuento (mantener precio)
        
        System.out.println("\n--- Mostrando descuentos aplicados---\n");
        
        System.out.println(prod1); //Debería quedar con el precio final igual al anterior (parametros incorrectos)
        System.out.println(prod2);//Debería quedar con el 30% aplicado
        System.out.println(prod3); //Debería quedar con el precio final igual al anterior (0% decuento)
        System.out.println(prod4);//Debería quedar con el tope de precio mínimo
        System.out.println(prod5); //Debería quedar un 30% más barato
    
        System.out.println("\n--- Modificando el monto del IVA---\n");
        
        Producto.cambiarIVA(300.5); //Se intenta cambiar el IVA por un porcentaje incorrecto
        Producto.cambiarIVA(10.5); //Se cambia el IVA para todos los productos
        
        System.out.println("\n--- PRECIOS FINALES ---\n");
        
        System.out.println(prod1);
        System.out.println(prod2);
        System.out.println(prod3);
        System.out.println(prod4);
        System.out.println(prod5);

        System.out.println("\n\n----- FIN DEL PROGRAMA ------");
    }   
    
}
