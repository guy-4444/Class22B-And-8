package com.guy.class22b_and_8;

import java.util.ArrayList;
import java.util.HashMap;

public class Event {

    private String id = "";
    private String name = "";
    private HashMap<String, Table> tables = new HashMap<>();

    public Event() { }

    public String getId() {
        return id;
    }

    public Event setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Event setName(String name) {
        this.name = name;
        return this;
    }

    public HashMap<String, Table> getTables() {
        return tables;
    }

    public Event setTables(HashMap<String, Table> tables) {
        this.tables = tables;
        return this;
    }
}
