package com.iti.request;

/**
 * Created by eltntawy on 17/04/15.
 */
public class Location {


    private String x;
    private String y;
    private String radius;


    public Location() {
    }

    public Location(String x, String y) {
        this.x = x;
        this.y = y;
    }

    public Location(String x, String y, String radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }

    public String getRadius() {
        return radius;
    }

    public void setRadius(String radius) {
        this.radius = radius;
    }
}
