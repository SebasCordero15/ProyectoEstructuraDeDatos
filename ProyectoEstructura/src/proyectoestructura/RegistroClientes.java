package proyectoestructura;

import javax.swing.JOptionPane;

/**
 *
 * @author yules
 */
public class RegistroClientes {

    public static void main(String[] args) {
        ColaClientes colaClientes = new ColaClientes();

        while (true) {
            String[] opciones = {"1. Agregar cliente", "2. Modificar cliente", "3. Eliminar cliente", "4. Ver clientes", "5. Salir"};
            String opcionSeleccionada = (String) JOptionPane.showInputDialog(null, "Seleccione una opción:\n"
                    + String.join("\n", opciones), "Gestión de clientes",
                    JOptionPane.PLAIN_MESSAGE);

            if (opcionSeleccionada == null || opcionSeleccionada.charAt(0) == '5') {
                JOptionPane.showMessageDialog(null, "¡Hasta luego!");
                System.exit(0);
            } else {
                char opcion = opcionSeleccionada.charAt(0);
                switch (opcion) {
                    case '1':
                        agregarCliente(colaClientes);
                        break;
                    case '2':
                        modificarCliente(colaClientes);
                        break;
                    case '3':
                        eliminarCliente(colaClientes);
                        break;
                    case '4':
                        verClientes(colaClientes);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opción inválida, por favor ingrese un número válido del menú.");
                }
            }
        }
    }

    public static void agregarCliente(ColaClientes colaClientes) {
        String idCliente = JOptionPane.showInputDialog("Ingrese el ID del cliente:");
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del cliente:");
        String apellido = JOptionPane.showInputDialog("Ingrese el apellido del cliente:");
        String correo = JOptionPane.showInputDialog("Ingrese el correo del cliente:");
        int telefono = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el teléfono del cliente:"));
        String direccion = JOptionPane.showInputDialog("Ingrese la dirección del cliente:");

        Cliente cliente = new Cliente(idCliente, nombre, apellido, correo, telefono, direccion);
        colaClientes.agregarCliente(cliente);

        JOptionPane.showMessageDialog(null, "Cliente agregado correctamente.");
    }

    public static void modificarCliente(ColaClientes colaClientes) {
        String idCliente = JOptionPane.showInputDialog("Ingrese el ID del cliente que desea modificar:");
        Cliente cliente = colaClientes.buscarCliente(idCliente);

        if (cliente != null) {
            String nombre = JOptionPane.showInputDialog("Nuevo nombre del cliente:");
            String apellido = JOptionPane.showInputDialog("Nuevo apellido del cliente:");
            String correo = JOptionPane.showInputDialog("Nuevo correo del cliente:");
            int telefono = Integer.parseInt(JOptionPane.showInputDialog("Nuevo teléfono del cliente:"));
            String direccion = JOptionPane.showInputDialog("Nueva dirección del cliente:");

            cliente.setNombre(nombre);
            cliente.setApellido(apellido);
            cliente.setCorreo(correo);
            cliente.setTelefono(telefono);
            cliente.setDireccion(direccion);

            JOptionPane.showMessageDialog(null, "Cliente modificado correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "Cliente no encontrado.");
        }
    }

    public static void eliminarCliente(ColaClientes colaClientes) {
        String idCliente = JOptionPane.showInputDialog("Ingrese el ID del cliente que desea eliminar:");
        boolean eliminado = colaClientes.eliminarCliente(idCliente);

        if (eliminado) {
            JOptionPane.showMessageDialog(null, "Cliente eliminado correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "Cliente no encontrado.");
        }
    }

    public static void verClientes(ColaClientes colaClientes) {
        StringBuilder clientesStr = new StringBuilder("Clientes registrados:\n");
        Cliente[] clientes = colaClientes.getClientes();
        for (int i = 0; i < colaClientes.getTamaño(); i++) {
            clientesStr.append(clientes[i]).append("\n");
        }
        JOptionPane.showMessageDialog(null, clientesStr.toString());

    }
}
