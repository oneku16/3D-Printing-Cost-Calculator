package com.example.calculator_2;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Checker {
    private String dateFormat = "dd-MM-yyyy";

    public boolean isValid(String dateStr) {
        DateFormat studentDate = new SimpleDateFormat(this.dateFormat);
        studentDate.setLenient(false);
        try {
            studentDate.parse(dateStr);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    public void setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
    }
}
