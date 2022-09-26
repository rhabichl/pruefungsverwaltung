package com.example.pruefungsverwaltung;

import com.example.pruefungsverwaltung.application.JavaFxApplication;
import javafx.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@SpringBootApplication
public class PruefungsverwaltungApplication {

    public static void main(String[] args) {
        Application.launch(JavaFxApplication.class, args);
    }

}
