module com.example.calculator {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.calculator_2 to javafx.fxml;
    exports com.example.calculator_2;
}