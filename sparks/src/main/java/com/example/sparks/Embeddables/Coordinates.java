package com.example.sparks.Embeddables;

import javax.persistence.Embeddable;

@Embeddable
public class Coordinates {
  private int x;
  private int y;

  // setters
  public void setX(int x) { this.x = x; }
  public void setY(int y) { this.y = y; }
  
  // getters
  public int getX() { return this.x; }
  public int getY() { return this.y; }
}