package modelo;

import Gson.Serializador;
import operacion.ActivacionCuenta;
import operacion.DesactivacionCuenta;

import javax.swing.*;
import java.time.LocalDate;

public class Cajero {
    public void registrarCliente(Cliente cliente){
        Serializador.serializarOP(cliente, "registro_clientes.json");
    }
    public void crearCuenta(Cuenta cuenta){
        Serializador.serializarOP(cuenta, "registro_cuentas.json");
    }
    public void desactivarCuenta(String id, boolean conRetiro){
        Cuenta[] cuentas = (Cuenta[]) Serializador.deserializarOP("registro_cuentas.json", Cuenta[].class);
        if(cuentas!=null) {
            for(int i=0; i<cuentas.length; i++){
                if (cuentas[i].getId().equals(id)){
                    if(cuentas[i].isEstado()){
                        //se desactiva la cuenta
                        cuentas[i].setEstado(false);
                        //si pidió retiro se realiza
                        if(conRetiro) cuentas[i].setSaldo(0);

                        //se verifica si el cliente quedó sin cuentas activas
                        Cliente[] clientes = (Cliente[]) Serializador.deserializarOP("registro_clientes.json", Cliente[].class);
                        String idCliente = cuentas[i].getCliente().getId();
                        boolean tieneMasCuentas = false;
                        for(int j=0; j<cuentas.length; j++){
                            if(cuentas[j].getCliente().getId().equals(idCliente)){
                                if (cuentas[j].isEstado()){
                                    tieneMasCuentas = true;
                                }
                            }
                        }
                        if(!tieneMasCuentas) {
                            for(int k=0; k<clientes.length; k++){
                                if(clientes[k].getId().equals(idCliente)){
                                    clientes[k].setEstaSuscrito(false);
                                    Serializador.actualizarJson(clientes,"registro_clientes.json");
                                }
                            }
                            cuentas[i].getCliente().setEstaSuscrito(false);
                        }

                        //Se registra la operación en el json
                        DesactivacionCuenta desactivacionCuenta = new DesactivacionCuenta("desactivacionCuenta",cuentas[i],Sucursal.getSingletonInstance(), LocalDate.now());
                        Serializador.serializarOP(desactivacionCuenta, "operaciones.json");

                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Este cuenta ya estaba desactivada");
                    }


                }
            }
            Serializador.actualizarJson(cuentas, "registro_cuentas.json");
        }

    }
    public void activarCuenta(String id){
        Cuenta[] cuentas = (Cuenta[]) Serializador.deserializarOP("registro_cuentas.json", Cuenta[].class);
        if(cuentas!=null){
            for(int i=0; i<cuentas.length; i++){
                if(cuentas[i].getId().equals(id)){
                    //si la cuenta estaba sin saldo, debe consignar 20.000 para poder activar la cuenta
                    if(cuentas[i].getSaldo()==0) {
                        cuentas[i].consignar(20000);
                        JOptionPane.showMessageDialog(null, "Consignación por activación exitosa");
                    }
                    //se activa si no estaba activada ya
                    if (cuentas[i].isEstado()){
                        JOptionPane.showMessageDialog(null, "Esta cuenta ya estaba activa");
                    }
                    else{
                        cuentas[i].setEstado(true);

                        //Se registra la operación en el json
                        ActivacionCuenta activacionCuenta = new ActivacionCuenta("activacionCuenta",cuentas[i],Sucursal.getSingletonInstance(), LocalDate.now());
                        Serializador.serializarOP(activacionCuenta, "operaciones.json");
                    }

                    //se verifica si el cliente estaba desuscrito
                    Cliente[] clientes = (Cliente[]) Serializador.deserializarOP("registro_clientes.json", Cliente[].class);
                    for(int j=0; j<clientes.length;j++){
                        if(clientes[j].getId().equals(cuentas[i].getCliente().getId())){
                            if(!clientes[j].isEstaSuscrito()){
                                clientes[j].setEstaSuscrito(true);
                                Serializador.actualizarJson(clientes,"registro_clientes.json");
                                cuentas[i].getCliente().setEstaSuscrito(true);
                            }
                        }
                    }
                }
            }
            Serializador.actualizarJson(cuentas, "registro_cuentas.json");
        }
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
