package modelo;

public class CuentaAhorros extends Cuenta {

    private double interesMensual;

    public CuentaAhorros(Cliente cliente, Sucursal sucursal, double interesMensual) {
        super(cliente, sucursal);
        this.interesMensual = interesMensual;
        cobroRetiro = 0.02;
    }

    public CuentaAhorros() {
        cobroRetiro = 0.02;
    }

    public double getInteresMensual() {
        return interesMensual;
    }

    public void setInteresMensual(double interesMensual) {
        this.interesMensual = interesMensual;
    }

}
