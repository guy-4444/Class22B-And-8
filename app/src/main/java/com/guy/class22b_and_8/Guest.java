package com.guy.class22b_and_8;

public class Guest {

    private String id = "";
    private String name = "";
    private Car car = new Car();

    public Guest() { }

    public String getId() {
        return id;
    }

    public Guest setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Guest setName(String name) {
        this.name = name;
        return this;
    }

    public Car getCar() {
        return car;
    }

    public Guest setCar(Car car) {
        this.car = car;
        return this;
    }
}
