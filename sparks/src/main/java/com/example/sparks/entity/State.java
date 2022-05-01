package com.example.sparks.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 * This Entity will store all the data for each state, including geojson data(?)
 */
@Entity
public class State {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "state_id")
    private Long id;

    @Column(columnDefinition = "json")
    private String geoJson;

    @OneToMany
    @JoinColumn(name = "state_id")
    private List<DistrictPlan> districtPlans;

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

}
