package controlador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import modelo.Cuenta;

public class controladorCreaCuenta {
    @FXML
    Label labelCodigo;
    @FXML
    TextField txtIdTitular;

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


}
