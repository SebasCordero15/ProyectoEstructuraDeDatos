/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoestructura;

import javax.swing.JOptionPane;

/**
 *
 * @author sebas
 */
public class PilaFactura {
    private NodoFactura cima;
    

    public PilaFactura() {
        this.cima = null;
    }

    //verifico si esta vacia
    public boolean vacia() {
        if (cima == null) {
            return true;
        } else {
            return false;
        }
    }

    public void apilar() {

        Factura f = new Factura();
        f.setCedula(JOptionPane.showInputDialog("Ingrese la cedula del cliente: "));
        f.setNombre(JOptionPane.showInputDialog("Ingrese el nombre del cliente: "));
        f.setTipoHabitacion(JOptionPane.showInputDialog("Ingrese el tipo de habitacion: "));
        f.setCantidadNoches(Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de noches: ")));

        NodoFactura nuevo = new NodoFactura();

        nuevo.setDato(f);

        if (vacia()) {
            //Si la pila esta vacia el dato nuevo es la nueva cima
            cima = nuevo;
        } else {
            //creamos un puntero al siguiente nodo
            nuevo.setSiguiente(cima);
            //colocamos el nodo en la cima
            cima = nuevo;
        }
    }

    public void mostrar() {
        if (!vacia()) {
            String s = "";
            NodoFactura aux = cima;
            while (aux != null) {
                s += "\n------FACTURAS-------\n" + "\nCedula:" + aux.getDato().getCedula() + "\nNombre: " + aux.getDato().getNombre() + "\nTipo Habitacion: "
                        + aux.getDato().getTipoHabitacion() + "\nCantidad de noches: " + aux.getDato().getCantidadNoches() + "\nSubtotal: "
                        + aux.getDato().getSubtotal() + "\nTotal: " + aux.getDato().getTotal() + "\n---------------------------------";
                aux = aux.getSiguiente();
            }
            JOptionPane.showMessageDialog(null, "Contenido de la Pila: \n" + s,
                    "Pila llena", JOptionPane.PLAIN_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No se puede mostrar, pila vacia",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public int calcularSubtotal(){
        Factura f=new Factura();
        int Noche = 20000;
        f.setSubtotal(f.getCantidadNoches() * Noche);
        return (int) f.getSubtotal();
    }
    public int MontoTotal(){
        Factura f=new Factura();
        f.setTotal(f.getSubtotal() * 0.13);
        return (int) f.getTotal();
    }
}
