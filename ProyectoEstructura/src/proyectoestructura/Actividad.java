package proyectoestructura;

/**
 *
 * @author valer
 */
public class Actividad {

    private int idActividad;
    private String descripcion;
    private String horario;
    private double costo;

    public Actividad() {
        this.idActividad = 0;
        this.descripcion = "";
        this.horario = "";
        this.costo = 0.0d;
    }

    public Actividad(int idActividad, String descripcion, String horario, int costo) {
        this.idActividad = idActividad;
        this.descripcion = descripcion;
        this.horario = horario;
        this.costo = costo;
    }

    public int getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(int idActividad) {
        this.idActividad = idActividad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    @Override
    public String toString() {
        return "- " + "ID: " + idActividad + ", Descripción: " + descripcion + ", Horario:" + horario + ", Costo:" + costo + "\n";
    }

}
