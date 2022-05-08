package com.guy.class22b_and_8;

public class Car {

    public enum TYPE {
        SEDAN,
        SUV,
        MINI
    }

    private String license = "";
    private String color = "";
    private TYPE type = TYPE.SEDAN;

    public Car() { }

    public String getLicense() {
        return license;
    }

    public Car setLicense(String license) {
        this.license = license;
        return this;
    }

    public String getColor() {
        return color;
    }

    public Car setColor(String color) {
        this.color = color;
        return this;
    }

    public TYPE getType() {
        return type;
    }

    public Car setType(TYPE type) {
        this.type = type;
        return this;
    }
}
