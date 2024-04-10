/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejemplo_proyecto;

/**
 *
 * @author valer
 */
public class Habitaciones {
    private int idHabitacion;
    private String tipo;
    private int cantidadCamas;
    private String disponibilidad;
    private double precio;
   


    public Habitaciones(int idHabitacion, String tipo, int cantidadCamas, String disponibilidad, double precio) {
        this.idHabitacion = idHabitacion;
        this.tipo = tipo;
        this.cantidadCamas = cantidadCamas;
        this.disponibilidad = disponibilidad;
        this.precio = precio;
    }

    public String getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public int getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCantidadCamas() {
        return cantidadCamas;
    }

    public void setCantidadCamas(int cantidadCamas) {
        this.cantidadCamas = cantidadCamas;
    }
    
    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Habitaciones{" + "idHabitacion=" + idHabitacion + ", tipo=" + tipo + ", cantidadCamas=" + cantidadCamas + ", disponibilidad=" + disponibilidad + ", precio=" + precio + '}';
    }
    
    
    
}
