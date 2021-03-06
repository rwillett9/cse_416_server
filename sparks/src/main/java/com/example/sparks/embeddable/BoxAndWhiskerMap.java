package com.example.sparks.embeddable;

import javax.persistence.Embeddable;

import com.example.sparks.enumerable.PoliticalGroup;

@Embeddable
public class BoxAndWhiskerMap {
    private PoliticalGroup politicalGroup;
    private double minimum;
    private double lowerQuartile;
    private double median;
    private double upperQuartile;
    private double maximum;
    private double mean;

    /**
     * @return PoliticalGroup return the politicalGroup
     */
    public PoliticalGroup getPoliticalGroup() {
        return politicalGroup;
    }

    /**
     * @param politicalGroup the politicalGroup to set
     */
    public void setPoliticalGroup(PoliticalGroup politicalGroup) {
        this.politicalGroup = politicalGroup;
    }


    /**
     * @return double return the minimum
     */
    public double getMinimum() {
        return minimum;
    }

    /**
     * @param minimum the minimum to set
     */
    public void setMinimum(double minimum) {
        this.minimum = minimum;
    }

    /**
     * @return double return the lowerQuartile
     */
    public double getLowerQuartile() {
        return lowerQuartile;
    }

    /**
     * @param lowerQuartile the lowerQuartile to set
     */
    public void setLowerQuartile(double lowerQuartile) {
        this.lowerQuartile = lowerQuartile;
    }

    /**
     * @return double return the median
     */
    public double getMedian() {
        return median;
    }

    /**
     * @param median the median to set
     */
    public void setMedian(double median) {
        this.median = median;
    }

    /**
     * @return double return the upperQuartile
     */
    public double getUpperQuartile() {
        return upperQuartile;
    }

    /**
     * @param upperQuartile the upperQuartile to set
     */
    public void setUpperQuartile(double upperQuartile) {
        this.upperQuartile = upperQuartile;
    }

    /**
     * @return double return the maximum
     */
    public double getMaximum() {
        return maximum;
    }

    /**
     * @param maximum the maximum to set
     */
    public void setMaximum(double maximum) {
        this.maximum = maximum;
    }

    /**
     * @return double return the mean
     */
    public double getMean() {
        return mean;
    }

    /**
     * @param mean the mean to set
     */
    public void setMean(double mean) {
        this.mean = mean;
    }
}
