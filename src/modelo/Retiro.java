package modelo;

public class Retiro extends Operacion {
    private double valor;

    public Retiro(String nombreOperacion, Cuenta cuenta, Sucursal sucursal, double valor1) {
        super(nombreOperacion, cuenta, sucursal);
        this.valor = valor1;
    }
}
