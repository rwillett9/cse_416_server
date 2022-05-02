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
import javax.persistence.OneToMany;

import com.example.sparks.embeddable.BoxAndWhiskerMap;
import com.example.sparks.embeddable.Coordinate;
import com.example.sparks.embeddable.MajorityMinorityMap;
import com.example.sparks.embeddable.RepublicanDemocratSplit;

/**
 * This Entity will store all the data for each state, including geojson data(?)
 */
@Entity
public class State {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "state_id")
    private Long id;

    private String geoJson;

    @OneToMany
    @JoinColumn(name = "state_id")
    private List<DistrictPlan> districtPlans;

    // START SEAWULF DATA
    @ElementCollection
    @CollectionTable(name = "seawulf_box_and_whisker_data", joinColumns = @JoinColumn(name = "state_id"))
    @Embedded
    private List<BoxAndWhiskerMap> seawulfBoxAndWhiskerMap;

    @ElementCollection
    @CollectionTable(name = "seawulf_majority_minority", joinColumns = @JoinColumn(name = "state_id"))
    @Embedded
    private List<MajorityMinorityMap> seawulfMajorityMinorityMap;

    @ElementCollection
    @CollectionTable(name = "seawulf_republican_democrat_split", joinColumns = @JoinColumn(name = "state_id"))
    @Embedded
    private List<RepublicanDemocratSplit> seawulfRepublicanDemocratSplit;

    @ElementCollection
    @CollectionTable(name = "seawulf_democrat_seat_share", joinColumns = @JoinColumn(name = "state_id"))
    @Embedded
    private List<Coordinate> seawulfDemocratSeatShareData;

    @ElementCollection
    @CollectionTable(name = "seawulf_republican_seat_share", joinColumns = @JoinColumn(name = "state_id"))
    @Embedded
    private List<Coordinate> seawulfRepublicanSeatShareData;
    // END SEAWULF DATA

    private String stateCode;

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
     * @return String return the geoJson
     */
    public String getGeoJson() {
        return geoJson;
    }

    /**
     * @param geoJson the geoJson to set
     */
    public void setGeoJson(String geoJson) {
        this.geoJson = geoJson;
    }

    /**
     * @return String return the stateCode
     */
    public String getStateCode() {
        return stateCode;
    }

    /**
     * @param stateCode the stateCode to set
     */
    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }


    /**
     * @return List<DistrictPlan> return the districtPlans
     */
    public List<DistrictPlan> getDistrictPlans() {
        return districtPlans;
    }

    /**
     * @param districtPlans the districtPlans to set
     */
    public void setDistrictPlans(List<DistrictPlan> districtPlans) {
        this.districtPlans = districtPlans;
    }

    /**
     * @param districtPlanId the id of the plan to retrieve
     * @return DistrictPlan with matching id if it exists, otherwise null
     */
    public DistrictPlan getDistrictPlanById(Long districtPlanId) {
        return districtPlans.stream()
        .filter(plan -> districtPlanId.equals(plan.getId()))
        .findAny()
        .orElse(null);
    }

    /**
     * @return List<BoxAndWhiskerMap> return the seawulfBoxAndWhiskerMap
     */
    public List<BoxAndWhiskerMap> getSeawulfBoxAndWhiskerMap() {
        return seawulfBoxAndWhiskerMap;
    }

    /**
     * @param seawulfBoxAndWhiskerMap the seawulfBoxAndWhiskerMap to set
     */
    public void setSeawulfBoxAndWhiskerMap(List<BoxAndWhiskerMap> seawulfBoxAndWhiskerMap) {
        this.seawulfBoxAndWhiskerMap = seawulfBoxAndWhiskerMap;
    }

    /**
     * @return List<MajorityMinorityMap> return the seawulfMajorityMinorityMap
     */
    public List<MajorityMinorityMap> getSeawulfMajorityMinorityMap() {
        return seawulfMajorityMinorityMap;
    }

    /**
     * @param seawulfMajorityMinorityMap the seawulfMajorityMinorityMap to set
     */
    public void setSeawulfMajorityMinorityMap(List<MajorityMinorityMap> seawulfMajorityMinorityMap) {
        this.seawulfMajorityMinorityMap = seawulfMajorityMinorityMap;
    }

    /**
     * @return List<RepublicanDemocratSplit> return the seawulfRepublicanDemocratSplit
     */
    public List<RepublicanDemocratSplit> getSeawulfRepublicanDemocratSplit() {
        return seawulfRepublicanDemocratSplit;
    }

    /**
     * @param seawulfRepublicanDemocratSplit the seawulfRepublicanDemocratSplit to set
     */
    public void setSeawulfRepublicanDemocratSplit(List<RepublicanDemocratSplit> seawulfRepublicanDemocratSplit) {
        this.seawulfRepublicanDemocratSplit = seawulfRepublicanDemocratSplit;
    }

    /**
     * @return List<Coordinate> return the seawulfDemocratSeatShareData
     */
    public List<Coordinate> getSeawulfDemocratSeatShareData() {
        return seawulfDemocratSeatShareData;
    }

    /**
     * @param seawulfDemocratSeatShareData the seawulfDemocratSeatShareData to set
     */
    public void setSeawulfDemocratSeatShareData(List<Coordinate> seawulfDemocratSeatShareData) {
        this.seawulfDemocratSeatShareData = seawulfDemocratSeatShareData;
    }

    /**
     * @return List<Coordinate> return the seawulfRepublicanSeatShareData
     */
    public List<Coordinate> getSeawulfRepublicanSeatShareData() {
        return seawulfRepublicanSeatShareData;
    }

    /**
     * @param seawulfRepublicanSeatShareData the seawulfRepublicanSeatShareData to set
     */
    public void setSeawulfRepublicanSeatShareData(List<Coordinate> seawulfRepublicanSeatShareData) {
        this.seawulfRepublicanSeatShareData = seawulfRepublicanSeatShareData;
    }

}
