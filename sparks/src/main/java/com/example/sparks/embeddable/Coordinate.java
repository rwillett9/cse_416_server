package com.example.sparks.embeddable;

import javax.persistence.Embeddable;

@Embeddable
public class Coordinate {
  private double x;
  private double y;

  // setters
  public void setX(double x) { this.x = x; }
  public void setY(double y) { this.y = y; }
  
  // getters
  public double getX() { return this.x; }
  public double getY() { return this.y; }
}