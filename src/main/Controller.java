package main;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {

    //boton para abrir la ventana menu cajero
    public void abrirMenuCajero_action(ActionEvent actionEvent) throws IOException {

            Parent root = FXMLLoader.load(getClass().getResource("/vista/menuCajero.fxml"));

            Stage primaryStage = new Stage();

            primaryStage.setTitle("Menu Cajero");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();

    }

    public void abrirMenuUsuario_action(ActionEvent actionEvent) throws IOException {

        Parent root1 = FXMLLoader.load(getClass().getResource("/vista/menuUsuario.fxml"));

        Stage primaryStage1 = new Stage();

        primaryStage1.setTitle("Menu Cajero");
        primaryStage1.setScene(new Scene(root1));
        primaryStage1.show();

    }

}
