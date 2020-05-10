package modelo;

public class Sucursal {
    private String id;
    private String direccion;
    private String ciudad;
    private String nombre;
    private Cajero[] cajero;
    private Operacion[] operacion;

    public Sucursal(String id, String direccion, String ciudad, String nombre, Cajero[] cajero, Operacion[] operacion) {
        this.id = id;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.nombre = nombre;
        this.cajero = cajero;
        this.operacion = operacion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Cajero[] getCajero() {
        return cajero;
    }

    public void setCajero(Cajero[] cajero) {
        this.cajero = cajero;
    }

    public Operacion[] getOperacion() {
        return operacion;
    }

    public void setOperacion(Operacion[] operacion) {
        this.operacion = operacion;
    }
}
