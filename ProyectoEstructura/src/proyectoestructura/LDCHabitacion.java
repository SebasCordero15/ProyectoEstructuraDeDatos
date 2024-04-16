package proyectoestructura;

import javax.swing.JOptionPane;

/**
 *
 * @author valer
 */
// lista doble circular
public class LDCHabitacion {

    private NodoH inicio;
    private NodoH fin;

    public LDCHabitacion() {
        this.inicio = null;
        this.fin = null;
    }

    public boolean vacia() {
        if (inicio == null) {
            return true;
        } else {
            return false;
        }
    }

    public void insertarHabitacion(Habitacion h) {
        NodoH nuevo = new NodoH();
        nuevo.setElemento(h);

        if (vacia()) {
            inicio = nuevo;
            fin = nuevo;
            fin.setSiguiente(inicio);
            inicio.setAnterior(fin);
        } else if (h.getIdHabitacion() < inicio.getElemento().getIdHabitacion()) { // insertar al inicio
            nuevo.setSiguiente(inicio);
            inicio = nuevo;
            fin.setSiguiente(inicio);
            inicio.setAnterior(fin);
        } else if (h.getIdHabitacion() > fin.getElemento().getIdHabitacion()) { // insertar al final
            fin.setSiguiente(nuevo);
            fin = fin.getSiguiente(); // fin = nuevo
            fin.setSiguiente(inicio);
            inicio.setAnterior(fin);
        } else { // insertar al medio
            NodoH aux = inicio;
            while (aux.getSiguiente().getElemento().getIdHabitacion() < h.getIdHabitacion()) {
                aux = aux.getSiguiente();
            }
            nuevo.setSiguiente(aux.getSiguiente());
            nuevo.setAnterior(aux);
            aux.setSiguiente(nuevo);
            nuevo.getSiguiente().setAnterior(nuevo);
        }
    }

    public Habitacion eliminar(int idH) {
        if (vacia()) {
            System.out.println("No hay habitaciones por eliminar");
            return null;
        }else{
            mostrar();
        }
        NodoH actual = inicio;
        NodoH anterior = fin;

        do {
            if (actual.getElemento().getIdHabitacion() == idH) {// si encuentra la habitacion
                if (actual == inicio && actual == fin) { // si solo hay una habitaicon en la lista
                    inicio = null;
                    fin = null;
                } else if (actual == inicio) { // si el encontrado es el inicio
                    inicio = inicio.getSiguiente();
                    fin.setSiguiente(inicio);
                } else if (actual == fin) {// si el encontrado es el ultimo
                    fin = anterior;
                    fin.setSiguiente(inicio);

                } else {
                    anterior.setSiguiente(actual.getSiguiente());
                }
                return actual.getElemento();

            }
            anterior = actual;
            actual = actual.getSiguiente();
        } while (actual != inicio); // ciclo

        System.out.println("Ese ID de habitación no existe en la lista");
        return null;
    }

    public String mostrar() {
        NodoH aux = inicio;
        String s = "Habitaciones \n";
        if (!vacia()) {
            s += aux.getElemento().toString() + "\n";
            aux = aux.getSiguiente();
            while (aux != inicio) {
                s += aux.getElemento().toString() + "\n";
                aux = aux.getSiguiente();
            }
        } else {
            s += "No hay habitaciones";
        }
        return s;
    }

    public String mostrarDisponible() {
        NodoH aux = inicio;
        boolean disponibles = false;
        String s = "Habitaciones \n";

        if (!vacia()) {
            if (aux.getElemento().getDisponibilidad().equalsIgnoreCase("SI")) {
                s += aux.getElemento().toString();
                disponibles = true;
            }

            aux = aux.getSiguiente();
            while (aux != inicio) {
                if (aux.getElemento().getDisponibilidad().equalsIgnoreCase("SI")) {
                    s += aux.getElemento().toString();
                    disponibles = true;
                }
                aux = aux.getSiguiente();
            }
        }

        if (!disponibles) {
            return "No hay habitaciones disponibles en este momento";
        }

        return s;
    }

    public void reservar(int idH) {
        NodoH aux = inicio;

        if (!vacia()) {

            if (aux.getElemento().getIdHabitacion() == idH) {
                aux.getElemento().setDisponibilidad("NO");
            }

            aux = aux.getSiguiente();

            while (aux != inicio) {

                if (aux.getElemento().getIdHabitacion() == idH) {
                    aux.getElemento().setDisponibilidad("NO");
                    break;
                }

                aux = aux.getSiguiente();
            }
        }
    }

    public String mostrarReserva(String tipo) {
        String print = "";
        NodoH aux = inicio;

        if (!vacia()) {

            if (aux.getElemento().getDisponibilidad().equalsIgnoreCase("SI") && aux.getElemento().getTipo().equalsIgnoreCase(tipo)) {
                print += aux.getElemento().toString();
            }

            aux = aux.getSiguiente();
            while (aux != inicio) {

                if (aux.getElemento().getDisponibilidad().equalsIgnoreCase("SI") && aux.getElemento().getTipo().equalsIgnoreCase(tipo)) {
                    print += aux.getElemento().toString();
                }
                aux = aux.getSiguiente();
            }
        } else {
            print = "La lista de habitaciones está vacía";
        }

        return print;
    }

}
