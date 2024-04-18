package proyectoestructura;

import javax.swing.JOptionPane;

/**
 *
 * @author valer
 */
// lista enlazada simple
public class LESItinerario {

    private NodoActividad inicio;

    public LESItinerario() {
        this.inicio = null;
    }

    public boolean vacia() {
        if (inicio == null) {
            return true;
        } else {
            return false;
        }
    }

    public void insertar(Actividad a) {
        NodoActividad nuevo = new NodoActividad();
        nuevo.setDato(a);
        if (vacia()) {
            inicio = nuevo;
        } else if (a.getIdActividad() < inicio.getDato().getIdActividad()) {
            nuevo.setSiguiente(inicio);
            inicio = nuevo;
        } else if (inicio.getSiguiente() == null) {
            inicio.setSiguiente(nuevo);
        } else {
            NodoActividad aux = inicio;
            while ((aux.getSiguiente() != null) && aux.getSiguiente().getDato().getIdActividad() < a.getIdActividad()) {
                aux = aux.getSiguiente();
            }
            nuevo.setSiguiente(aux.getSiguiente());
            aux.setSiguiente(nuevo);
        }
    }

    public void mostrar() {
        if (!vacia()) {
            String s = "";
            NodoActividad aux = inicio;
            while (aux != null) {
                s += aux.toString();
                aux = aux.getSiguiente();
            }
            System.out.println("Actividades en el itinerario: \n" + s);
        } else {
            JOptionPane.showMessageDialog(null, "Error al mostrar", "Lista Vacia", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void eliminarActividad(int id) {
        if (!vacia()) {
            if (inicio.getDato().getIdActividad() == id) {
                inicio = inicio.getSiguiente();
                JOptionPane.showMessageDialog(null, "Actividad eliminada");
            } else {
                NodoActividad anterior;
                NodoActividad aux;
                anterior = inicio;
                aux = inicio.getSiguiente();

                while ((aux != inicio) && (aux.getSiguiente() != null) && (aux.getSiguiente().getDato().getIdActividad() != id)) {
                    anterior = anterior.getSiguiente();
                    aux = aux.getSiguiente();
                    System.out.println("Actividad eliminada");
                }
                if (aux == inicio) {
                    System.out.println("El ID  buscado no existe, no se puede eliminar la actividad");
                }
                if (aux != null) {
                    anterior.setSiguiente(aux.getSiguiente());
                }
            }
        } else {
            System.out.println("La  lista de actividades se encuentra vacía");
        }
    }

    public String imprimirHorarios(String horario) {
        String s = "";
        String diurnas = "";
        String nocturnas = "";

        if (inicio != null) {
            NodoActividad aux = inicio;

            if (horario.equalsIgnoreCase("Diurno")) {
                if (aux.getDato().getHorario().equalsIgnoreCase("Diurno")) {
                    diurnas += aux.getDato().toString();
                }

                aux = aux.getSiguiente();
                while (aux != null && aux != inicio) {
                    if (aux.getDato().getHorario().equalsIgnoreCase("Diurno")) {
                        diurnas += aux.getDato().toString();
                    }
                    aux = aux.getSiguiente();
                }
            }

            if (horario.equalsIgnoreCase("Nocturno")) {
                if (aux.getDato().getHorario().equalsIgnoreCase("Nocturno")) {
                    nocturnas += aux.getDato().toString();
                }

                aux = aux.getSiguiente();
                while (aux != null && aux != inicio) {
                    if (aux.getDato().getHorario().equalsIgnoreCase("Nocturno")) {
                        nocturnas += aux.getDato().toString();
                    }
                    aux = aux.getSiguiente();
                }
            }
            s = nocturnas + diurnas;
        } else {
            s = "La lista de actividades está vacía";
        }

        return s;
    }
}
