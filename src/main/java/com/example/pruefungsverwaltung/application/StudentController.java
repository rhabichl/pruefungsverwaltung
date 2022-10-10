package com.example.pruefungsverwaltung.application;

import com.example.pruefungsverwaltung.models.SchoolClass;
import com.example.pruefungsverwaltung.models.Student;
import com.example.pruefungsverwaltung.models.repositorie.SchoolRepositories;
import com.example.pruefungsverwaltung.models.repositorie.StudentRepositories;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.Set;

@Component
public class StudentController {
    public ListView<Student> students;
    public TextField firstname;
    public TextField lastname;
    public DatePicker birthday;
    public ComboBox<SchoolClass> schoolClass;
    @Autowired
    public SchoolRepositories schoolRepositories;
    @Autowired
    public StudentRepositories studentRepositories;

    public void initialize(){
        students.getItems().setAll(studentRepositories.findAll());
    }

    public void loadStudent(MouseEvent mouseEvent) {
        Student s = students.getSelectionModel().getSelectedItem();
        firstname.clear();
        lastname.clear();
        schoolClass.getItems().clear();

        firstname.setText(s.getFirstname());
        lastname.setText(s.getLastname());
        if (s.getBirthday() != null){
            birthday.setValue(s.getBirthday().toLocalDate());

        }
        schoolClass.getItems().addAll(schoolRepositories.findAll());
        schoolClass.getSelectionModel().select(s.getSchoolClass());

    }

    public void saveClicked(ActionEvent actionEvent) {
        Student s = new Student();
        if (students.getSelectionModel().getSelectedItem() == null){
            s = students.getSelectionModel().getSelectedItem();
        }
        s.setFirstname(firstname.getText());
        s.setLastname(lastname.getText());
        s.setBirthday(Date.valueOf(birthday.getValue()));
        studentRepositories.save(s);
        studentRepositories.flush();
    }  

    public void removedClicked(ActionEvent actionEvent) {
    }
}
