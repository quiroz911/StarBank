package controlador;

import Gson.Mediador;
import Gson.Serializador;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import modelo.Cuenta;
import modelo.Sucursal;
import operacion.Consignacion;
import operacion.CreacionCuenta;
import operacion.Retiro;

import javax.swing.*;
import java.io.IOException;
import java.time.LocalDate;


public class controladorMenuUsuario {

    @FXML
    TextField txtIdCuenta;

    @FXML
    TextField txtCantidad;

    public void btn_consigar_action(ActionEvent actionEvent) {
        //validación de que se hayan ingresado números

        Cuenta[] cuentas = (Cuenta[]) Serializador.deserializarOP("registro_cuentas.json", Cuenta[].class);
        boolean cuentaEncontrada = false;


        if(cuentas!=null){
            for(int i=0; i<cuentas.length; i++){
                if(cuentas[i].getId().equals(txtIdCuenta.getText())){
                    cuentas[i].consignar(Double.parseDouble(txtCantidad.getText()));
                    Serializador.actualizarJson(cuentas, "registro_cuentas.json");
                    cuentaEncontrada = true;

                    JOptionPane.showMessageDialog(null, "Consignación exitosa");

                    //Se registra la operacion dentro del json de operaciones
                    Consignacion consignacion = new Consignacion("Consignación",cuentas[i], Sucursal.getSingletonInstance(), LocalDate.now(), Double.parseDouble(txtCantidad.getText()));
                    Serializador.serializarOP(consignacion, "operaciones.json");
                }
            }
            if(!cuentaEncontrada){
                JOptionPane.showMessageDialog(null, "Esta cuenta no existe");
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "No existen cuentas");
        }

    }

    public void btn_retirar_action(ActionEvent actionEvent) {
        Cuenta[] cuentas = (Cuenta[]) Serializador.deserializarOP("registro_cuentas.json", Cuenta[].class);
        boolean cuentaEncontrada = false;


        if(cuentas!=null){
            for(int i=0; i<cuentas.length; i++){
                if(cuentas[i].getId().equals(txtIdCuenta.getText())){
                    //se le consigna a la cuenta de Starbank, en la posición 0, lo correspondiente que se retira de la cuenta de usuario
                    cuentas[0].consignar(cuentas[i].retirarDinero(Double.parseDouble(txtCantidad.getText())));
                    Serializador.actualizarJson(cuentas, "registro_cuentas.json");
                    cuentaEncontrada = true;

                    //Se registra la operacion dentro del json de operaciones
                    Retiro retiro = new Retiro("Retiro",cuentas[i], Sucursal.getSingletonInstance(), LocalDate.now(), Double.parseDouble(txtCantidad.getText()));
                    Serializador.serializarOP(retiro, "operaciones.json");
                }
            }
            if(!cuentaEncontrada){
                JOptionPane.showMessageDialog(null, "Esta cuenta no existe");
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "No existen cuentas");
        }
    }
}
