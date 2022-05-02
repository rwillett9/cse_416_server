package com.example.sparks.nonentity;

import java.util.List;
import java.util.Map;

import com.example.sparks.enumerable.PoliticalGroup;

/**
 * Contains the different calculated values for the 10,000 randomly generated districting
 * plans by the SeaWulf supercomputer
 */
public class SeawulfSummary {
    private Map<PoliticalGroup,List<BoxAndWhiskerData>> boxAndWhiskerData;
    private Map<PoliticalGroup, Map<Integer, Integer>> majorityMinorityRange;
    private Map<String, Integer> republicanDemocratSplit;
    private List<SeatShareData> seatShareDataList;

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
     * @return Map<String, Integer> return the republicanDemocratSplit
     */
    public Map<String, Integer> getRepublicanDemocratSplit() {
        return republicanDemocratSplit;
    }

    /**
     * @param republicanDemocratSplit the republicanDemocratSplit to set
     */
    public void setRepublicanDemocratSplit(Map<String, Integer> republicanDemocratSplit) {
        this.republicanDemocratSplit = republicanDemocratSplit;
    }

    /**
     * @return List<SeatShareData> return the seatShareDataList
     */
    public List<SeatShareData> getSeatShareDataList() {
        return seatShareDataList;
    }

    /**
     * @param seatShareDataList the seatShareDataList to set
     */
    public void setSeatShareDataList(List<SeatShareData> seatShareDataList) {
        this.seatShareDataList = seatShareDataList;
    }

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

}
