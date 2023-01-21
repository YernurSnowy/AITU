package com.company.professions;

public class Person {
    private int age;
    private String fullName;

    public Person(String fullName){
        setFullName(fullName);
    }

    public Person(int age, String fullName){
        this(fullName);
        setAge(age);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
