package com.example.sparks.embeddable;

import javax.persistence.Embeddable;

@Embeddable
public class CombinedMajorityMinorityMap {
    private int numCombinedMajorityMinorityDistricts;
    private int count;

    /**
     * @return int return the numCombinedMajorityMinorityDistricts
     */
    public int getNumCombinedMajorityMinorityDistricts() {
        return numCombinedMajorityMinorityDistricts;
    }

    /**
     * @param numCombinedMajorityMinorityDistricts the numCombinedMajorityMinorityDistricts to set
     */
    public void setNumCombinedMajorityMinorityDistricts(int numCombinedMajorityMinorityDistricts) {
        this.numCombinedMajorityMinorityDistricts = numCombinedMajorityMinorityDistricts;
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
