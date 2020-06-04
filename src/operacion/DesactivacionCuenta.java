package operacion;

import modelo.Cuenta;
import modelo.Sucursal;
import operacion.Operacion;

import java.time.LocalDate;

public class DesactivacionCuenta extends Operacion {

    public DesactivacionCuenta(String nombreOperacion, Cuenta cuenta, Sucursal sucursal, LocalDate fecha) {
        super(nombreOperacion, cuenta, sucursal, fecha);
    }
}
