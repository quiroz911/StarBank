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
    public boolean verificarCliente(String id){
        Cliente[] clientes = (Cliente[]) Serializador.deserializarOP("registro_clientes.json", Cliente[].class);
        if(clientes!=null) {
            for (Cliente clienteRecorrido : clientes) {
                if (clienteRecorrido.getId().equals(id)) {
                    return true;
                }
            }
        }
        return false;
    }
}
