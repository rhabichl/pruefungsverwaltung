package com.example.pruefungsverwaltung;

import com.example.pruefungsverwaltung.application.Controller;
import com.example.pruefungsverwaltung.application.JavaFxApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class Loader {

    public static FXMLLoader getFXMLLoader(String fileName){
        FXMLLoader loader = new FXMLLoader(Controller.class.getResource(fileName));
        loader.setControllerFactory(JavaFxApplication.getSpringContext()::getBean);
        return loader;
    }

    public static void loadScene(FXMLLoader loader, String windowName, ActionEvent actionEvent){
        try {
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle(windowName);

            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(((Node) actionEvent.getSource()).getScene().getWindow());

            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
