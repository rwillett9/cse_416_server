package com.example.sparks.embeddable;

import javax.persistence.Embeddable;

import com.example.sparks.enumerable.PoliticalGroup;

@Embeddable
public class MajorityMinorityMap {
    private PoliticalGroup politicalGroup;
    private int numMajorityMinorityDistricts;
    private int count;

    /**
     * @return PoliticalGroup return the politicalGroup
     */
    public PoliticalGroup getPoliticalGroup() {
        return politicalGroup;
    }

    /**
     * @param politicalGroup the politicalGroup to set
     */
    public void setPoliticalGroup(PoliticalGroup politicalGroup) {
        this.politicalGroup = politicalGroup;
    }

    /**
     * @return int return the numMajorityMinorityDistricts
     */
    public int getNumMajorityMinorityDistricts() {
        return numMajorityMinorityDistricts;
    }

    /**
     * @param numMajorityMinorityDistricts the numMajorityMinorityDistricts to set
     */
    public void setNumMajorityMinorityDistricts(int numMajorityMinorityDistricts) {
        this.numMajorityMinorityDistricts = numMajorityMinorityDistricts;
    }

    /**
     * @return int return the count
     */
    public int getCount() {
        return count;
    }

    /**
     * @param count the count to set
     */
    public void setCount(int count) {
        this.count = count;
    }

}
