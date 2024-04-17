package proyectoestructura;

/**
 *
 * @author valer
 */

// lista doble circular
public class NodoHabitacion {
    private Habitacion elemento;
    private NodoHabitacion siguiente;
    private NodoHabitacion anterior;

    public NodoHabitacion() {
        this.siguiente = null;
        this.anterior = null;
    }

    public Habitacion getElemento() {
        return elemento;
    }

    public void setElemento(Habitacion elemento) {
        this.elemento = elemento;
    }

    public NodoHabitacion getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoHabitacion siguiente) {
        this.siguiente = siguiente;
    }

    public NodoHabitacion getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoHabitacion anterior) {
        this.anterior = anterior;
    }

    

    

    
    
    
    
    
}
