package excepciones;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author RODRIGO
 */
public class LecturaArchivo {
    public void leerArchivo(String rutaArchivo){
        File archivo = new File(rutaArchivo);
        BufferedReader br = null;
        try{
            br = new BufferedReader(new FileReader(archivo));
            String linea;
            while ((linea = br.readLine()) != null) {
            System.out.println(linea);
            }
        } catch (FileNotFoundException fnf){
            System.out.println("No se encontró el archivo");
        } catch (IOException ioe){
            System.out.println("Error de E/S");
        }
        finally{
            if (br != null){
                try {
                    br.close();
                } catch (IOException ex) {
                    System.out.println("No se pudo liberar el Buffer Reader");
            }
            }
        }
    }
}
