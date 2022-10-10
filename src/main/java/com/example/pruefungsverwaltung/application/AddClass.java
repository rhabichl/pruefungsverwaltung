package com.example.pruefungsverwaltung.application;

import com.example.pruefungsverwaltung.models.SchoolClass;
import com.example.pruefungsverwaltung.models.Student;
import com.example.pruefungsverwaltung.models.repositorie.SchoolRepositories;
import com.example.pruefungsverwaltung.models.repositorie.StudentRepositories;
import com.sun.javafx.collections.ImmutableObservableList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.function.Predicate;

@Component
public class AddClass {
    public ListView<SchoolClass> classList;



    private ObservableList<Student> all = FXCollections.observableArrayList();;

    private ObservableList<Student> inClass = FXCollections.observableArrayList();;


    private Student selected_student;

    @Autowired
    public SchoolRepositories sr;
    @Autowired
    public StudentRepositories st;
    public TextField title;
    public TextField id;
    public ListView<Student> students;
    public ListView<Student> remaining_students;

    public void initialize(){
        id.setEditable(false);
        classList.getItems().addAll(sr.findAll());
        remaining_students.getItems().setAll(st.findAll());
    }

    public void loadClass(MouseEvent mouseEvent) {
        id.setEditable(true);
        // clear all fields
        title.clear();
        id.clear();
        students.getItems().clear();
        remaining_students.getItems().clear();
        // load all fields
        SchoolClass sc  = classList.getSelectionModel().getSelectedItem();
        title.setText(sc.getTitle());
        id.setText(sc.getId().toString());

        all.setAll(st.findAll());
        inClass.setAll(sc.getStudents());

        displayStudents(all, inClass);
    }



    private void displayStudents(ObservableList<Student>  allLocal, ObservableList<Student> inClassLocal){
        students.getItems().setAll(inClassLocal);
        allLocal.removeIf(student -> {
            for (Student s: inClassLocal) {
                if (Objects.equals(s.getId(), student.getId())){
                    return true;
                }
            }
            return false;
        });
        remaining_students.getItems().setAll(allLocal);
    }

    public void save(ActionEvent actionEvent){
        SchoolClass sc = new SchoolClass();
        if (!id.getText().isEmpty()){

            Optional<SchoolClass> s = sr.findById(classList.getSelectionModel().getSelectedItem().getId());
            if (s.isEmpty()){
                return;
            }
            sc = s.get();
        }

        sc.setTitle(title.getText());
        Set<Student> s = new HashSet<>(inClass);
        for (Student student : inClass) {
            Optional<Student> ss = st.findById(student.getId());
            if (ss.isEmpty()){
                return;
            }
            Student sss = ss.get();
           s.add(sss);
        }
        sc.setStudents(s);
        sr.save(sc);
        sr.flush();
        if (s.size() == 0){
            for (Student student : sc.getStudents()) {
                Optional<Student> ss = st.findById(student.getId());
                if (ss.isEmpty()){
                    return;
                }
                Student sss = ss.get();
                sss.setSchoolClass(null);
                st.save(sss);
            }
        }else {
            for (Student student : inClass) {
                Optional<Student> ss = st.findById(student.getId());
                if (ss.isEmpty()){
                    return;
                }
                Student sss = ss.get();
                sss.setSchoolClass(sc);
                st.save(sss);
            }
        }
        st.flush();
    }

    public void add_students(ActionEvent actionEvent) {
        if (selected_student == null){
            return;
        }
        if (inClass.contains(selected_student)){
            return;
        }
        inClass.add(selected_student);
        all.remove(selected_student);
        selected_student = null;
        displayStudents(all, inClass);
    }

    public void remove_students(ActionEvent actionEvent) {
        if (selected_student == null){
            return;
        }
        if (all.contains(selected_student)){
            return;
        }
        all.add(selected_student);
        inClass.remove(selected_student);
        selected_student = null;
        displayStudents(all, inClass);
    }

    public void exit(ActionEvent actionEvent) {
    }

    public void remove(ActionEvent actionEvent) {
        if (classList.getSelectionModel().getSelectedItem().getId() == null){
            return;
        }
        Optional<SchoolClass> s = sr.findById(classList.getSelectionModel().getSelectedItem().getId());
        if (s.isEmpty()){
            return;
        }
        sr.delete(s.get());
        sr.flush();
        classList.getItems().remove(classList.getSelectionModel().getSelectedItem());
    }

    public void getStudentInClass(MouseEvent mouseEvent) {
        selected_student = students.getSelectionModel().getSelectedItem();;
    }

    public void getAllStudent(MouseEvent mouseEvent) {
        selected_student = remaining_students.getSelectionModel().getSelectedItem();
    }

    public void new_class(ActionEvent actionEvent) {
        title.clear();
        id.clear();
        students.getItems().clear();
        remaining_students.getItems().clear();
        id.setEditable(false);
        remaining_students.getItems().setAll(st.findAll());
    }
}
