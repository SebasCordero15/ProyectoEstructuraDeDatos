package proyectoestructura;

/**
 *
 * @author valer
 */
public class NodoActividad {
    private Actividad dato;
    private NodoActividad siguiente;
    
    public NodoActividad(){
        this.siguiente = null;
    }

    public Actividad getDato() {
        return dato;
    }

    public void setDato(Actividad dato) {
        this.dato = dato;
    }

    public NodoActividad getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoActividad siguiente) {
        this.siguiente = siguiente;
    }
    
    @Override
    public String toString() {
        return dato.toString();
    }
}
