package com.company.details;

public class Engine {
    private double power;
    private String manufacturer;

    public Engine(double power, String manufacturer){
        setManufacturer(manufacturer);
        setPower(power);
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
}
