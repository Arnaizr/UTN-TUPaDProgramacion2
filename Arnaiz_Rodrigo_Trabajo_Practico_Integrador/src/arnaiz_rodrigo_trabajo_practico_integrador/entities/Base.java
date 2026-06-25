package arnaiz_rodrigo_trabajo_practico_integrador.entities;

import java.time.LocalDateTime;

/**
 *
 * @author RODRIGO
 */
public abstract class Base {
    private final long id;
    private boolean eliminado = false;
    private final LocalDateTime createdAt;
    
    
    public Base(long id){ //Se recibe únicamente como parámetro el id que cada clase crea independientemente
        this.id =  id;
        this.createdAt = LocalDateTime.now();
    }

    public long getId() {
        return id;
    }
    
    public boolean isEliminado() {
        return eliminado;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    
    public void setEliminado(boolean eliminado){
        this.eliminado = eliminado;
    }

    @Override
    public abstract String toString();   
    
}