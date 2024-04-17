/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoestructura;

import javax.swing.JOptionPane;

/**
 *
 * @author valer
 */
public class ArbolVip {

    private NodoVip raiz;

    public ArbolVip() {
        raiz = null;
    }

    public boolean vacio() {
        if (raiz == null) {
            return true;
        } else {
            return false;
        }
    }

    private void crearNodo(NodoVip raiz, NodoVip nuevo) {
        if (nuevo.getCliente().isVip() == true) {
            if ((nuevo.getCliente().getEdad() >= raiz.getCliente().getEdad())) {
                if (raiz.getIzq() == null) {
                    raiz.setIzq(nuevo);
                } else {
                    crearNodo(raiz.getDer(), nuevo);
                }
            } else {
                if (raiz.getDer() == null) {
                    raiz.setDer(nuevo);
                } else {
                    crearNodo(raiz.getDer(), nuevo);
                }
            }
        }else{
            System.out.println("Este cliente no es VIP");
        }

    }

    public void crearRaiz() {
        Cliente c = new Cliente();
        c.setIdCliente(JOptionPane.showInputDialog("Ingrese el ID del cliente:"));
        c.setNombre(JOptionPane.showInputDialog("Ingrese el nombre del cliente:"));
        c.setEdad(Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad del cliente:")));
        String[] opciones = {"Sí", "No"};
        int opcion = JOptionPane.showOptionDialog(null, "¿Es cliente VIP?", "VIP", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
        boolean esVIP = opcion == JOptionPane.YES_OPTION;
        c.setVip(esVIP);

        NodoVip nuevo = new NodoVip();
        nuevo.setCliente(c);
        if (vacio()) {
            raiz = nuevo;
        } else {
            crearNodo(raiz, nuevo);
        }
    }

    private void preorden(NodoVip n) {
        if (n != null) {
            System.out.print(n.getCliente().getIdCliente() + " "); // visita de la raiz
            preorden(n.getIzq());
            preorden(n.getDer());
        }
    }

    public void preOrden() {
        System.out.println("\nRecorriendo clientes pre orden\n");
        this.preorden(this.raiz);
        System.out.println("");
    }

    private void inorden(NodoVip n) {
        if (n != null) {

            inorden(n.getIzq());
            System.out.print(n.getCliente().getIdCliente() + " "); // visita de la raiz
            inorden(n.getDer());
        }
    }

    public void inOrden() {
        System.out.println("\nRecorriendo clientes en orden\n");
        this.inorden(this.raiz);
        System.out.println("");
    }

    private void postorden(NodoVip n) {
        if (n != null) {

            postorden(n.getIzq());
            postorden(n.getDer());
            System.out.print(n.getCliente().getIdCliente() + " "); // visita de la raiz
        }
    }

    public void postOrden() {
        System.out.println("\nRecorriendo clientes post orden\n");
        this.postorden(this.raiz);
        System.out.println("\n");
    }
}
