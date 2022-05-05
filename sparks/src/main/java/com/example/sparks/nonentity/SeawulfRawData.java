package com.example.sparks.nonentity;

import java.util.List;

import com.example.sparks.embeddable.BoxAndWhiskerMap;
import com.example.sparks.embeddable.Coordinate;
import com.example.sparks.embeddable.MajorityMinorityMap;
import com.example.sparks.embeddable.RepublicanDemocratSplit;

public class SeawulfRawData {
    private List<BoxAndWhiskerMap> seawulfBoxAndWhiskerMap;
    private List<MajorityMinorityMap> seawulfMajorityMinorityMap;
    private List<RepublicanDemocratSplit> seawulfRepublicanDemocratSplit;
    private List<Coordinate> seawulfDemocratSeatShareData;
    private List<Coordinate> seawulfRepublicanSeatShareData;

    /**
     * @return List<BoxAndWhiskerMap> return the seawulfBoxAndWhiskerMap
     */
    public List<BoxAndWhiskerMap> getSeawulfBoxAndWhiskerMap() {
        return seawulfBoxAndWhiskerMap;
    }

    /**
     * @param seawulfBoxAndWhiskerMap the seawulfBoxAndWhiskerMap to set
     */
    public void setSeawulfBoxAndWhiskerMap(List<BoxAndWhiskerMap> seawulfBoxAndWhiskerMap) {
        this.seawulfBoxAndWhiskerMap = seawulfBoxAndWhiskerMap;
    }

    /**
     * @return List<MajorityMinorityMap> return the seawulfMajorityMinorityMap
     */
    public List<MajorityMinorityMap> getSeawulfMajorityMinorityMap() {
        return seawulfMajorityMinorityMap;
    }

    /**
     * @param seawulfMajorityMinorityMap the seawulfMajorityMinorityMap to set
     */
    public void setSeawulfMajorityMinorityMap(List<MajorityMinorityMap> seawulfMajorityMinorityMap) {
        this.seawulfMajorityMinorityMap = seawulfMajorityMinorityMap;
    }

    /**
     * @return List<RepublicanDemocratSplit> return the seawulfRepublicanDemocratSplit
     */
    public List<RepublicanDemocratSplit> getSeawulfRepublicanDemocratSplit() {
        return seawulfRepublicanDemocratSplit;
    }

    /**
     * @param seawulfRepublicanDemocratSplit the seawulfRepublicanDemocratSplit to set
     */
    public void setSeawulfRepublicanDemocratSplit(List<RepublicanDemocratSplit> seawulfRepublicanDemocratSplit) {
        this.seawulfRepublicanDemocratSplit = seawulfRepublicanDemocratSplit;
    }

    /**
     * @return List<Coordinate> return the seawulfDemocratSeatShareData
     */
    public List<Coordinate> getSeawulfDemocratSeatShareData() {
        return seawulfDemocratSeatShareData;
    }

    /**
     * @param seawulfDemocratSeatShareData the seawulfDemocratSeatShareData to set
     */
    public void setSeawulfDemocratSeatShareData(List<Coordinate> seawulfDemocratSeatShareData) {
        this.seawulfDemocratSeatShareData = seawulfDemocratSeatShareData;
    }

    /**
     * @return List<Coordinate> return the seawulfRepublicanSeatShareData
     */
    public List<Coordinate> getSeawulfRepublicanSeatShareData() {
        return seawulfRepublicanSeatShareData;
    }

    /**
     * @param seawulfRepublicanSeatShareData the seawulfRepublicanSeatShareData to set
     */
    public void setSeawulfRepublicanSeatShareData(List<Coordinate> seawulfRepublicanSeatShareData) {
        this.seawulfRepublicanSeatShareData = seawulfRepublicanSeatShareData;
    }

}
