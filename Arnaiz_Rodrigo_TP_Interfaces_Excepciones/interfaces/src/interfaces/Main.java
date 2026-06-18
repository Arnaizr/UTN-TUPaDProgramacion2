package interfaces;

/**
 *
 * @author RODRIGO
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("\n---INICIO DEL PROGRAMA---\n");
        System.out.println("---E-Commerce con interfaces---\n");
        
        System.out.println("Cargando productos...");
        Producto prod1 = new Producto("Papa", 1500);
        Producto prod2 = new Producto("Banana", 2500);
        Producto prod3 = new Producto("Manzana", 3500);
        Producto prod4 = new Producto("Brocoli", 4500);
        Producto prod5 = new Producto("Palta", 5500);
        Producto prod6 = new Producto("Kiwi", 6500);
        Producto prod7 = new Producto("Portobello", 7500);
        System.out.println("Ingresando cliente...");
        Cliente cliente1 = new Cliente("Juan Perez", "31313131", "juanperez76@gmail.com");
        System.out.println("Ingresando medio de pago...");
        TarjetaCredito tarjetaperez = new TarjetaCredito(true, 60000, "ICBC", "1324909834069");
        System.out.println("Ingresando pedido...");
        Pedido pedidocliente1 = new Pedido(cliente1);
        System.out.println("Agregando productos:");
        pedidocliente1.agregarProducto(prod7);
        pedidocliente1.agregarProducto(prod7);
        pedidocliente1.agregarProducto(prod1);
        pedidocliente1.agregarProducto(prod2);
        pedidocliente1.agregarProducto(prod3);
        pedidocliente1.agregarProducto(prod2);
        System.out.println("Carga finalizada, el total es: $" + String.format("%.2f", pedidocliente1.calcularTotal()));
        pedidocliente1.procesarPago(tarjetaperez);
        System.out.println("Fin de la operación de " + cliente1);
        System.out.println("Ingresando cliente...");
        Cliente cliente2 = new Cliente("Menganito Gonzalez", "32323232", "Elmenganito@gmail.com");
        System.out.println("Ingresando medio de pago...");
        PayPal paypalmengano = new PayPal (10000, cliente2.getEmail());
        System.out.println("Ingresando pedido...");
        Pedido pedidocliente2 = new Pedido(cliente2);
        System.out.println("Agregando productos:");
        pedidocliente2.agregarProducto(prod6);
        pedidocliente2.agregarProducto(prod7);
        pedidocliente2.agregarProducto(prod6);
        pedidocliente2.agregarProducto(prod5);
        pedidocliente2.agregarProducto(prod4);
        pedidocliente2.agregarProducto(prod1);
        pedidocliente2.agregarProducto(prod5);
        pedidocliente2.agregarProducto(prod7);
        System.out.println("Carga finalizada, el total es: $" + String.format("%.2f", pedidocliente2.calcularTotal()));
        pedidocliente2.procesarPago(paypalmengano);
        System.out.println("Fin de la operación de " + cliente2);
    }
    
}
