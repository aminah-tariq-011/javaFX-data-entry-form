package com.example.assignment;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import java.io.File;
import java.util.ArrayList;


public class Banner extends Application {
       private  ArrayList <Person> students = new ArrayList<>();


    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(10));

        Label banner = new Label("Student Record");
          banner.setStyle("-fx-font-size: 35px;-fx-font-weight: bold; -fx-text-fill: white");

        HBox bannerBox = new HBox(banner);
        bannerBox.setPadding(new Insets(20));
        bannerBox.setStyle("-fx-alignment: center; -fx-background-color: #4B1D45; -fx-background-radius: 5");
        root.setTop(bannerBox);

        VBox form = new VBox(10);
        form.setPadding(new Insets(15));

        Label name = new Label("Username");
        name.setStyle("-fx-text-fill: white");
        TextField nameField = new TextField();

        nameField.setPromptText("example@cuilahore.edu.pk");
        nameField.setStyle("-fx-background-color: #934F5D;-fx-text-fill: black;");
        //nameField.setStyle("-fx-font-style: black");
        form.getChildren().addAll(name,nameField);

Label fatherName = new Label("Father Name");
fatherName.setStyle("-fx-text-fill: white");
TextField fatherNameField = new TextField();
fatherNameField.setPromptText("example");
        fatherNameField.setStyle("-fx-background-color: #934F5D;-fx-text-fill: black;");
        form.getChildren().addAll(fatherName,fatherNameField);

        Label cnicLabel = new Label("CNIC");
        cnicLabel.setStyle("-fx-text-fill: white");
        TextField cnicField = new TextField();
        cnicField.setPromptText("Enter CNIC (only numbers)");

        Label errorLabel = new Label("Invalid input: Only numbers are allowed.");
        errorLabel.setTextFill(Color.RED);
        errorLabel.setVisible(false);

        cnicField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                cnicField.setText(oldValue);
                errorLabel.setVisible(true);
            } else {
                errorLabel.setVisible(false);
            }
        });

        cnicField.setStyle("-fx-background-color: #934F5D;-fx-text-fill: black;");
        form.getChildren().addAll(cnicLabel, cnicField, errorLabel);


        Label dateLabel = new Label("Date of birth");
        dateLabel.setStyle("-fx-text-fill: white");
        DatePicker datePicker = new DatePicker();


        datePicker.getEditor().setDisable(true);
        datePicker.getEditor().setOpacity(0.5);
        datePicker.setPromptText("Select a date");
        Label infoLabel = new Label("Please select a date from the calendar.");
        infoLabel.setStyle("-fx-text-fill: #898989");
        datePicker.setStyle("-fx-background-color: #934F5D;-fx-text-fill: black;");
        form.getChildren().addAll(dateLabel, datePicker, infoLabel);


Label genderLabel = new Label("Gender");
genderLabel.setStyle(
        "-fx-text-fill: white"
);
//ComboBox<String> genderComboBox = new ComboBox<>();
        form.getChildren().add(genderLabel);
        HBox genderBox = new HBox(15);
        RadioButton male = new RadioButton("Male");
        male.setStyle("-fx-text-fill: white");
        RadioButton female = new RadioButton("Female");
        female.setStyle("-fx-text-fill: white");
        ToggleGroup genderGroup = new ToggleGroup();
        male.setToggleGroup(genderGroup);
         female.setToggleGroup(genderGroup);
        genderBox.getChildren().addAll(male, female);
        form.getChildren().add(genderBox);

Label cityLabel = new Label("City");
cityLabel.setStyle("-fx-text-fill: white");
        form.getChildren().add(cityLabel);
        ComboBox<String> cityComboBox = new ComboBox<>();
        cityComboBox.getItems().addAll("Lahore", "Islamabad", "Karachi");
        cityComboBox.setStyle("-fx-background-color: #934F5D;-fx-text-fill: black;");
         form.getChildren().add(cityComboBox);

        HBox buttonBox = new HBox(10);
        buttonBox.setPadding(new Insets(10));
        buttonBox.setStyle("-fx-alignment: center");

       /* Button printButton = new Button("Print Record");
        printButton.setStyle("-fx-background-color: #F39F5A");*/

        Button saveButton = new Button("Save Record");
        saveButton.setStyle("-fx-background-color: #F39F5A");
        form.getChildren().add(saveButton);
        root.setLeft(form);
        VBox rightSection = new VBox(20);
        rightSection.setPadding(new Insets(30));
        buttonBox.getChildren().addAll(saveButton);
        form.getChildren().add(buttonBox);
        root.setLeft(form);



       /* printButton.setOnAction(e -> {
            String name1 = nameField.getText();
            String fatherName1 = fatherNameField.getText();
            String cnic = cnicField.getText();
            String gender = null;
            if (male.isSelected()) {
                gender = "Male";
            } else if (female.isSelected()) {
                gender = "Female";
            }
            String dateOfBirth = (datePicker.getValue() != null) ? datePicker.getValue().toString() : "Not selected";
            String city = cityComboBox.getValue();


            String details = String.format(
                    "----- Person Details -----\n" +
                            "Name          : %s\n" +
                            "Father's Name : %s\n" +
                            "CNIC          : %s\n" +
                            "Date of Birth : %s\n" +
                            "Gender        : %s\n" +
                            "City          : %s\n" +
                            "---------------------------",
                    name1, fatherName1, cnic, dateOfBirth, gender, city);


            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Form Details");
            alert.setHeaderText("Submitted Form Data");
            alert.setContentText(details);


            alert.showAndWait();

        });*/

        ImageView imageView = new ImageView();

        imageView.setFitHeight( 200);
        imageView.setFitWidth( 200);
        imageView.setPreserveRatio(true);
        imageView.setStyle("-fx-alignment: left");
        imageView.setStyle("-fx-border: black");



        Button fileChooserButton = new Button("choose img from your pc");
        fileChooserButton.setStyle("-fx-background-color: #F39F5A");
        rightSection.getChildren().addAll(imageView,fileChooserButton);


        fileChooserButton.setOnAction(event -> {
            FileChooser fileChooser1 = new FileChooser();
            fileChooser1.setTitle("Choose an Image");
            fileChooser1.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg", "*.gif")
            );


            File selectedFile = fileChooser1.showOpenDialog(primaryStage);
            if (selectedFile != null) {

                Image image = new Image(((java.io.File) selectedFile).toURI().toString());
                imageView.setImage(image);
            }
        });

        Button displayButton = new Button("Display All Student Record");
        displayButton.setStyle("-fx-background-color: #F39F5A");
        rightSection.getChildren().addAll(displayButton);

        displayButton.setOnAction(event -> {
            displaystudents();
        });

        saveButton.setOnAction(e -> {

            String name1 = nameField.getText();
            String fatherName1 = fatherNameField.getText();
            String cnic = cnicField.getText();
            String gender=null;
            if (genderGroup.getToggles().toString()=="male"){
            gender = "Male";}
            else {gender="female";}
            String dateOfBirth = (datePicker.getValue() != null) ? datePicker.getValue().toString() : "Not selected";
            String city = cityComboBox.getValue();
            students.add(new Person(name1,fatherName1,cnic,dateOfBirth,gender,city));
            System.out.println("record saved\n");


           /* System.out.println("Name: " + name1);
            System.out.println("FatherName: " + fatherName1);
            System.out.println("CNIC: " + cnic);
            System.out.println("Gender: " + gender);
            System.out.println("city: " + city);
            System.out.println("Date of Birth: " + dateOfBirth);*/


            String details = String.format(
                    "----- Person Details -----\n" +
                            "Name          : %s\n" +
                            "Father's Name : %s\n" +
                            "CNIC          : %s\n" +
                            "Date of Birth : %s\n" +
                            "Gender        : %s\n" +
                            "City          : %s\n" +
                            "---------------------------",
                    name1, fatherName1, cnic, dateOfBirth, gender, city);


            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Form Details");
            alert.setHeaderText("Submitted Form Data");
            alert.setContentText(details);


            alert.showAndWait();


            nameField.clear();
            cnicField.clear();
            fatherNameField.clear();
            cityComboBox.setValue(null);
            imageView.setImage(null);
            genderGroup.selectToggle(null);
            datePicker.setValue(null);



        });



        root.setRight(rightSection);
        Scene scene = new Scene(root, 700, 600);
        primaryStage.setTitle("Student records");
        root.setStyle("-fx-background-color: #220c28");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public void displaystudents(){
        System.out.println("--SAVED STUDENTS--");
        for (Person student : students) {
            System.out.println("Name: " + student.getName());
            System.out.println("FatherName: " + student.getFatherName());
            System.out.println("CNIC: " + student.getCnic());
            System.out.println("Gender: " + student.getGender());
            System.out.println("city: " + student.getCity());
            System.out.println("Date of Birth: " + student.getDob());
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
