package com.example.sparks.Entities;

import java.util.List;
import java.util.Map;

public class StateSummary {
    // @TODO
    // private Map<Long, String> districtPlanIdToNameMap;
    private List<DistrictPlanMetrics> districtPlanMetrics;

    /**
     * @return List<DistrictPlanMetrics> return the districtPlanMetrics
     */
    public List<DistrictPlanMetrics> getDistrictPlanMetrics() {
        return districtPlanMetrics;
    }

    /**
     * @param districtPlanMetrics the districtPlanMetrics to set
     */
    public void setDistrictPlanMetrics(List<DistrictPlanMetrics> districtPlanMetrics) {
        this.districtPlanMetrics = districtPlanMetrics;
    }

}
