package com.company.vehicles;

import com.company.professions.Driver;
import com.company.details.Engine;
public class SportCar extends Car {
    private double topSpeed;
    public SportCar(String carBrand, String carClass, double weight, Engine engine, Driver driver, double topSpeed){
        super(carBrand, carClass, weight, engine, driver);
        setTopSpeed(topSpeed);
    }

    public double getTopSpeed() {
        return topSpeed;
    }

    public void setTopSpeed(double topSpeed) {
        this.topSpeed = topSpeed;
    }
}
