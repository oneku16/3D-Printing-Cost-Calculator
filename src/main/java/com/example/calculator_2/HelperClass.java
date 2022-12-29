package com.example.calculator_2;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class HelperClass {
    private String dateFormat = "yyyy-MM-dd";
    private final Double minuteRatio = 1.6666666666666667;

    public boolean isValidDate(String dateStr) {
        DateFormat studentDate = new SimpleDateFormat(this.dateFormat);
        studentDate.setLenient(false);
        try {
            studentDate.parse(dateStr);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }
    public double properPrintTime(int days, int hours, int minutes){
        Double convertedMinutes = (minutes * minuteRatio) / 100;
        int convertedDays = days * 24;
        return convertedMinutes + convertedDays + hours;
    }

    public void setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
    }
}


