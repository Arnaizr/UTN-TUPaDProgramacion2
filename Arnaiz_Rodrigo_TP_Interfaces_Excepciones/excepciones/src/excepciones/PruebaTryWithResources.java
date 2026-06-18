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
public class PruebaTryWithResources {
    public void lecturaArchivoAutoClose(String rutaArchivo){
        File archivo = new File(rutaArchivo);
        try(BufferedReader br = new BufferedReader(new FileReader(archivo))){
            
            String linea;
            while ((linea = br.readLine()) != null) {
            System.out.println(linea);
            }
        } catch (FileNotFoundException fnf){
            System.out.println("No se encontró el archivo");
        } catch (IOException ioe){
            System.out.println("Error de E/S");
        }

    }
}
