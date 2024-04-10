/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejemplo_proyecto;

/**
 *
 * @author valer
 */
public class NodoActividad {
    private Actividad dato;
    NodoActividad anterior;
    NodoActividad siguiente;

    public NodoActividad() {
    }

    public NodoActividad(Actividad dato) {
        this.dato = dato;
    }

    public Actividad getDato() {
        return dato;
    }

    public void setDato(Actividad dato) {
        this.dato = dato;
    }

    public NodoActividad getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoActividad anterior) {
        this.anterior = anterior;
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
