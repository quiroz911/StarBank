package operacion;

import modelo.Cuenta;
import modelo.Sucursal;
import operacion.Operacion;

import java.time.LocalDate;

public class Retiro extends Operacion {
    private double valor;

    public Retiro(String nombreOperacion, Cuenta cuenta, Sucursal sucursal, LocalDate fecha, double valor1) {
        super(nombreOperacion, cuenta, sucursal, fecha);
        this.valor = valor1;
    }
}
