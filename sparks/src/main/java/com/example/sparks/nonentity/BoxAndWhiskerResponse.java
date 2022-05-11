package com.example.sparks.nonentity;

import java.util.List;
import java.util.Map;

import com.example.sparks.enumerable.PoliticalGroup;

public class BoxAndWhiskerResponse {
    private Map<PoliticalGroup,List<BoxAndWhiskerData>> boxAndWhiskerData;
    private Map<PoliticalGroup,List<Integer>> districtData;

    /**
     * @return Map<PoliticalGroup,List<BoxAndWhiskerData>> return the boxAndWhiskerData
     */
    public Map<PoliticalGroup,List<BoxAndWhiskerData>> getBoxAndWhiskerData() {
        return boxAndWhiskerData;
    }

    /**
     * @param boxAndWhiskerData the boxAndWhiskerData to set
     */
    public void setBoxAndWhiskerData(Map<PoliticalGroup,List<BoxAndWhiskerData>> boxAndWhiskerData) {
        this.boxAndWhiskerData = boxAndWhiskerData;
    }

    /**
     * @return Map<PoliticalGroup,List<Integer>> return the districtData
     */
    public Map<PoliticalGroup,List<Integer>> getDistrictData() {
        return districtData;
    }

    /**
     * @param districtData the districtData to set
     */
    public void setDistrictData(Map<PoliticalGroup,List<Integer>> districtData) {
        this.districtData = districtData;
    }

}
