package com.company.professions;

public class Driver extends Person {
    private int experience;

    public Driver(String fullName, int experience){
        super(fullName);
        setExperience(experience);
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }
}
