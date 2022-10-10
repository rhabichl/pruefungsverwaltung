package com.example.pruefungsverwaltung.application;

import com.example.pruefungsverwaltung.Loader;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import org.springframework.stereotype.Component;

@Component
public class Controller {

    public void Insert(ActionEvent actionEvent){
        System.out.println("Hello World");
        FXMLLoader fx  = Loader.getFXMLLoader("AddClass.fxml");
        Loader.loadScene(fx, "Class", actionEvent);
    }

    public void StudentEdit(ActionEvent actionEvent) {
        FXMLLoader fx = Loader.getFXMLLoader("Student.fxml");
        Loader.loadScene(fx, "Student", actionEvent);

    }
}
