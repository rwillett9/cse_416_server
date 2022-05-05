package com.example.sparks.nonentity;

public class BoxAndWhiskerData {
    private double lowerQuartile;
    private double maximum;
    private double median;
    private double minimum;
    private double upperQuartile;

    public BoxAndWhiskerData() {}

    public BoxAndWhiskerData(
        double lowerQuartile,
        double maximum,
        double median,
        double minimum,
        double upperQuartile
    ) {
        this.lowerQuartile = lowerQuartile;
        this.maximum = maximum;
        this.median = median;
        this.minimum = minimum;
        this.upperQuartile = upperQuartile;
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

}
