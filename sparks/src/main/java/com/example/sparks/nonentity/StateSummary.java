package com.example.sparks.nonentity;

import java.util.List;

public class StateSummary {
    private List<DistrictPlanMetrics> districtPlanMetricsList;

    /**
     * @return List<DistrictPlanMetrics> return the districtPlanMetricsList
     */
    public List<DistrictPlanMetrics> getDistrictPlanMetricsList() {
        return districtPlanMetricsList;
    }

    /**
     * @param districtPlanMetricsList the districtPlanMetricsList to set
     */
    public void setDistrictPlanMetricsList(List<DistrictPlanMetrics> districtPlanMetricsList) {
        this.districtPlanMetricsList = districtPlanMetricsList;
    }

}
