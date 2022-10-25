package com.example.sparks.embeddable;

import javax.persistence.Embeddable;

@Embeddable
public class HistogramMap {
    private double rangeMinimum;
    private double rangeMaximum;
    private int count;

    /**
     * @return int return the count
     */
    public int getCount() {
        return count;
    }

    /**
     * @param count the count to set
     */
    public void setCount(int count) {
        this.count = count;
    }

    /**
     * @return double return the rangeMinimum
     */
    public double getRangeMinimum() {
        return rangeMinimum;
    }

    /**
     * @param rangeMinimum the rangeMinimum to set
     */
    public void setRangeMinimum(double rangeMinimum) {
        this.rangeMinimum = rangeMinimum;
    }

    /**
     * @return double return the rangeMaximum
     */
    public double getRangeMaximum() {
        return rangeMaximum;
    }

    /**
     * @param rangeMaximum the rangeMaximum to set
     */
    public void setRangeMaximum(double rangeMaximum) {
        this.rangeMaximum = rangeMaximum;
    }

}
