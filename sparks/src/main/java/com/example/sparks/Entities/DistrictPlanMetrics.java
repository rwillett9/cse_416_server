package com.example.sparks.Entities;

import java.util.List;

public class DistrictPlanMetrics {
    private double compactness;
    private List<Long> competitiveDistrictIds;
    private List<Long> democratDistrictIds;
    private String name;
    private int numMinorityMajorityDistricts;
    private double meanPopulationDeviation;
    private List<Long> republicanDistrictIds;

    /**
     * @return double return the compactness
     */
    public double getCompactness() {
        return compactness;
    }

    /**
     * @param compactness the compactness to set
     */
    public void setCompactness(double compactness) {
        this.compactness = compactness;
    }

    /**
     * @return List<Long> return the competitiveDistrictIds
     */
    public List<Long> getCompetitiveDistrictIds() {
        return competitiveDistrictIds;
    }

    /**
     * @param competitiveDistrictIds the competitiveDistrictIds to set
     */
    public void setCompetitiveDistrictIds(List<Long> competitiveDistrictIds) {
        this.competitiveDistrictIds = competitiveDistrictIds;
    }

    /**
     * @return List<Long> return the democratDistrictIds
     */
    public List<Long> getDemocratDistrictIds() {
        return democratDistrictIds;
    }

    /**
     * @param democratDistrictIds the democratDistrictIds to set
     */
    public void setDemocratDistrictIds(List<Long> democratDistrictIds) {
        this.democratDistrictIds = democratDistrictIds;
    }

    /**
     * @return int return the numMinorityMajorityDistricts
     */
    public int getNumMinorityMajorityDistricts() {
        return numMinorityMajorityDistricts;
    }

    /**
     * @param numMinorityMajorityDistricts the numMinorityMajorityDistricts to set
     */
    public void setNumMinorityMajorityDistricts(int numMinorityMajorityDistricts) {
        this.numMinorityMajorityDistricts = numMinorityMajorityDistricts;
    }

    /**
     * @return double return the meanPopulationDeviation
     */
    public double getMeanPopulationDeviation() {
        return meanPopulationDeviation;
    }

    /**
     * @param meanPopulationDeviation the meanPopulationDeviation to set
     */
    public void setMeanPopulationDeviation(double meanPopulationDeviation) {
        this.meanPopulationDeviation = meanPopulationDeviation;
    }

    /**
     * @return List<Long> return the republicanDistrictIds
     */
    public List<Long> getRepublicanDistrictIds() {
        return republicanDistrictIds;
    }

    /**
     * @param republicanDistrictIds the republicanDistrictIds to set
     */
    public void setRepublicanDistrictIds(List<Long> republicanDistrictIds) {
        this.republicanDistrictIds = republicanDistrictIds;
    }


    /**
     * @return String return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

}
