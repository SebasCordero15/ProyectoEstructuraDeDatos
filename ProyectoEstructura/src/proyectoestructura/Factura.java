package proyectoestructura;

/**
 *
 * @author valer
 */
public class Factura {
    
    
    // agregar id cliente
    private String nombre;
    private String cedula;
    private String tipoHabitacion;
    private int cantidadNoches;
    private double subtotal;
    private double total;
    
    public Factura(){
        this.nombre = "";
        this.cedula = "";
        this.tipoHabitacion = "";
        this.cantidadNoches = 0;
        this.subtotal = 0;
        this.total = 0;
    }

    public Factura(String nombre, String cedula, String tipoHabitacion, int cantidadNoches, double subtotal, double total) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.tipoHabitacion = tipoHabitacion;
        this.cantidadNoches = cantidadNoches;
        this.subtotal = subtotal;
        this.total = total;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(String tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    public int getCantidadNoches() {
        return cantidadNoches;
    }

    public void setCantidadNoches(int cantidadNoches) {
        this.cantidadNoches = cantidadNoches;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    
}
