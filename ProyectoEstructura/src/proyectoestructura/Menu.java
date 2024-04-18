package proyectoestructura;

import javax.swing.JOptionPane;

/**
 *
 * @author yules
 */
public class Menu {

    public void menuPrincipal() {
        PilaFactura f=new PilaFactura();
        Matriz g = new Matriz(5);
        String[] opciones = {"Clientes", "Habitaciones", "Itinerario", "Facturación", "Mostrar factura", "Como llegar", "Salir"};
        int op = -1;
        while (op != opciones.length - 1) {
            op = JOptionPane.showOptionDialog(null, "Administración de Hotel", "Seleccionar", 0, JOptionPane.QUESTION_MESSAGE, null, opciones, "Menu");
            switch (op) {

                case 0:
                    menuClientes();
                case 1:
                    menuHabitaciones();
                case 2:
                    menuItinerario();
                case 3:
                    f.apilar();
                case 4:
                    f.mostrar();
                case 5:
                    MostrarCamino();
                case 6:
                    System.exit(0);

            }
        }
    }
    
    public void menuClientes() {
        ColaClientes cola = new ColaClientes();
        String[] opciones = {"Ingresar Cliente", "Atender Cliente", "Vaciar lista de clientes", "Ubicar cliente","Cantidad de clientes", "Volver"};
        int opcion = -1;
        while (opcion != opciones.length - 1) {
            opcion = JOptionPane.showOptionDialog(null, "Administrar Clientes", "Seleccionar", 0, JOptionPane.QUESTION_MESSAGE, null, opciones, "Menu");;
            switch (opcion) {
                case 0:
                    cola.agregarCliente();
                    break;
                case 1:
                    cola.siguiente();
                    break;
                case 2:
                    cola.vaciarCola();
                    break;
                case 3:
                    cola.posicionCliente();
                    break;
                case 4:
                    cola.getTamaño();
                    break;
                case 5:
                    menuPrincipal();
                    break;

            }
        }
    }
    

    public void menuHabitaciones() {
        LDCHabitacion l = new LDCHabitacion();
        String[] opciones = {"Agregar Nueva Habitacion", "Ver Habitaciones disponibles", "Reservar habitación", "Eliminar habitación", "Volver"};
        int opcion = -1;
        while (opcion != opciones.length - 1) {
            opcion = JOptionPane.showOptionDialog(null, "Administrar Habitaciones", "Seleccionar", 0, JOptionPane.QUESTION_MESSAGE, null, opciones, "Menu");;
            switch (opcion) {
                case 0:
                    int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la habitación"));
                    String[] tipoHab = {"Estandar", "Deluxe"};
                    int tipohabi = JOptionPane.showOptionDialog(null, "Tipo de Habitacion", "Seleccionar", 0, JOptionPane.QUESTION_MESSAGE, null, tipoHab, "Menu");
                    int cantidadCamas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de camas"));
                    String[] opcionesDisponibilidad = {"NO", "SI"};
                    int disponibilidadIndex = JOptionPane.showOptionDialog(null, "Disponibilidad de Habitaciones", "Seleccionar", 0, JOptionPane.QUESTION_MESSAGE, null, opcionesDisponibilidad, "Menu");
                    String disponibilidad = opcionesDisponibilidad[disponibilidadIndex];
                    String tipo = "";

                    if (tipohabi == 0) {
                        tipo = "Estandar";
                    } else if (tipohabi == 1) {
                        tipo = "Deluxe";
                    }

                    double precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el  precio de la  habitación"));

                    Habitacion h = new Habitacion(id, tipo, cantidadCamas, disponibilidad, precio);

                    l.insertarHabitacion(h);
                    break;
                case 1:
                    System.out.println(l.mostrarDisponible());
                    break;
                case 2:
                    String[] tipoHabitacion = {"Estandar", "Deluxe"};
                    tipohabi = JOptionPane.showOptionDialog(null, "Tipo de Habitación", "Seleccionar", 0, JOptionPane.QUESTION_MESSAGE, null, tipoHabitacion, "Menu");
                    String tipoH = "";

                    if (tipohabi == 0) {
                        tipoH = "Estandar";
                    } else if (tipohabi == 1) {
                        tipoH = "Deluxe";
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
                    menuPrincipal();
            }
        }
    }
    
    public void menuItinerario() {

        LESItinerario i = new LESItinerario();
        String[] opciones = {"Ingresar Nueva Actividad", "Ver Todas las Actividades", "Eliminar Actividad", "Mostrar Actividades por Horario", "Volver"};
        int opcion = -1;
        while (opcion != opciones.length - 1) {
            opcion = JOptionPane.showOptionDialog(null, "Administrar itinerario del hotel", "Seleccionar", 0, JOptionPane.QUESTION_MESSAGE, null, opciones, "Menu");
            switch (opcion) {
                case 0:
                    int idA = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la actividad"));
                    String nombre = JOptionPane.showInputDialog("Ingrese el nombre de la actividad");
                    String[] horario = {"Diurno", "Nocturno"};
                    int horarios = JOptionPane.showOptionDialog(null, "Horario de la Actividad", "Seleccionar", 0, JOptionPane.QUESTION_MESSAGE, null, horario, "Menu");
                    int precio = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el precio de la actividad"));
                    i.insertar(new Actividad(idA, nombre, horario[horarios], precio));
                    break;
                case 1:
                    i.mostrar();
                    break;
                case 2:
                    int idE = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la actividad que desea eliminar"));
                    i.eliminarActividad(idE);
                    break;
                case 3:
                    String[] horarioP = {"Diurno", "Nocturno"};
                    horarios = JOptionPane.showOptionDialog(null, "Menu Itinerario", "Seleccionar", 0, JOptionPane.QUESTION_MESSAGE, null, horarioP, "Menu");
                    System.out.println(i.imprimirHorarios(horarioP[horarios]));
                    break;
                case 4:
                    menuPrincipal();
            }
        }
    }
    
    
    
    public void MostrarCamino(){
        Matriz g = new Matriz(5); 
        g.agregarUbi(0, "Casa");
        g.agregarUbi(1, "Terminal de autobuses");
        g.agregarUbi(2, "Guanacaste");
        g.agregarUbi(3, "Tamarindo");
        g.agregarUbi(4, "Hotel");
        
        g.agregarCone(0, 1);
        g.agregarCone(1, 2);
        g.agregarCone(2, 3);
        g.agregarCone(3, 4);
        
        int[] ruta = {0, 1, 2, 3};
        g.ruta(ruta);
    }

}
