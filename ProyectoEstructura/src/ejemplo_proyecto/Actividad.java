/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejemplo_proyecto;

/**
 *
 * @author valer
 */
public class Actividad {
    private int idActividad;
    private String descripcionActividad;
    private String horario;
    private int costo;

    public Actividad() {
    }

    public Actividad(int idActividad, String descripcionActividad, String horario, int costo) {
        this.idActividad = idActividad;
        this.descripcionActividad = descripcionActividad;
        this.horario = horario;
        this.costo = costo;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public int getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(int idActividad) {
        this.idActividad = idActividad;
    }

    public String getDescripcionActividad() {
        return descripcionActividad;
    }

    public void setDescripcionActividad(String descripcionActividad) {
        this.descripcionActividad = descripcionActividad;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    @Override
    public String toString() {
        return "Actividad{" + "idActividad=" + idActividad + ", descripcionActividad=" + descripcionActividad + ", Horario=" + horario + ", costo=" + costo + '}' + "\n";
    }
    
    
}
