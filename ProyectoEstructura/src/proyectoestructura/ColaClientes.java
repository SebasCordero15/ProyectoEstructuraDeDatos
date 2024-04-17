package proyectoestructura;

import javax.swing.JOptionPane;

/**
 *
 * @author yules
 */
//cola
public class ColaClientes {

    private NodoCliente inicio;
    private NodoCliente fin;

    public ColaClientes() {
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

    public void agregarCliente() {
        Cliente c = new Cliente();
        c.setIdCliente(JOptionPane.showInputDialog("Ingrese el ID del cliente:"));
        c.setNombre(JOptionPane.showInputDialog("Ingrese el nombre del cliente:"));
        c.setEdad(Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad del cliente:")));
        c.setCorreo(JOptionPane.showInputDialog("Ingrese el correo del cliente:"));
        c.setTelefono(Integer.parseInt(JOptionPane.showInputDialog("Ingrese el teléfono del cliente:")));
        c.setDireccion(JOptionPane.showInputDialog("Ingrese la dirección del cliente:"));

        NodoCliente nuevo = new NodoCliente();
        nuevo.setCliente(c);

        if (vacia()) {
            inicio = nuevo;
            fin = nuevo;
        } else {
            fin.setSiguiente(nuevo);
            fin = nuevo;
        }
    }

    public void siguiente() {
        if (vacia()) {
            System.out.println("La lista está vacia");
        } else {
            JOptionPane.showMessageDialog(null, "El proximo cliente de la cola es:"
                    + "\nNombre: " + inicio.getCliente().getNombre()
                    + "\nEdad: " + inicio.getCliente().getEdad()
                    + "\nCedula: " + inicio.getCliente().getIdCliente()
                    + "\nCorreo: " + inicio.getCliente().getCorreo()
                    + "\nTelefono : " + inicio.getCliente().getTelefono()
                    + "\nDireccion " + inicio.getCliente().getDireccion());
            inicio = inicio.getSiguiente();
        }

    }

    public boolean eliminarCliente(String idCliente) {
        boolean encontrado = false;
        NodoCliente aux = inicio;
        NodoCliente anterior = null;

        while (aux != null) {
            Cliente c = aux.getCliente();
            if (c.getIdCliente() == idCliente) {
                encontrado = true;
                if (anterior != null) {
                    anterior.setSiguiente(aux.getSiguiente());
                } else {
                    inicio = aux.getSiguiente();
                }
                JOptionPane.showMessageDialog(null, "El cliente " + aux.getCliente().getNombre() + " fue eliminado");
                break;
            }
            anterior = aux;
            aux = aux.getSiguiente();
        }

        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "El numero no existe en la cola");
        }

        return encontrado;
    }

    public void posicionCliente() {
        int posicion = 0;
        int cedula = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cedula del cliente sin guiones."));
        NodoCliente aux = inicio;

        if (aux == null) {
            JOptionPane.showMessageDialog(null, "La cola está vacía.");
        } else {
            while (aux != null) {
                if (aux.getCliente().getIdCliente().equals(cedula)) {
                    posicion += 1;
                    JOptionPane.showMessageDialog(null, "La persona buscada está en la posición número " + posicion + ".");
                    break;
                } else {
                    posicion += 1;
                    aux = aux.getSiguiente();
                }
            }

            if (aux == null) {
                JOptionPane.showMessageDialog(null, "La persona buscada no está en la cola.");
            }
        }
    }

    public void getTamaño() {
        int tam = 0;
        NodoCliente temp = inicio;

        if (temp == null) {
            JOptionPane.showMessageDialog(null, "La cola está vacía.");
        } else {
            while (temp != null) {
                tam += 1;
                temp = temp.getSiguiente();
            }
            JOptionPane.showMessageDialog(null, "El tamaño de la cola es de " + tam + " clientes.");
        }
    }

    public void mostrarClientes() {
        if (!vacia()) {
            String s = "";
            NodoCliente aux = inicio;
            while (aux != null) {
                s += aux.getCliente().toString()
                        + "---------------------------------------\n";
                aux = aux.getSiguiente();
            }
            System.out.println("La cola contiene\n" + s);
        } else {
            System.out.println("La cola se encuentra vacia");
        }
    }

    public void vaciarCola() {
        if (inicio != null) {
            while (inicio != null) {
                inicio = inicio.getSiguiente();
            }

            if (inicio == null) {
                JOptionPane.showMessageDialog(null, "La cola se vacío correctamente.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "La cola ya está vacía.");
        }
    }
}
