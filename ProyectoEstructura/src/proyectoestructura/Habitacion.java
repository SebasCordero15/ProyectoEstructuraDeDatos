package proyectoestructura;

/**
 *
 * @author valer
 */
public class Habitacion {
    private int idHabitacion;
    private String tipo;
    private int cantidadCamas;
    private String disponibilidad;
    private double precio;
    
    public Habitacion(int idHabitacion, String tipo, int cantidadCamas, String disponibilidad, double precio) {
        this.idHabitacion = idHabitacion;
        this.tipo = tipo;
        this.cantidadCamas = cantidadCamas;
        this.disponibilidad = disponibilidad;
        this.precio = precio;
    }
    
    public Habitacion() {
        this.idHabitacion = 0;
        this.tipo = "";
        this.cantidadCamas = 0;
        this.disponibilidad = "";
        this.precio = 0.0d;
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

    public String getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    @Override
    public String toString() {
        return "\n[ID: "+ idHabitacion+", Tipo: "+ tipo+", Camas: "+ cantidadCamas+ ", Precio: "+ precio+']';
    }
    
    
}
