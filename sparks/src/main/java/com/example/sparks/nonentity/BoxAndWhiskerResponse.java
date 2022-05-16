package com.example.sparks.nonentity;

import java.util.List;
import java.util.Map;

import com.example.sparks.enumerable.PoliticalGroup;

public class BoxAndWhiskerResponse {
    private Map<PoliticalGroup,List<BoxAndWhiskerData>> boxAndWhiskerData;
    private Map<PoliticalGroup,List<Integer>> districtData;
    private Map<PoliticalGroup,Double> error;

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

    /**
     * @return Map<PoliticalGroup,Double> return the error
     */
    public Map<PoliticalGroup,Double> getError() {
        return error;
    }

    /**
     * @param error the error to set
     */
    public void setError(Map<PoliticalGroup,Double> error) {
        this.error = error;
    }

    /**
     * calculates the mean squared error for the district data from the box and whisker mean
     */
    public void calculateError() {
        // calculate error for each demographic
        for (PoliticalGroup group: PoliticalGroup.values()) {
            // skip total population demographic
            if (group != PoliticalGroup.TOTAL_POPULATION) {
                continue;
            }

            // find the sum of the squares of the differences between district and box and whisker median
            double error = 0;
            for (int i = 0; i < this.districtData.get(group).size(); i++) {
                double median = this.boxAndWhiskerData.get(group).get(i).getMedian();
                double currDistrict = this.districtData.get(group).get(i);
                error += Math.pow(median - currDistrict, 2);
            }

            // store in error Object
            this.error.put(group, error);
        }
    }
}
