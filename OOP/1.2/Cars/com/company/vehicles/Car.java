package com.company.vehicles;

import com.company.details.Engine;
import com.company.professions.Driver;
public class Car {
    private String carBrand, carClass;
    private double weight;
    private Engine engine;
    private Driver driver;

    public Car(String carBrand, String carClass, double weight, Engine engine, Driver driver){
        setCarBrand(carBrand);
        setCarClass(carClass);
        setWeight(weight);
        setEngine(engine);
        setDriver(driver);
    }

    public void start(){
        System.out.println("Let's go");
    }

    public void stop(){
        System.out.println("Let's stop");
    }

    public void turnRight(){
        System.out.println("Turn right");
    }
    public void turnLeft(){
        System.out.println("Turn left");
    }

    @Override
    public String toString() {
        return "Brand: " + carBrand +
                "\nClass: " + carClass +
                "\nWeight: " + weight +
                "\nDriver's name: " + driver.getFullName() +
                "\nExperience of driver: " + driver.getExperience() +
                "\nEngine power: " + engine.getPower() +
                "\nManufacturer: " + engine.getManufacturer();
    }



    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getCarClass() {
        return carClass;
    }

    public void setCarClass(String carClass) {
        this.carClass = carClass;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }
}
