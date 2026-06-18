package ejercicio_13;

/**
 *
 * @author RODRIGO
 */
public class GeneradorQR {
    public GeneradorQR(){
    }
    public void generar (String valor, Usuario usuario){ //Se reciben los atributos para el método
        CodigoQR codigoQR = new CodigoQR(valor); //Se crea el código con el String recibido
        codigoQR.setUsuario(usuario); //Se setea el usuario aparte por ser una asociación unilateral
        System.out.println("Creación exitosa!! \n" + codigoQR); //Se muestra el objeto creado
    }
}
