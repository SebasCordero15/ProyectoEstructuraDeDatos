/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejemplo_proyecto;

/**
 *
 * @author valer
 */
public class NodoLDC {
    private Habitaciones dato;
    NodoLDC anterior;
    NodoLDC siguiente;

    public NodoLDC(Habitaciones dato) {
        this.dato = dato;
    }

    public Habitaciones getDato() {
        return dato;
    }

    public void setDato(Habitaciones dato) {
        this.dato = dato;
    }

    public NodoLDC getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoLDC anterior) {
        this.anterior = anterior;
    }

    public NodoLDC getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoLDC siguiente) {
        this.siguiente = siguiente;
    }

 
   @Override
    public String toString() {
        return " \n " + " Habitacion Id: " + dato.getIdHabitacion()+ " Tipo Habitacion: " + dato.getTipo()+" Cantidad de Camas: "+ dato.getCantidadCamas()+" Calorias: "+'}';
    }
 
    
}
