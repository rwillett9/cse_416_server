package com.example.sparks.entity;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import com.example.sparks.embeddable.Coordinate;

/**
 * This Entity will store all the data for each District Plan
 */
@Entity
public class DistrictPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "district_plan_id")
    private Long id;

    private double compactness;

    @ElementCollection
    @CollectionTable(name = "competitive_district_id", joinColumns = @JoinColumn(name = "district_plan_id"))
    private List<Long> competitiveDistrictIds;

    @ElementCollection
    @CollectionTable(name = "democrat_district_id", joinColumns = @JoinColumn(name = "district_plan_id"))
    private List<Long> democratDistrictIds;
    
    // @TODO: setup districts



    private double efficiencyGap;
    private double fairness;
    private double meanPopulationDeviation;
    private String name;

    // @TODO look into this
    private int numCompetitiveDistricts;

    // @TODO needs to be indexed by minority
    private int numMinorityMajorityDistricts;

    @ElementCollection
    @CollectionTable(name = "republican_district_id", joinColumns = @JoinColumn(name = "district_plan_id"))
    private List<Long> republicanDistrictIds;

    @Embedded
    @ElementCollection
    @CollectionTable(name = "district_plan_dem_coordinate", joinColumns = @JoinColumn(name = "district_plan_id"))
    private List<Coordinate> seatShareDemocratData;

    @Embedded
    @ElementCollection
    @CollectionTable(name = "district_plan_rep_coordinate", joinColumns = @JoinColumn(name = "district_plan_id"))
    private List<Coordinate> seatShareRepublicanData;

    private double seatShareBiasAt50;
    private double seatShareSymmetry;
    private double seatShareResponsiveness;

    /**
     * @return Long return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

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
     * @return double return the efficiencyGap
     */
    public double getEfficiencyGap() {
        return efficiencyGap;
    }

    /**
     * @param efficiencyGap the efficiencyGap to set
     */
    public void setEfficiencyGap(double efficiencyGap) {
        this.efficiencyGap = efficiencyGap;
    }

    /**
     * @return double return the fairness
     */
    public double getFairness() {
        return fairness;
    }

    /**
     * @param fairness the fairness to set
     */
    public void setFairness(double fairness) {
        this.fairness = fairness;
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

    /**
     * @return int return the numCompetitiveDistricts
     */
    public int getNumCompetitiveDistricts() {
        return numCompetitiveDistricts;
    }

    /**
     * @param numCompetitiveDistricts the numCompetitiveDistricts to set
     */
    public void setNumCompetitiveDistricts(int numCompetitiveDistricts) {
        this.numCompetitiveDistricts = numCompetitiveDistricts;
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
     * @return List<Coordinate> return the seatShareDemocratData
     */
    public List<Coordinate> getSeatShareDemocratData() {
        return seatShareDemocratData;
    }

    /**
     * @param seatShareDemocratData the seatShareDemocratData to set
     */
    public void setSeatShareDemocratData(List<Coordinate> seatShareDemocratData) {
        this.seatShareDemocratData = seatShareDemocratData;
    }

    /**
     * @return List<Coordinate> return the seatShareRepublicanData
     */
    public List<Coordinate> getSeatShareRepublicanData() {
        return seatShareRepublicanData;
    }

    /**
     * @param seatShareRepublicanData the seatShareRepublicanData to set
     */
    public void setSeatShareRepublicanData(List<Coordinate> seatShareRepublicanData) {
        this.seatShareRepublicanData = seatShareRepublicanData;
    }

    /**
     * @return double return the seatShareBiasAt50
     */
    public double getSeatShareBiasAt50() {
        return seatShareBiasAt50;
    }

    /**
     * @param seatShareBiasAt50 the seatShareBiasAt50 to set
     */
    public void setSeatShareBiasAt50(double seatShareBiasAt50) {
        this.seatShareBiasAt50 = seatShareBiasAt50;
    }

    /**
     * @return double return the seatShareSymmetry
     */
    public double getSeatShareSymmetry() {
        return seatShareSymmetry;
    }

    /**
     * @param seatShareSymmetry the seatShareSymmetry to set
     */
    public void setSeatShareSymmetry(double seatShareSymmetry) {
        this.seatShareSymmetry = seatShareSymmetry;
    }

    /**
     * @return double return the seatShareResponsiveness
     */
    public double getSeatShareResponsiveness() {
        return seatShareResponsiveness;
    }

    /**
     * @param seatShareResponsiveness the seatShareResponsiveness to set
     */
    public void setSeatShareResponsivness(double seatShareResponsiveness) {
        this.seatShareResponsiveness = seatShareResponsiveness;
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
     * @return a DistrictPlanMetrics Object
     */
    public DistrictPlanMetrics createMetrics() {
        DistrictPlanMetrics metrics = new DistrictPlanMetrics();
        metrics.setCompactness(this.getCompactness());
        metrics.setCompetitiveDistrictIds(this.getCompetitiveDistrictIds());
        metrics.setDemocratDistrictIds(this.getDemocratDistrictIds());
        metrics.setMeanPopulationDeviation(this.getMeanPopulationDeviation());
        metrics.setNumMinorityMajorityDistricts(this.getNumMinorityMajorityDistricts());
        metrics.setRepublicanDistrictIds(this.getRepublicanDistrictIds());
        metrics.setName(this.getName());
        return metrics;
    }

    /**
     * @return a SeatShareData Object
     */
    public SeatShareData createSeatShare() {
        SeatShareData seatShareData = new SeatShareData();
        seatShareData.setBiasAt50(this.getSeatShareBiasAt50());
        seatShareData.setDemocratData(this.getSeatShareDemocratData());
        seatShareData.setRepublicanData(this.getSeatShareRepublicanData());
        seatShareData.setResponsiveness(this.getSeatShareResponsiveness());
        seatShareData.setSymmetry(this.getSeatShareSymmetry());
        return seatShareData;
    }

}
