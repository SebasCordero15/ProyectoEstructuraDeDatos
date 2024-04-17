package proyectoestructura;

/**
 *
 * @author valer
 */
public class NodoVip {
    private Cliente cliente;
    private NodoVip izq;
    private NodoVip der;

    public NodoVip() {
        this.izq = null;
        this.der = null;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public NodoVip getIzq() {
        return izq;
    }

    public void setIzq(NodoVip izq) {
        this.izq = izq;
    }

    public NodoVip getDer() {
        return der;
    }

    public void setDer(NodoVip der) {
        this.der = der;
    }

    
}
