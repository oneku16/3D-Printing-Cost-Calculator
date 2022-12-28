package com.example.calculator_2;

public class Calculator {

    private Double length;
    private String time;
    private String filamentType;
    private double filament_gramm_cost = 0.0;
    private double density = 0.0;
    private double diameter = 0.0;
    private final double pi = Math.PI;
    private int defaultCost = 50;


    public Calculator(double length){
        this.length = length;
        this.time = null;
        this.filamentType = "ABS";
    }

    public double printCost(){
        setProperties();
        double materialCost = Math.ceil(density * pi * Math.pow(diameter/2, 2) * length * filament_gramm_cost);
        double laborCost = 0.0;
        return Math.max(defaultCost, materialCost);

    }
    public void setProperties(){
        switch (this.filamentType){
            case "ABS":
                this.filament_gramm_cost = 1.598;
                this.density = 1.085;
                this.diameter = 1.75;
                break;

            default:
                this.filament_gramm_cost = 2;
                this.density = 1;
                this.diameter = 1.75;
                break;
        }
    }
    public void setDefaultCost(int newCost){
        this.defaultCost = newCost;
    }
}
