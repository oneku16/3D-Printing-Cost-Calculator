package com.example.calculator_2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class HomeController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private GridPane allButtons;

    @FXML
    private VBox getStudentData;

    @FXML
    private VBox getStudentData1;

    @FXML
    private VBox getStudentData11;

    @FXML
    private TextField inputDate;

    @FXML
    private TextField inputFirstName;

    @FXML
    private CheckBox inputIsAcademic;

    @FXML
    private TextField inputLastName;

    @FXML
    private TextField inputModelName;

    @FXML
    private TextField inputModelWeight;

    @FXML
    private TextField outputPrintingCost;

    public void checkAll(){
        System.out.println(new Checker().isValid(inputDate.getText()));
    }
    @FXML
    void calculateButtonOnAction(ActionEvent event) {
        checkAll();

    }

    @FXML
    void clearButtonOnAction(ActionEvent event) {

    }

    @FXML
    void saveButtonOnAction(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert allButtons != null : "fx:id=\"allButtons\" was not injected: check your FXML file 'home_page.fxml'.";
        assert getStudentData != null : "fx:id=\"getStudentData\" was not injected: check your FXML file 'home_page.fxml'.";
        assert getStudentData1 != null : "fx:id=\"getStudentData1\" was not injected: check your FXML file 'home_page.fxml'.";
        assert getStudentData11 != null : "fx:id=\"getStudentData11\" was not injected: check your FXML file 'home_page.fxml'.";
        assert inputDate != null : "fx:id=\"inputDate\" was not injected: check your FXML file 'home_page.fxml'.";
        assert inputFirstName != null : "fx:id=\"inputFirstName\" was not injected: check your FXML file 'home_page.fxml'.";
        assert inputIsAcademic != null : "fx:id=\"inputIsAcademic\" was not injected: check your FXML file 'home_page.fxml'.";
        assert inputLastName != null : "fx:id=\"inputLastName\" was not injected: check your FXML file 'home_page.fxml'.";
        assert inputModelName != null : "fx:id=\"inputModelName\" was not injected: check your FXML file 'home_page.fxml'.";
        assert inputModelWeight != null : "fx:id=\"inputModelWeight\" was not injected: check your FXML file 'home_page.fxml'.";
        assert outputPrintingCost != null : "fx:id=\"outputPrintingCost\" was not injected: check your FXML file 'home_page.fxml'.";

    }

}
