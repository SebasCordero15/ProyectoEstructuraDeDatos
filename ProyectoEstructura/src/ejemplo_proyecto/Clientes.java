/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejemplo_proyecto;

import javax.swing.JOptionPane;

/**
 *
 * @author valer
 */
public class Clientes {
    private int Cedula;
    private String Nombre;
    private int Edad;
    private String Membresia;
    private String fechaReserva;

    public Clientes() {
    }

    public Clientes(int Cedula, String Nombre, int Edad, String Membresia, String fechaReserva) {
        this.Cedula = Cedula;
        this.Nombre = Nombre;
        this.Edad = Edad;
        this.Membresia = Membresia;
        this.fechaReserva = fechaReserva;
    }

    public int getCedula() {
        return Cedula;
    }

    public void setCedula(int Cedula) {
        this.Cedula = Cedula;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }

    public String getMembresia() {
        return Membresia;
    }

    public void setMembresia(String Membresia) {
        this.Membresia = Membresia;
    }

    public String getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(String fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    @Override
    public String toString() {
        return "Clientes{" + "Cedula=" + Cedula + ", Nombre=" + Nombre + ", Edad=" + Edad + ", Membresia=" + Membresia + ", fechaReserva=" + fechaReserva + '}';
    }
    
        public void Menu() {
        int opcion = -1;
        String[] opciones = {"Encolar", "Consultar por Cliente"};
        while (opcion != opciones.length - 1) {
            opcion = JOptionPane.showOptionDialog(null, "Hotel", "Seleccionar", 0, JOptionPane.QUESTION_MESSAGE, null, opciones, "Estacionamiento");
            switch (opcion) {
                case 0:

                    break;

            }
        }
    }
    
}
