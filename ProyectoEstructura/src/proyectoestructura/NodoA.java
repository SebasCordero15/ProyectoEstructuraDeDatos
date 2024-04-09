package proyectoestructura;

/**
 *
 * @author valer
 */
public class NodoA {
    private Actividad dato;
    private NodoA siguiente;
    
    public NodoA(){
        this.siguiente = null;
    }

    public Actividad getDato() {
        return dato;
    }

    public void setDato(Actividad dato) {
        this.dato = dato;
    }

    public NodoA getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoA siguiente) {
        this.siguiente = siguiente;
    }
    
    @Override
    public String toString() {
        return dato.toString();
    }
}
