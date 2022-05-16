package com.example.sparks.nonentity;

import java.util.List;
import java.util.Map;

import com.example.sparks.enumerable.PoliticalGroup;

public class DistrictPlanMetrics {
    private double compactness;
    private double efficiencyGap;
    private Long id;
    private List<Long> incumbentSafeDistricts;
    private String name;
    private double meanPopulationDeviation;
    private Map<Long, PoliticalGroup> majorityMinorityDistrictsMap;
    private Map<Long, PoliticalGroup> politicalLeaningMap;

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
     * @return Map<Long, PoliticalGroup> return the majorityMinorityDistrictsMap
     */
    public Map<Long, PoliticalGroup> getMajorityMinorityDistrictsMap() {
        return majorityMinorityDistrictsMap;
    }

    /**
     * @param majorityMinorityDistrictsMap the majorityMinorityDistrictsMap to set
     */
    public void setMajorityMinorityDistrictsMap(Map<Long, PoliticalGroup> majorityMinorityDistrictsMap) {
        this.majorityMinorityDistrictsMap = majorityMinorityDistrictsMap;
    }

    /**
     * @return Map<Long, PoliticalGroup> return the politicalLeaningMap
     */
    public Map<Long, PoliticalGroup> getPoliticalLeaningMap() {
        return politicalLeaningMap;
    }

    /**
     * @param politicalLeaningMap the politicalLeaningMap to set
     */
    public void setPoliticalLeaningMap(Map<Long, PoliticalGroup> politicalLeaningMap) {
        this.politicalLeaningMap = politicalLeaningMap;
    }

    /**
     * @return List<Long> return the incumbentSafeDistricts
     */
    public List<Long> getIncumbentSafeDistricts() {
        return incumbentSafeDistricts;
    }

    /**
     * @param incumbentSafeDistricts the incumbentSafeDistricts to set
     */
    public void setIncumbentSafeDistricts(List<Long> incumbentSafeDistricts) {
        this.incumbentSafeDistricts = incumbentSafeDistricts;
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
}
