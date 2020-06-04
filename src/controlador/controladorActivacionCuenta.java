package controlador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import modelo.Cajero;

public class controladorActivacionCuenta {

    Cajero cajero = new Cajero();

    @FXML
    TextField txtId;
    @FXML
    CheckBox checkRetirar;


    public void desactivarCuenta_action(ActionEvent actionEvent) {
        cajero.desactivarCuenta(txtId.getText(), checkRetirar.isSelected());
    }

    public void activarCuenta_action(ActionEvent actionEvent) {
        cajero.activarCuenta(txtId.getText());
    }
}
