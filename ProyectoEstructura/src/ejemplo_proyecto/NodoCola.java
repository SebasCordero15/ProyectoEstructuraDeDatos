
package ejemplo_proyecto;

public class NodoCola {
    private Clientes elemento;
    private NodoCola atras;

    public Clientes getElemento() {
        return elemento;
    }

    public void setElemento(Clientes elemento) {
        this.elemento = elemento;
    }

    public NodoCola getAtras() {
        return atras;
    }

    public void setAtras(NodoCola atras) {
        this.atras = atras;
    }
    
    
}
