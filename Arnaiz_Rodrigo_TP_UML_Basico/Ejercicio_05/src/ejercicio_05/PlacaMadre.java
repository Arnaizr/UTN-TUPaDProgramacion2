package ejercicio_05;

/**
 *
 * @author RODRIGO
 */
public class PlacaMadre {
    private String modelo;
    private String chipset;
    
    public PlacaMadre(String modelo, String chipset){
        this.setModelo(modelo);
        this.setChipset(chipset);
    }
    
    private void setModelo(String modelo){
        if (validarString(modelo)) {
            this.modelo = modelo;
        }
    }
    
    private void setChipset(String chipset){
        if (validarString(chipset)) {
            this.chipset = chipset;
        }
    }

    @Override
    public String toString() {
        return "Placa: " + modelo + ", Chipset: " + chipset;
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
