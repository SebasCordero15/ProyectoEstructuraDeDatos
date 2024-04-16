/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoestructura;

/**
 *
 * @author sebas
 */
public class NodoFactura {
    private Factura dato;
    private NodoFactura siguiente;
    
    public NodoFactura(){
        this.siguiente = null;
    }

    public Factura getDato() {
        return dato;
    }

    public void setDato(Factura dato) {
        this.dato = dato;
    }

    public NodoFactura getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoFactura siguiente) {
        this.siguiente = siguiente;
    }
    
    
}
