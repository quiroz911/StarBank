package operacion;

import modelo.Cuenta;
import modelo.Sucursal;

import java.time.LocalDate;

public class ActivacionCuenta extends Operacion{
    public ActivacionCuenta(String nombreOperacion, Cuenta cuenta, Sucursal sucursal, LocalDate fecha) {
        super(nombreOperacion, cuenta, sucursal, fecha);
    }
}
