package com.iti.pojo;

/**
 * Created by eltntawy on 18/04/15.
 */
public class City {
    private String id;
    private String name;
    private String time;

    public City(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public City(String id, String name, String time) {
        this.id = id;
        this.name = name;
        this.time = time;
    }

    public City() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

        if (id != null ? !id.equals(city.id) : city.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
