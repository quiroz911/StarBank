package modelo;

import java.time.LocalDate;

public class Operacion {

    String nombreOperacion;
    LocalDate fecha;
    Cuenta cuenta;
    Sucursal sucursal;

    public Operacion(String nombreOperacion, Cuenta cuenta, Sucursal sucursal) {
        this.nombreOperacion = nombreOperacion;
        this.cuenta = cuenta;
        this.sucursal = sucursal;
    }

    public String getNombreOperacion() {
        return nombreOperacion;
    }

    public void setNombreOperacion(String nombreOperacion) {
        this.nombreOperacion = nombreOperacion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }
}
