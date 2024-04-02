/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoestructura;

import javax.swing.JOptionPane;

/**
 *
 * @author yules
 */
public class ColaClientes {

    private Cliente[] clientes;
    private int tamaño;
    private static final int CAPACIDAD_INICIAL = 10;

    public ColaClientes() {
        clientes = new Cliente[CAPACIDAD_INICIAL];
        tamaño = 0;
    }

    public void agregarCliente(Cliente cliente) {
        if (tamaño == clientes.length) {
            Cliente[] nuevoArray = new Cliente[clientes.length * 2];
            for (int i = 0; i < tamaño; i++) {
                nuevoArray[i] = clientes[i];
            }
            clientes = nuevoArray;
        }
        clientes[tamaño] = cliente;
        tamaño++;
    }

    public Cliente buscarCliente(String idCliente) {
        for (int i = 0; i < tamaño; i++) {
            if (clientes[i].getIdCliente().equals(idCliente)) {
                return clientes[i];
            }
        }
        return null;
    }

    public boolean eliminarCliente(String idCliente) {
        for (int i = 0; i < tamaño; i++) {
            if (clientes[i].getIdCliente().equals(idCliente)) {
                clientes[i] = clientes[tamaño - 1];
                clientes[tamaño - 1] = null;
                tamaño--;
                return true;
            }
        }
        return false;
    }

    public int getTamaño() {
        return tamaño;
    }

    public Cliente[] getClientes() {
        return clientes;
    }

    public void verClientes() {
        String mensaje = "Clientes registrados:\n";
        for (int i = 0; i < tamaño; i++) {
            mensaje += clientes[i].toString() + "\n";
        }
        JOptionPane.showMessageDialog(null, mensaje);
    }
}