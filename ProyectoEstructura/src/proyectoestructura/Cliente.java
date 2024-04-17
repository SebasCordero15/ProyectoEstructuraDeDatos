package proyectoestructura;

/**
 *
 * @author valer
 */
public class Cliente {

    private String idCliente;
    private String nombre;
    private int edad;
    private String correo;
    private int telefono;
    private String direccion;
    private boolean vip;

    public Cliente() {
        this.idCliente = "";
        this.nombre = "";
        this.edad = 0;
        this.correo = "";
        this.telefono = 0;
        this.direccion = "";
    }
    
    public Cliente(String idCliente, String nombre, int edad, String correo, int telefono, String direccion, boolean vip) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.edad = edad;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
        this.vip = false;
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
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
    
    public boolean isVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }
    

    @Override
    public String toString() {
        return "ID: " + idCliente + ", Nombre: " + nombre + ", Edad: " + edad
                + ", Correo: " + correo + ", Teléfono: " + telefono + ", Dirección: " + direccion;
    }

    

}
