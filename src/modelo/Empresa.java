package modelo;

public class Empresa extends Cliente{
    private String nit;
    private String nombre;
    private String seccionComerial;

    public Empresa(String id, String nombre, String telefono, String ocupacion, String direccion, boolean estaSuscrito, Cuenta[] cuenta, String nit, String nombre1, String seccionComerial) {
        super(id, nombre, telefono, ocupacion, direccion, estaSuscrito, cuenta);
        this.nit = nit;
        this.nombre = nombre1;
        this.seccionComerial = seccionComerial;
    }
}
