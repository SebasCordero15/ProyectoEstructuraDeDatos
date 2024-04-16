package proyectoestructura;

/**
 *
 * @author valer
 */
public class Cliente {

    private String idCliente;
    private String nombre;
    private String apellido;
    private String correo;
    private int telefono;
    private String direccion;

    public Cliente() {
        this.idCliente = "";
        this.nombre = "";
        this.apellido = "";
        this.correo = "";
        this.telefono = 0;
        this.direccion = "";
    }
    
    public Cliente(String idCliente, String nombre, String apellido, String correo, int telefono, String direccion) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "ID: " + idCliente + ", Nombre: " + nombre + ", Apellido: " + apellido
                + ", Correo: " + correo + ", Teléfono: " + telefono + ", Dirección: " + direccion;
    }

}
