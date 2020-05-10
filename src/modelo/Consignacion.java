package modelo;

public class Consignacion extends Operacion {
    private double valor;

    public Consignacion(String nombreOperacion, Cuenta cuenta, Sucursal sucursal, double valor1) {
        super(nombreOperacion, cuenta, sucursal);
        this.valor = valor1;
    }
}
