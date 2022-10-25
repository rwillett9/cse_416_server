package com.example.sparks.embeddable;

import javax.persistence.Embeddable;

@Embeddable
public class RepublicanDemocratSplit {
    private int republicanSeats;
    private int democratSeats;
    private int count;

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
