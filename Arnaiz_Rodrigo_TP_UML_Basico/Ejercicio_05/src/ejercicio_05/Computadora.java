package ejercicio_05;

/**
 *
 * @author RODRIGO
 */
public class Computadora {
    private String marca;
    private String numeroSerie;
    private final PlacaMadre placa;
    private Propietario propietario;

    public Computadora(String marca, String numeroSerie, String modelo, String chipset) { //Constructor de atributos propios y datos para la placa madre
        this.setMarca(marca);
        this.setNumeroSerie(numeroSerie);
        this.placa = new PlacaMadre(modelo, chipset); //Se crea la computadora con la clase PlacaMadre como Composición
    } 
    
    public Propietario getPropietario(){ //Getter para relación bidireccional con propietario
        return propietario;
    }
    public String getNumeroSerie(){ //Getter para mostrar datos en toString del propietario
        return numeroSerie;
    }
    
    private void setMarca(String marca) { //Setter privado para constructor
        if (validarString(marca)) {
            this.marca = marca;            
        }
    }
   
    private void setNumeroSerie(String numeroSerie) { //Setter privado para constructor
        if (validarString(numeroSerie)) {
            this.numeroSerie = numeroSerie;
        }
    }

    public void setPropietario(Propietario propietario) { //Setter bidireccional para propietario
        this.propietario = propietario;
        if (propietario != null && propietario.getComputadora() != this) {
            propietario.setComputadora(this);
        }
    }
    //override de toString para mostrar atributos
    @Override
    public String toString() {
        return "Computadora Nº: " + numeroSerie + ", Marca: " + marca + ", " + placa + ", Propietario: " + (propietario !=null ? propietario.getNombre() : "Sin propietario") + ".";
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
