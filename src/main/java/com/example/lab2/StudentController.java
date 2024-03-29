package com.example.lab2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class StudentController implements Initializable {
    // FXML elements
    // Table
    @FXML
    private TableView<Student> studentTable;
    @FXML
    private TableColumn<Student, Integer> studentID; // column 1
    @FXML
    private TableColumn<Student, String> fullName; // column 2
    @FXML
    private TableColumn<Student, String> major; // column 3

    // input fields
    @FXML
    private TextField idField;
    @FXML
    private TextField nameField;
    @FXML
    private TextField majorField;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        studentID.setCellValueFactory(new PropertyValueFactory<>("id"));
        fullName.setCellValueFactory(new PropertyValueFactory<>("name"));
        major.setCellValueFactory(new PropertyValueFactory<>("major"));
    }



    // Add students function
    @FXML
    private void addStudent(ActionEvent event) {
        try {
            // Error handling(1) : Check if text fields are empty
            if (idField.getText().isEmpty() || nameField.getText().isEmpty() || majorField.getText().isEmpty()) {
                throw new IllegalArgumentException("Some field are missing.");
            }

            // Create a new Student from text field data
            Student newData = new Student(Integer.parseInt(idField.getText()), nameField.getText(), majorField.getText());
            // Add the new Student to the table
            studentTable.getItems().add(newData);

            // clear the fields after inserting data
            idField.clear();
            nameField.clear();
            majorField.clear();
        } catch (NumberFormatException e){ // Error Handling(2): Check if ID is number
            throw new IllegalArgumentException("Invalid ID. Must be integer value.");
        }

        deleteStudent(event);
    }

    // Delete students function
    @FXML
    void deleteStudent(ActionEvent event) {
        int selectedID = studentTable.getSelectionModel().getSelectedIndex();
        studentTable.getItems().remove(selectedID);
    }

    //Initialize the table
    @FXML
    void refreshTable(ActionEvent event) {
        ObservableList<Student> latestData = FXCollections.observableArrayList();

        studentTable.setItems(latestData);

        System.out.println("Refreshed the data in the table!");
    }

    // Edit students function
    @FXML
    void editStudent() {
        if(studentTable.getSelectionModel().getSelectedItem() != null) {
            Student studentSelected = studentTable.getSelectionModel().getSelectedItem();

            idField.setText(String.valueOf(studentSelected.getId()));
            nameField.setText(studentSelected.getName());
            majorField.setText(studentSelected.getMajor());
        }else{
            System.out.println("No item selected in the table.");
        }
    }

}
