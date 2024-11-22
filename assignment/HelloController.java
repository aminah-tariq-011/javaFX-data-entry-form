package com.example.assignment;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

     @FXML
    protected void onButtonClick() {welcomeText.setText("Record saved!!");
     }
}
