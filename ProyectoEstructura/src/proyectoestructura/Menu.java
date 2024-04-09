package proyectoestructura;

import javax.swing.JOptionPane;

/**
 *
 * @author valer
 */
public class Menu {

    public void menuPrincipal() {
        String[] opciones = {"Clientes", "Habitaciones", "Itinerario", "Clientes VIP", "Facturación", "Salir"};
        int op = -1;
        while (op != opciones.length - 1) {
            op = JOptionPane.showOptionDialog(null, "Bienvenido al Hotel", "Seleccionar", 0, JOptionPane.QUESTION_MESSAGE, null, opciones, "Menu");
            switch (op) {

                case 0:
                    break;
                case 1:
                    menuHabitaciones();
                    break;
                case 2:
                    break;
                case 3:

                    break;
                case 4:
                    break;
                case 5:
                    System.exit(0);
                    break;

            }
        }
    }

    public static void menuHabitaciones() {
        LDCHabitacion l = new LDCHabitacion();
        String[] opciones = {"Agregar Nueva Habitacion", "Ver Habitaciones disponibles", "Reservar habitación", "Eliminar habitación", "Salir"};
        int opcion = -1;
        while (opcion != opciones.length - 1) {
            opcion = JOptionPane.showOptionDialog(null, "Menu Habitaciones", "Seleccionar", 0, JOptionPane.QUESTION_MESSAGE, null, opciones, "Menu");;
            switch (opcion) {
                case 0:
                    int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la habitación"));
                    String[] tipoHab = {"Estandar", "Premium"};
                    int tipohabi = JOptionPane.showOptionDialog(null, "Tipo de Habitacion", "Seleccionar", 0, JOptionPane.QUESTION_MESSAGE, null, tipoHab, "Menu");
                    int cantidadCamas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de camas"));
                    String[] opcionesDisponibilidad = {"NO", "SI"};
                    int disponibilidadIndex = JOptionPane.showOptionDialog(null, "Disponibilidad de Habitaciones", "Seleccionar", 0, JOptionPane.QUESTION_MESSAGE, null, opcionesDisponibilidad, "Menu");
                    String disponibilidad = opcionesDisponibilidad[disponibilidadIndex];
                    String tipo = "";

                    if (tipohabi == 0) {
                        tipo = "Estandar";
                    } else if (tipohabi == 1) {
                        tipo = "Premium";
                    }

                    double precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el  precio de la  habitación"));

                    Habitacion h = new Habitacion(id, tipo, cantidadCamas, disponibilidad, precio);

                    l.insertarHabitacion(h);
                    break;
                case 1:

                    System.out.println(l.mostrarDisponible());
                    break;
                case 2:
                    String[] tipoHabitacion = {"Estandar", "Premium"};
                    tipohabi = JOptionPane.showOptionDialog(null, "Tipo de Habitacion", "Seleccionar", 0, JOptionPane.QUESTION_MESSAGE, null, tipoHabitacion, "Menu");
                    String tipoH = "";

                    if (tipohabi == 0) {
                        tipoH = "Estandar";
                    } else if (tipohabi == 1) {
                        tipoH = "Premium";
                    }

                    System.out.println(l.mostrarReserva(tipoH));

                    int idReservar = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la habitación que desea reservar."));
                    l.reservar(idReservar);
                    break;
                case 3:
                    int idH = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la habitación que desea eliminar"));
                    l.eliminar(idH);
                    break;
                case 4:
                    System.exit(0);
            }
        }
    }

}
