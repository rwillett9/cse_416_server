package com.example.sparks.nonentity;

import java.util.List;
import java.util.Map;

import com.example.sparks.embeddable.CombinedMajorityMinorityMap;
import com.example.sparks.embeddable.RepublicanDemocratSplit;
import com.example.sparks.enumerable.PoliticalGroup;

/**
 * Contains the different calculated values for the 10,000 randomly generated districting
 * plans by the SeaWulf supercomputer
 */
public class SeawulfSummary {
    private List<CombinedMajorityMinorityMap> combinedMajorityMinorityMap;
    private Map<PoliticalGroup, Map<Integer, Integer>> majorityMinorityRange;
    private List<RepublicanDemocratSplit> republicanDemocratSplit;

    /**
     * @return Map<PoliticalGroup, Map<Integer, Integer>> return the majorityMinorityRange
     */
    public Map<PoliticalGroup, Map<Integer, Integer>> getMajorityMinorityRange() {
        return majorityMinorityRange;
    }

    /**
     * @param majorityMinorityRange the majorityMinorityRange to set
     */
    public void setMajorityMinorityRange(Map<PoliticalGroup, Map<Integer, Integer>> majorityMinorityRange) {
        this.majorityMinorityRange = majorityMinorityRange;
    }


    /**
     * @return List<RepublicanDemocratSplit> return the republicanDemocratSplit
     */
    public List<RepublicanDemocratSplit> getRepublicanDemocratSplit() {
        return republicanDemocratSplit;
    }

    /**
     * @param republicanDemocratSplit the republicanDemocratSplit to set
     */
    public void setRepublicanDemocratSplit(List<RepublicanDemocratSplit> republicanDemocratSplit) {
        this.republicanDemocratSplit = republicanDemocratSplit;
    }

    /**
     * @return List<CombinedMajorityMinorityMap> return the combinedMajorityMinorityMap
     */
    public List<CombinedMajorityMinorityMap> getCombinedMajorityMinorityMap() {
        return combinedMajorityMinorityMap;
    }

    /**
     * @param combinedMajorityMinorityMap the combinedMajorityMinorityMap to set
     */
    public void setCombinedMajorityMinorityMap(List<CombinedMajorityMinorityMap> combinedMajorityMinorityMap) {
        this.combinedMajorityMinorityMap = combinedMajorityMinorityMap;
    }

}
