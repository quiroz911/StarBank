package modelo;

import Gson.Serializador;

public class Cajero {
    public void registrarCliente(Cliente cliente){
        Serializador.serializarOP(cliente, "registro_clientes.json");
    }
    public void crearCuenta(Cuenta cuenta){
        Serializador.serializarOP(cuenta, "registro_cuentas.json");
    }
    public void desactivarCuenta(){

    }
    public void activarcuenta(){

    }
    public void verificarCliente(){

    }
}
