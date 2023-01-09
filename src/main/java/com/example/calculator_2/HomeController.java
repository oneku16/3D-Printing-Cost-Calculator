/**
 * Sample Skeleton for 'HomeMain.fxml' Controller Class
 */

package com.example.calculator_2;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;

public class HomeController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="allButtons"
    private GridPane allButtons; // Value injected by FXMLLoader

    @FXML // fx:id="inputFilamentType"
    private ComboBox<String> inputFilamentType; // Value injected by FXMLLoader

    @FXML // fx:id="inputFirstName"
    private TextField inputFirstName; // Value injected by FXMLLoader

    @FXML // fx:id="inputIsAcademic"
    private CheckBox inputIsAcademic; // Value injected by FXMLLoader

    @FXML // fx:id="inputLastName"
    private TextField inputLastName; // Value injected by FXMLLoader

    @FXML // fx:id="inputMaterialLength"
    private TextField inputMaterialLength; // Value injected by FXMLLoader

    @FXML // fx:id="inputPrintDate"
    private DatePicker inputPrintDate; // Value injected by FXMLLoader

    @FXML // fx:id="inputPrintName"
    private TextField inputPrintName; // Value injected by FXMLLoader

    @FXML // fx:id="inputTimeDays"
    private Spinner<Integer> inputTimeDays; // Value injected by FXMLLoader

    @FXML // fx:id="inputTimeHours"
    private Spinner<Integer> inputTimeHours; // Value injected by FXMLLoader

    @FXML // fx:id="inputTimeMinutes"
    private Spinner<Integer> inputTimeMinutes; // Value injected by FXMLLoader

    @FXML // fx:id="outputPrintingCost"
    private TextField outputPrintingCost; // Value injected by FXMLLoader

    private boolean checkAll(){
        String printDate = String.valueOf(inputPrintDate.getValue());
        System.out.println(printDate);
        return new HelperClass().isValidDate(printDate);
    }
    @FXML
    void calculateButtonOnAction(ActionEvent event) {
        System.out.println(inputPrintDate.getValue());
        if (inputIsAcademic.isSelected()){
            outputPrintingCost.setText("0 som");
        }
        else {
            HelperClass helperClass = new HelperClass();
            Double printTime = helperClass.properPrintTime(inputTimeDays.getValue(), inputTimeHours.getValue(), inputTimeMinutes.getValue());
            Calculator calculator = new Calculator(Double.parseDouble(inputMaterialLength.getText()), printTime,inputFilamentType.getValue());
            outputPrintingCost.setText(String.format("%d som", calculator.printCost()));
        }

    }

    @FXML
    void clearButtonOnAction(ActionEvent event) {

        inputFirstName.clear();
        inputLastName.clear();
        inputPrintName.clear();
        inputMaterialLength.clear();
        inputFilamentType.getSelectionModel().selectFirst();
        inputTimeDays.getEditor().clear();
        inputTimeHours.getEditor().clear();
        inputTimeMinutes.getEditor().clear();
        inputPrintDate.getEditor().clear();
        outputPrintingCost.clear();

    }

    @FXML
    void isAcademic(ActionEvent event) {

    }

    @FXML
    void saveButtonOnAction(ActionEvent event) {

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert allButtons != null : "fx:id=\"allButtons\" was not injected: check your FXML file 'HomeMain.fxml'.";
        assert inputFilamentType != null : "fx:id=\"inputFilamentType\" was not injected: check your FXML file 'HomeMain.fxml'.";
        assert inputFirstName != null : "fx:id=\"inputFirstName\" was not injected: check your FXML file 'HomeMain.fxml'.";
        assert inputIsAcademic != null : "fx:id=\"inputIsAcademic\" was not injected: check your FXML file 'HomeMain.fxml'.";
        assert inputLastName != null : "fx:id=\"inputLastName\" was not injected: check your FXML file 'HomeMain.fxml'.";
        assert inputMaterialLength != null : "fx:id=\"inputMaterialLength\" was not injected: check your FXML file 'HomeMain.fxml'.";
        assert inputPrintDate != null : "fx:id=\"inputPrintDate\" was not injected: check your FXML file 'HomeMain.fxml'.";
        assert inputPrintName != null : "fx:id=\"inputPrintName\" was not injected: check your FXML file 'HomeMain.fxml'.";
        assert inputTimeDays != null : "fx:id=\"inputTimeDays\" was not injected: check your FXML file 'HomeMain.fxml'.";
        assert inputTimeHours != null : "fx:id=\"inputTimeHours\" was not injected: check your FXML file 'HomeMain.fxml'.";
        assert inputTimeMinutes != null : "fx:id=\"inputTimeMinutes\" was not injected: check your FXML file 'HomeMain.fxml'.";
        assert outputPrintingCost != null : "fx:id=\"outputPrintingCost\" was not injected: check your FXML file 'HomeMain.fxml'.";

        ObservableList<String> filamentTypes = FXCollections.observableArrayList("ABS", "PLA", "PTEG");
        this.inputFilamentType.setItems(filamentTypes);
        this.inputFilamentType.getSelectionModel().selectFirst();

        SpinnerValueFactory<Integer> daysValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 7, 0);
        this.inputTimeDays.setValueFactory(daysValueFactory);

        SpinnerValueFactory<Integer> hoursValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 23, 0);
        this.inputTimeHours.setValueFactory(hoursValueFactory);

        SpinnerValueFactory<Integer> minutesValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 59, 0);
        this.inputTimeMinutes.setValueFactory(minutesValueFactory);

    }

}
