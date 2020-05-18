package controlador;

import Gson.Serializador;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import modelo.Cliente;
import modelo.Empresa;
import modelo.PersonaNatural;

public class controladorRegistroCliente {

    Serializador serializador = new Serializador();
    PersonaNatural clientePN = new PersonaNatural();
    Empresa empresa = new Empresa();

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
        clientePN.setId(txtIdPN.getText());
        clientePN.setNombre(txtNombrePN.getText());
        clientePN.setTelefono(txtTelefonoPN.getText());
        clientePN.setDireccion(txtDireccionPN.getText());
        clientePN.setOcupacion(txtOcupacionPN.getText());
        System.out.println("funciona");

        serializador.serializarOP(clientePN, "registro_clientes.json");
    }

    public void btnGuardarRegistroE_action(ActionEvent actionEvent) {
        empresa.setId(txtIdEmp.getText());
        empresa.setNombre(txtNombreEmp.getText());
        empresa.setTelefono(txtTelefonoEmp.getText());
        empresa.setDireccion(txtDireccionEmp.getText());
        empresa.setOcupacion(txtOcupacionEmp.getText());
        empresa.setNit(txtNit.getText());
        empresa.setNombreEmpresa(txtNombreEmpresa.getText());
        empresa.setSeccionComerial(txtSectorComercial.getText());


        serializador.serializarOP(empresa, "registro_clientes.json");
    }
}
