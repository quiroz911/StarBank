package modelo;

public class CuentaCorriente extends Cuenta {

    public CuentaCorriente(Cliente cliente, Sucursal sucursal) {
        super(cliente, sucursal);
        cobroRetiro = 0.017;
    }

    public CuentaCorriente() {
        cobroRetiro = 0.017;
    }
}
