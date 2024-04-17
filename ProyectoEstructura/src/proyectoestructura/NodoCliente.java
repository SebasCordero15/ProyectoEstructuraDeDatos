package proyectoestructura;

/**
 *
 * @author yules
 */
public class NodoCliente {

    private Cliente cliente;
    private NodoCliente siguiente;

    public NodoCliente() {
        this.siguiente = null;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public NodoCliente getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoCliente siguiente) {
        this.siguiente = siguiente;
    }
}
