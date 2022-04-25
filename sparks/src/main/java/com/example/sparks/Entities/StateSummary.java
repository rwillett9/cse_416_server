package com.example.sparks.Entities;

import java.util.Map;

public class StateSummary {
    private Map<Long, String> districtPlanIdToNameMap;

    /**
     * @return Map<Long, String> return the districtPlanIdToNameMap
     */
    public Map<Long, String> getDistrictPlanIdToNameMap() {
        return districtPlanIdToNameMap;
    }

    /**
     * @param districtPlanIdToNameMap the districtPlanIdToNameMap to set
     */
    public void setDistrictPlanIdToNameMap(Map<Long, String> districtPlanIdToNameMap) {
        this.districtPlanIdToNameMap = districtPlanIdToNameMap;
    }

}
