package com.example.sparks.embeddable;

import javax.persistence.Embeddable;

@Embeddable
public class Coordinate{
    private double x;
    private double y;

    /**
     * default constructor
     */
    public Coordinate() {}

    /**
     * Overloaded constructor
     * @param x
     * @param y
     */
    public Coordinate(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * @return double return the x
     */
    public double getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * @return double return the y
     */
    public double getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(double y) {
        this.y = y;
    }

}