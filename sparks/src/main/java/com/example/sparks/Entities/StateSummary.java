package com.example.sparks.Entities;

import java.util.List;
import java.util.Map;

public class StateSummary {
    // @TODO
    private Map<Long, DistrictPlanMetrics> districtPlanIdToMetricsMap;

    /**
     * @return Map<Long, DistrictPlanMetrics> return the districtPlanIdToMetricsMap
     */
    public Map<Long, DistrictPlanMetrics> getDistrictPlanIdToMetricsMap() {
        return districtPlanIdToMetricsMap;
    }

    /**
     * @param districtPlanIdToMetricsMap the districtPlanIdToMetricsMap to set
     */
    public void setDistrictPlanIdToMetricsMap(Map<Long, DistrictPlanMetrics> districtPlanIdToMetricsMap) {
        this.districtPlanIdToMetricsMap = districtPlanIdToMetricsMap;
    }

}
