package modelo;

public class Cliente {
    protected String id;
    protected String nombre;
    protected String telefono;
    protected String ocupacion;
    protected String direccion;
    protected boolean estaSuscrito;


    public Cliente() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public boolean isEstaSuscrito() {
        return estaSuscrito;
    }

    public void setEstaSuscrito(boolean estaSuscrito) {
        this.estaSuscrito = estaSuscrito;
    }


}
