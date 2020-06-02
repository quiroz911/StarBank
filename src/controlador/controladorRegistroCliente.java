package controlador;

import Gson.Serializador;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import modelo.Cajero;
import modelo.Cliente;
import modelo.Empresa;
import modelo.PersonaNatural;

import javax.swing.*;

public class controladorRegistroCliente {

    Cajero cajero = new Cajero();

    //Textfield de persona natural
    @FXML
    TextField txtIdPN;
    @FXML
    TextField txtNombrePN;
    @FXML
    TextField txtTelefonoPN;
    @FXML
    TextField txtDireccionPN;
    @FXML
    TextField txtOcupacionPN;

    //Textfield de empresa
    @FXML
    TextField txtIdEmp;
    @FXML
    TextField txtNombreEmp;
    @FXML
    TextField txtTelefonoEmp;
    @FXML
    TextField txtDireccionEmp;
    @FXML
    TextField txtOcupacionEmp;
    @FXML
    TextField txtNit;
    @FXML
    TextField txtNombreEmpresa;
    @FXML
    TextField txtSectorComercial;



    public void btnGuardarRegistroPN_action(ActionEvent actionEvent) {
        PersonaNatural clientePN = new PersonaNatural();

        clientePN.setId(txtIdPN.getText());
        clientePN.setNombre(txtNombrePN.getText());
        clientePN.setTelefono(txtTelefonoPN.getText());
        clientePN.setDireccion(txtDireccionPN.getText());
        clientePN.setOcupacion(txtOcupacionPN.getText());

        //Se verifica que este cliente ya no esté registrado
        if(cajero.verificarCliente(txtIdPN.getText())){
            JOptionPane.showMessageDialog(null,"Este cliente ya se encuentra registrado");
            return;
        }
        //El cajero es el encargado de registrar el cliente
        cajero.registrarCliente(clientePN);
    }

    public void btnGuardarRegistroE_action(ActionEvent actionEvent) {
        Empresa empresa = new Empresa();

        empresa.setId(txtIdEmp.getText());
        empresa.setNombre(txtNombreEmp.getText());
        empresa.setTelefono(txtTelefonoEmp.getText());
        empresa.setDireccion(txtDireccionEmp.getText());
        empresa.setOcupacion(txtOcupacionEmp.getText());
        empresa.setNit(txtNit.getText());
        empresa.setNombreEmpresa(txtNombreEmpresa.getText());
        empresa.setSeccionComerial(txtSectorComercial.getText());

        if(cajero.verificarCliente(txtIdEmp.getText())){
            JOptionPane.showMessageDialog(null,"Este cliente ya se encuentra registrado");
            return;
        }
        //El cajero es el encargado de registrar el cliente
        cajero.registrarCliente(empresa);
    }
}
