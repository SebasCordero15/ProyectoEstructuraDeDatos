/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoestructura;

/**
 *
 * @author yules
 */
public class Nodo {

    private Cliente cliente;
    private Nodo siguiente;

    // Constructor
    public Nodo(Cliente cliente) {
        this.cliente = cliente;
        this.siguiente = null;
    }

    // Getters y setters
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
}
