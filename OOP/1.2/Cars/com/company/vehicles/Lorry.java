package com.company.vehicles;

import com.company.professions.Driver;
import com.company.details.Engine;
public class Lorry extends Car {
    private double carryingCapacity;
    public  Lorry(String carBrand, String carClass, double weight, Engine engine, Driver driver, double carryingCapacity){
        super(carBrand, carClass, weight, engine, driver);
        setCarryingCapacity(carryingCapacity);
    }

    public double getCarryingCapacity() {
        return carryingCapacity;
    }

    public void setCarryingCapacity(double carryingCapacity) {
        this.carryingCapacity = carryingCapacity;
    }
}
