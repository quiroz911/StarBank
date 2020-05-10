package modelo;

public class PersonaNatural extends Cliente {
    
    public PersonaNatural(String id, String nombre, String telefono, String ocupacion, String direccion, boolean estaSuscrito, Cuenta[] cuenta) {
        super(id, nombre, telefono, ocupacion, direccion, estaSuscrito, cuenta);
    }
}
