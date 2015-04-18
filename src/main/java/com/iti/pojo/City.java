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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        City city = (City) o;

        if (id != city.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
