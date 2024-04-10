/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejemplo_proyecto;

/**
 *
 * @author valer
 */
public class NodoLSC {
    
    private Desayunos dato;
    private NodoLSC siguiente;

    public NodoLSC(Desayunos dato) {
        this.dato = dato;
    }

    
    @Override
    public String toString() {
        return " \n " + " Desayuno: " + dato.getIdDesayuno()+ " Descripcion: " + dato.getDescripcion()+" Tipo Desayuno: "+ dato.getTipo() +" Calorias: "+ dato.getCalorias()+'}';
    }

    public Desayunos getDato() {
        return dato;
    }

    public void setDato(Desayunos dato) {
        this.dato = dato;
    }

    public NodoLSC getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoLSC siguiente) {
        this.siguiente = siguiente;
    }

 

 
}
