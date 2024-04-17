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
        String[] tipoHabitacion = {"Estandar", "Deluxe"};
        int tipo = JOptionPane.showOptionDialog(null, "Tipo de Habitación", "Seleccionar", 0, JOptionPane.QUESTION_MESSAGE, null, tipoHabitacion, "Menu");
        String tipoH ="";
        switch (tipo) {
            case 0:
                tipoH = "Estandar";
                break;
            case 1:
                tipoH = "Deluxe";
                break;
        }
        f.setTipoHabitacion(tipoH);
        f.setCantidadNoches(Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de noches: ")));

        NodoFactura nuevo = new NodoFactura();
        nuevo.setDato(f);

        if (vacia()) {
            cima = nuevo;
        } else {
            nuevo.setSiguiente(cima);
            cima = nuevo;
        }
    }

    public void mostrar() {
        if (!vacia()) {
            String s = "";
            NodoFactura aux = cima;
            int subtotal = calcularSubtotal();
            while (aux != null) {
                s += "\n------FACTURAS-------\n" + "\nCedula:" + aux.getDato().getCedula() + "\nNombre: " + aux.getDato().getNombre() + "\nTipo Habitacion: "
                        + aux.getDato().getTipoHabitacion() + "\nCantidad de noches: " + aux.getDato().getCantidadNoches() + "\nSubtotal: "
                        + subtotal + "\nTotal: " + MontoTotal() + "\n---------------------------------";
                aux = aux.getSiguiente();
            }
            JOptionPane.showMessageDialog(null, "Contenido de la Pila: \n" + s,
                    "Pila llena", JOptionPane.PLAIN_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No se puede mostrar, pila vacia",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public int calcularSubtotal() {
        int total = 0;
        if (!vacia() && cima.getDato() != null) {
            Factura factura = cima.getDato();
            int precioPorNoche = 0;
            if (factura.getTipoHabitacion().equals("Estandar")) {
                precioPorNoche = 20000;
            } else if (factura.getTipoHabitacion().equals("Deluxe")) {
                precioPorNoche = 40000;
            }
            total = precioPorNoche * factura.getCantidadNoches();
            
        }
        return total;
    }

    public int MontoTotal() {
        if (!vacia() && cima.getDato() != null) {
            Factura factura = cima.getDato();
            double subtotal = calcularSubtotal();
            double iva = subtotal * 0.13;
            double total = subtotal + iva;
            return (int) total;
        } else {
            return 0; // Si no hay factura o el subtotal es 0, el IVA será 0
        }
    }
}
