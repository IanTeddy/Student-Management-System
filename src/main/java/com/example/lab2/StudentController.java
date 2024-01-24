package com.example.lab2;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class StudentController {
    @FXML
    private Label welcomeText;

    @FXML
    private Label helloText;


    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to Student system!");
    }
}