package controlador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class controladorMenuCajero {
    @FXML
    private BorderPane menu;

    //action de botón Registrar Cliente
    public void abrirRegistrarCliente_action(ActionEvent actionEvent) throws IOException {
            try {
                AnchorPane registrarCliente = FXMLLoader.load(getClass().getResource("/vista/registroCliente.fxml"));
                menu.setCenter(registrarCliente);
            } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void abrirCrearCuenta_action(ActionEvent actionEvent) throws IOException {
        try {
            AnchorPane crearCuenta = FXMLLoader.load(getClass().getResource("/vista/creaCuenta.fxml"));
            menu.setCenter(crearCuenta);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
