package controlador;

import Gson.Mediador;
import Gson.Serializador;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import modelo.Cuenta;
import modelo.CuentaAhorros;
import modelo.CuentaCorriente;

public class controladorCreaCuenta {

    Serializador serializador = new Serializador();
    CuentaAhorros cuentaAhorros = new CuentaAhorros();
    CuentaCorriente cuentaCorriente = new CuentaCorriente();

    @FXML
    Label labelCodigo;
    @FXML
    TextField txtIdTitular;
    @FXML
    RadioButton RdBtnAhorros;
    @FXML
    RadioButton RdBtnCorriente;


    //boton para generar el código de id aleatoriamente
    public void btnGenerarCodigo_action(ActionEvent actionEvent) {
        labelCodigo.setText(Cuenta.generarId());
        labelCodigo.setVisible(true);
        //Luego se utiliza el labelCodigo.getText() para extrar este código para guardar en el Json
    }

    //boton para limpiar los campos de registro
    public void btnLimpiarRegistro_action(ActionEvent actionEvent) {
        labelCodigo.setText(null);
        labelCodigo.setVisible(false);
        txtIdTitular.setText(null);
    }


    public void BtnCrearCuenta_action(ActionEvent actionEvent) {
        if(RdBtnAhorros.isSelected()){
            //Se necesita hacer uso del mediador para encontrar el cliente que tiene el respectivo Id ingresado por el usuario. Notificarle si no existe
            cuentaAhorros.setCliente(Mediador.retornaCliente(txtIdTitular.getText()));
            cuentaAhorros.setSaldo(20000);
            cuentaAhorros.setEstado(true);
            cuentaAhorros.setId(labelCodigo.getText());

            serializador.serializarOP(cuentaAhorros, "registro_cuentasAhorros.json");

            btnLimpiarRegistro_action(actionEvent);
        }
        else{
            cuentaCorriente.setCliente(Mediador.retornaCliente(txtIdTitular.getText()));
            cuentaCorriente.setSaldo(20000);
            cuentaCorriente.setEstado(true);
            cuentaCorriente.setId(labelCodigo.getText());
            serializador.serializarOP(cuentaCorriente, "registro_cuentasCorriente.json");
        }
    }
}
