package com.guy.class22b_and_8;

import java.util.ArrayList;
import java.util.HashMap;

public class Table {

    private int number = 0;
    private HashMap<String, Guest> guests = new HashMap<>();

    public Table() { }

    public int getNumber() {
        return number;
    }

    public Table setNumber(int number) {
        this.number = number;
        return this;
    }

    public HashMap<String, Guest> getGuests() {
        return guests;
    }

    public Table setGuests(HashMap<String, Guest> guests) {
        this.guests = guests;
        return this;
    }
}
