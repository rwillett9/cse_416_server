package com.example.sparks.embeddable;

import java.util.List;

import javax.persistence.Embeddable;

@Embeddable
public class SeatShareEmbeddable {
    private double biasAt50;
    private List<Coordinate> democratData;
    private List<Coordinate> republicanData;
    private double responsiveness;
    private double symmetry;

    /**
     * @return double return the biasAt50
     */
    public double getBiasAt50() {
        return biasAt50;
    }

    /**
     * @param biasAt50 the biasAt50 to set
     */
    public void setBiasAt50(double biasAt50) {
        this.biasAt50 = biasAt50;
    }

    /**
     * @return List<Coordinate> return the democratData
     */
    public List<Coordinate> getDemocratData() {
        return democratData;
    }

    /**
     * @param democratData the democratData to set
     */
    public void setDemocratData(List<Coordinate> democratData) {
        this.democratData = democratData;
    }

    /**
     * @return List<Coordinate> return the republicanData
     */
    public List<Coordinate> getRepublicanData() {
        return republicanData;
    }

    /**
     * @param republicanData the republicanData to set
     */
    public void setRepublicanData(List<Coordinate> republicanData) {
        this.republicanData = republicanData;
    }

    /**
     * @return double return the responsiveness
     */
    public double getResponsiveness() {
        return responsiveness;
    }

    /**
     * @param responsiveness the responsiveness to set
     */
    public void setResponsiveness(double responsiveness) {
        this.responsiveness = responsiveness;
    }

    /**
     * @return double return the symmetry
     */
    public double getSymmetry() {
        return symmetry;
    }

    /**
     * @param symmetry the symmetry to set
     */
    public void setSymmetry(double symmetry) {
        this.symmetry = symmetry;
    }

}
