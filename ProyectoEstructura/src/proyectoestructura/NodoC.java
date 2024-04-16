package proyectoestructura;

/**
 *
 * @author yules
 */
public class NodoC {

    private Cliente cliente;
    private NodoC siguiente;

    public NodoC() {
        this.siguiente = null;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public NodoC getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoC siguiente) {
        this.siguiente = siguiente;
    }
}
