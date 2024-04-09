package proyectoestructura;

/**
 *
 * @author valer
 */

// lista doble circular
public class NodoH {
    private Habitacion elemento;
    private NodoH siguiente;
    private NodoH anterior;

    public NodoH() {
        this.siguiente = null;
        this.anterior = null;
    }

    public Habitacion getElemento() {
        return elemento;
    }

    public void setElemento(Habitacion elemento) {
        this.elemento = elemento;
    }

    public NodoH getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoH siguiente) {
        this.siguiente = siguiente;
    }

    public NodoH getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoH anterior) {
        this.anterior = anterior;
    }

    

    

    
    
    
    
    
}
