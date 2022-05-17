package com.example.sparks.nonentity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.sparks.enumerable.PoliticalGroup;

public class BoxAndWhiskerResponse {
    private Map<PoliticalGroup,List<BoxAndWhiskerData>> boxAndWhiskerData;
    private Map<PoliticalGroup,List<Double>> districtData;
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
     * @return Map<PoliticalGroup,List<Double>> return the districtData
     */
    public Map<PoliticalGroup,List<Double>> getDistrictData() {
        return districtData;
    }

    /**
     * @param districtData the districtData to set
     */
    public void setDistrictData(Map<PoliticalGroup,List<Double>> districtData) {
        this.districtData = districtData;
    }

    /**
     * calculates the mean squared error for the district data from the box and whisker mean
     */
    public void calculateError() {
        // initalize error object
        this.error = new HashMap<PoliticalGroup,Double>();
        // calculate error for each demographic
        for (PoliticalGroup group: PoliticalGroup.values()) {
            // skip total population demographic
            if (group == PoliticalGroup.TOTAL_POPULATION || group == PoliticalGroup.DEMOCRAT
            || group == PoliticalGroup.REPUBLICAN) {
                continue;
            }

            // find the sum of the squares of the differences between district and box and whisker mean
            double tempError = 0;
            for (int i = 0; i < this.districtData.get(group).size(); i++) {
                double mean = this.boxAndWhiskerData.get(group).get(i).getMean();
                double currDistrict = ((double)this.districtData.get(group).get(i))
                    / ((double) this.districtData.get(PoliticalGroup.TOTAL_POPULATION).get(i));
                tempError += Math.pow(mean - currDistrict, 2);
            }

            // store in error Object
            this.error.put(group, tempError);
        }
    }
}
