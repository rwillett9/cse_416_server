package com.example.sparks.embeddable;

import javax.persistence.Embeddable;

import com.example.sparks.enumerable.PoliticalGroup;

@Embeddable
public class RepublicanDemocratSplit {
    private PoliticalGroup politicalGroup;
    private int republicanSeats;
    private int democratSeats;
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
     * @return int return the republicanSeats
     */
    public int getRepublicanSeats() {
        return republicanSeats;
    }

    /**
     * @param republicanSeats the republicanSeats to set
     */
    public void setRepublicanSeats(int republicanSeats) {
        this.republicanSeats = republicanSeats;
    }

    /**
     * @return int return the democratSeats
     */
    public int getDemocratSeats() {
        return democratSeats;
    }

    /**
     * @param democratSeats the democratSeats to set
     */
    public void setDemocratSeats(int democratSeats) {
        this.democratSeats = democratSeats;
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
