package com.example.calculator_2;

public class Calculator {

    private final Double materialLength;
    private final Double printTime;
    private final String filamentType;

    private double filamentGramCost = 0.0;
    private double density = 0.0;
    private double diameter = 0.0;
    private int defaultCost = 50;
    private double hourlyRate = 0.0;
    private double markUp = 10.0;


    public Calculator(double materialLength, double printTime, String filamentType){
        this.materialLength = materialLength;
        this.printTime = printTime;
        this.filamentType = filamentType;
    }

    public int printCost(){
        setProperties();
        double pi = Math.PI;
        double materialCost = Math.ceil(density * pi * Math.pow(diameter / 2, 2) * materialLength * filamentGramCost);
        double laborCost = Math.ceil(printTime * hourlyRate);
        int totalCost = (int) Math.ceil ((materialCost + laborCost) * (1 + markUp / 100));
        return Math.max(defaultCost, totalCost);

    }
    public void setProperties(){
        switch (this.filamentType.toLowerCase()){
            case "abs":
                this.filamentGramCost = 1.598;
                this.density = 1.085;
                this.diameter = 1.75;
                break;

            default:
                this.filamentGramCost = 2;
                this.density = 1;
                this.diameter = 1.75;
                break;
        }
    }
    public void setDefaultCost(int newCost){
        this.defaultCost = newCost;
    }
    public void setHourlyRate(Double newHourRate){
        this.hourlyRate = newHourRate;
    }
}
