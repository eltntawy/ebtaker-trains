package com.iti.pojo;

/**
 * Created by eltntawy on 18/04/15.
 */
public class City {
    private int id;
    private String name;
    private String time;

    public City(int id, String name, String time) {
        this.id = id;
        this.name = name;
    }

    public City() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
