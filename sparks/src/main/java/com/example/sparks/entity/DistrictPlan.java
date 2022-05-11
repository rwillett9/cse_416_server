package com.example.sparks.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.example.sparks.embeddable.Coordinate;
import com.example.sparks.enumerable.PoliticalGroup;
import com.example.sparks.nonentity.DistrictPlanMetrics;
import com.example.sparks.nonentity.SeatShareData;

/**
 * This Entity will store all the data for each District Plan
 */
@Entity
public class DistrictPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "district_plan_id")
    private Long id;

    private double compactness;

    @ElementCollection
    @CollectionTable(name = "competitive_district_id", joinColumns = @JoinColumn(name = "district_plan_id"))
    private List<Long> competitiveDistrictIds;

    @ElementCollection
    @CollectionTable(name = "democrat_district_id", joinColumns = @JoinColumn(name = "district_plan_id"))
    private List<Long> democratDistrictIds;

    @OneToMany
    @JoinColumn(name = "district_plan_id")
    private List<District> districts;

    private double efficiencyGap;
    private double fairness;
    private double meanPopulationDeviation;
    private String name;

    // @TODO look into this
    private int numCompetitiveDistricts;

    @ElementCollection
    @CollectionTable(name = "minority_majority_district_count", joinColumns = @JoinColumn(name = "district_plan_id"))
    private Map<PoliticalGroup, Integer> minorityMajorityDistrictsMap;

    @ElementCollection
    @CollectionTable(name = "republican_district_id", joinColumns = @JoinColumn(name = "district_plan_id"))
    private List<Long> republicanDistrictIds;

    // START SEAT SHARE DATA
    @Embedded
    @ElementCollection
    @CollectionTable(name = "seat_share_democrat_coordinate", joinColumns = @JoinColumn(name = "district_plan_id"))
    private List<Coordinate> seatShareDemocratData;

    @Embedded
    @ElementCollection
    @CollectionTable(name = "seat_share_republican_coordinate", joinColumns = @JoinColumn(name = "district_plan_id"))
    private List<Coordinate> seatShareRepublicanData;

    private double seatShareBiasAt50;
    private double seatShareSymmetry;
    private double seatShareResponsiveness;
    // END SEAT SHARE DATA

    /**
     * @return Long return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return double return the compactness
     */
    public double getCompactness() {
        return compactness;
    }

    /**
     * @param compactness the compactness to set
     */
    public void setCompactness(double compactness) {
        this.compactness = compactness;
    }

    /**
     * @return double return the efficiencyGap
     */
    public double getEfficiencyGap() {
        return efficiencyGap;
    }

    /**
     * @param efficiencyGap the efficiencyGap to set
     */
    public void setEfficiencyGap(double efficiencyGap) {
        this.efficiencyGap = efficiencyGap;
    }

    /**
     * @return double return the fairness
     */
    public double getFairness() {
        return fairness;
    }

    /**
     * @param fairness the fairness to set
     */
    public void setFairness(double fairness) {
        this.fairness = fairness;
    }

    /**
     * @return double return the meanPopulationDeviation
     */
    public double getMeanPopulationDeviation() {
        return meanPopulationDeviation;
    }

    /**
     * @param meanPopulationDeviation the meanPopulationDeviation to set
     */
    public void setMeanPopulationDeviation(double meanPopulationDeviation) {
        this.meanPopulationDeviation = meanPopulationDeviation;
    }

    /**
     * @return String return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return int return the numCompetitiveDistricts
     */
    public int getNumCompetitiveDistricts() {
        return numCompetitiveDistricts;
    }

    /**
     * @param numCompetitiveDistricts the numCompetitiveDistricts to set
     */
    public void setNumCompetitiveDistricts(int numCompetitiveDistricts) {
        this.numCompetitiveDistricts = numCompetitiveDistricts;
    }

    /**
     * @return List<Coordinate> return the seatShareDemocratData
     */
    public List<Coordinate> getSeatShareDemocratData() {
        return seatShareDemocratData;
    }

    /**
     * @param seatShareDemocratData the seatShareDemocratData to set
     */
    public void setSeatShareDemocratData(List<Coordinate> seatShareDemocratData) {
        this.seatShareDemocratData = seatShareDemocratData;
    }

    /**
     * @return List<Coordinate> return the seatShareRepublicanData
     */
    public List<Coordinate> getSeatShareRepublicanData() {
        return seatShareRepublicanData;
    }

    /**
     * @param seatShareRepublicanData the seatShareRepublicanData to set
     */
    public void setSeatShareRepublicanData(List<Coordinate> seatShareRepublicanData) {
        this.seatShareRepublicanData = seatShareRepublicanData;
    }

    /**
     * @return double return the seatShareBiasAt50
     */
    public double getSeatShareBiasAt50() {
        return seatShareBiasAt50;
    }

    /**
     * @param seatShareBiasAt50 the seatShareBiasAt50 to set
     */
    public void setSeatShareBiasAt50(double seatShareBiasAt50) {
        this.seatShareBiasAt50 = seatShareBiasAt50;
    }

    /**
     * @return double return the seatShareSymmetry
     */
    public double getSeatShareSymmetry() {
        return seatShareSymmetry;
    }

    /**
     * @param seatShareSymmetry the seatShareSymmetry to set
     */
    public void setSeatShareSymmetry(double seatShareSymmetry) {
        this.seatShareSymmetry = seatShareSymmetry;
    }

    /**
     * @return double return the seatShareResponsiveness
     */
    public double getSeatShareResponsiveness() {
        return seatShareResponsiveness;
    }

    /**
     * @param seatShareResponsiveness the seatShareResponsiveness to set
     */
    public void setSeatShareResponsivness(double seatShareResponsiveness) {
        this.seatShareResponsiveness = seatShareResponsiveness;
    }


    /**
     * @return List<Long> return the republicanDistrictIds
     */
    public List<Long> getRepublicanDistrictIds() {
        return republicanDistrictIds;
    }

    /**
     * @param republicanDistrictIds the republicanDistrictIds to set
     */
    public void setRepublicanDistrictIds(List<Long> republicanDistrictIds) {
        this.republicanDistrictIds = republicanDistrictIds;
    }


    /**
     * @return List<Long> return the competitiveDistrictIds
     */
    public List<Long> getCompetitiveDistrictIds() {
        return competitiveDistrictIds;
    }

    /**
     * @param competitiveDistrictIds the competitiveDistrictIds to set
     */
    public void setCompetitiveDistrictIds(List<Long> competitiveDistrictIds) {
        this.competitiveDistrictIds = competitiveDistrictIds;
    }

    /**
     * @return List<Long> return the democratDistrictIds
     */
    public List<Long> getDemocratDistrictIds() {
        return democratDistrictIds;
    }

    /**
     * @param democratDistrictIds the democratDistrictIds to set
     */
    public void setDemocratDistrictIds(List<Long> democratDistrictIds) {
        this.democratDistrictIds = democratDistrictIds;
    }

    /**
     * @return Map<PoliticalGroup, Integer> return the minorityMajorityDistrictsMap
     */
    public Map<PoliticalGroup, Integer> getMinorityMajorityDistrictsMap() {
        return minorityMajorityDistrictsMap;
    }

    /**
     * @param minorityMajorityDistrictsMap the minorityMajorityDistrictsMap to set
     */
    public void setMinorityMajorityDistrictsMap(Map<PoliticalGroup, Integer> minorityMajorityDistrictsMap) {
        this.minorityMajorityDistrictsMap = minorityMajorityDistrictsMap;
    }

    /**
     * @param seatShareResponsiveness the seatShareResponsiveness to set
     */
    public void setSeatShareResponsiveness(double seatShareResponsiveness) {
        this.seatShareResponsiveness = seatShareResponsiveness;
    }


    /**
     * @return List<District> return the districts
     */
    public List<District> getDistricts() {
        return districts;
    }

    /**
     * @param districts the districts to set
     */
    public void setDistricts(List<District> districts) {
        this.districts = districts;
    }

    /**
     * @return a DistrictPlanMetrics Object
     */
    public DistrictPlanMetrics createMetrics() {
        DistrictPlanMetrics metrics = new DistrictPlanMetrics();
        metrics.setCompactness(this.getCompactness());
        metrics.setCompetitiveDistrictIds(this.getCompetitiveDistrictIds());
        metrics.setDemocratDistrictIds(this.getDemocratDistrictIds());
        metrics.setId(this.getId());
        metrics.setMeanPopulationDeviation(this.getMeanPopulationDeviation());
        metrics.setRepublicanDistrictIds(this.getRepublicanDistrictIds());
        metrics.setName(this.getName());
        return metrics;
    }

    /**
     * generates the seat share curve using Jeffrey Shen's python script as a reference
     * https://github.com/jeffreyshen19/Seats-Votes-Curves/blob/master/generator/uniform_partisan_swing.py
     * @return SeatShareData Object with generated data
     */
    public SeatShareData generateSeatShareData() {
        // initialize SeatShareData object
        SeatShareData seatShareData = new SeatShareData();

        // important value needed several times
        int numDistricts = this.districts.size();
        final double SWING_CONSTANT = 0.005;

        // initialize coordinate Objects
        List<Coordinate> democratCoordinates = new ArrayList<Coordinate>();
        List<Coordinate> republicanCoordinates = new ArrayList<Coordinate>();

        // add guaranteed endpoints
        democratCoordinates.add(new Coordinate(0, 0));
        democratCoordinates.add(new Coordinate(1, 1));
        republicanCoordinates.add(new Coordinate(0, 0));
        republicanCoordinates.add(new Coordinate(1, 1));

        // initialize district level voting data
        List<Integer> democratDistrictVotes = this.districts.stream()
            .map(d -> d.getPopulationData(PoliticalGroup.DEMOCRAT))
            .collect(Collectors.toList());
        List<Integer> republicanDistrictVotes = this.districts.stream()
            .map(d -> d.getPopulationData(PoliticalGroup.REPUBLICAN))
            .collect(Collectors.toList());
        List<Map<PoliticalGroup,Double>> votesByDistrict = new ArrayList<Map<PoliticalGroup,Double>>();

        // gather vote tallies
        int totalDemocratVotes = 0;
        int totalRepublicanVotes = 0;
        int totalVotes = 0;
        for (int i = 0; i < numDistricts; i++) {
            totalDemocratVotes += democratDistrictVotes.get(i);
            totalRepublicanVotes += republicanDistrictVotes.get(i);
            totalVotes += democratDistrictVotes.get(i) + republicanDistrictVotes.get(i);
            double percentDemocrat = (double)democratDistrictVotes.get(i)
                / ((double)democratDistrictVotes.get(i) + (double)republicanDistrictVotes.get(i));
            
            // collect tallied data by district to be used in main loop
            Map<PoliticalGroup,Double> tempMap = new HashMap<PoliticalGroup,Double>();
            tempMap.put(PoliticalGroup.DEMOCRAT, percentDemocrat);
            tempMap.put(PoliticalGroup.REPUBLICAN, 1.0 - percentDemocrat);
            votesByDistrict.add(tempMap);
        }

        // get starting points for 2 main loops
        double republicanVoteShare = (double)totalRepublicanVotes / (double)totalVotes;
        double democratVoteShare = (double)totalDemocratVotes / (double)totalVotes;

        // randomness element
        double diff = (((100.0 * republicanVoteShare) % 1) - ((100.0 * democratVoteShare) % 1)) / 100.0;

        // declare loop variables
        boolean[] districtOverflowedDemocrat = new boolean[numDistricts];
        boolean[] districtOverflowedRepublican = new boolean[numDistricts];
        double[] updatedValuesDemocrat = new double[numDistricts];
        double[] updatedValuesRepublican = new double[numDistricts];

        // main republican start to 1 loop
        double i = republicanVoteShare;
        int counter = 0;
        while (i <= 1) {
            // initialize counters for 1000 random vote simulations
            int totalRepublicanSeats = 0;
            int totalDemocratSeats = 0;

            // simulate 1000 random vote simulations
            for (int j = 0; j < 1000; j++) {
                // tells us which districts are overflowed
                Arrays.fill(districtOverflowedDemocrat, false);
                Arrays.fill(districtOverflowedRepublican, false);

                // count excess votes
                int excessDemocrat = 0;
                int excessRepublican = 0;


                // store district vote counts for this iteration
                Arrays.fill(updatedValuesDemocrat, 0);
                Arrays.fill(updatedValuesRepublican, 0);

                // iterate over each district and distribute votes
                for (int k = 0; k < numDistricts; k++) {
                    // get percentage of this district's rep/dem votes
                    updatedValuesRepublican[k] = votesByDistrict.get(k).get(PoliticalGroup.REPUBLICAN) 
                        + (counter * SWING_CONSTANT) + (SWING_CONSTANT * (int)(Math.random() * 11 - 5));
                    updatedValuesDemocrat[k] = 1 - updatedValuesRepublican[k] + diff;

                    // account for possible overflow
                    if (updatedValuesDemocrat[k] > 1) {
                        excessDemocrat += 1;
                        districtOverflowedDemocrat[k] = true;
                    }
                    if (updatedValuesRepublican[k] > 1) {
                        excessRepublican += 1;
                        districtOverflowedRepublican[k] = true;
                    }
                }

                // iterate over each district to redistribute overflow(if any) and compute winner
                for (int k = 0; k < numDistricts; k++) {
                    // overflow mechanic
                    if (!districtOverflowedRepublican[k]) {
                        updatedValuesRepublican[k] += 
                            SWING_CONSTANT * (excessRepublican / (numDistricts - excessRepublican));
                    }
                    if (!districtOverflowedDemocrat[k]) {
                        updatedValuesDemocrat[k] -= 
                            SWING_CONSTANT * (excessDemocrat / (numDistricts - excessDemocrat));
                    }

                    // check who won this district and tally
                    if (updatedValuesRepublican[k] > .5) {
                        totalRepublicanSeats += 1;
                    }
                    if (updatedValuesDemocrat[k] > .5) {
                        totalDemocratSeats += 1;
                    }
                }
            }

            // update loop counters
            i += SWING_CONSTANT;
            counter++;

            // store generate seat curve data
            if (i > 0 && i < 1) {
                republicanCoordinates.add(
                    new Coordinate(i, (double)totalRepublicanSeats / ((double)numDistricts * 1000)));
                democratCoordinates.add(
                    new Coordinate(1 - i + diff, (double)totalDemocratSeats / ((double)numDistricts * 1000)));
            }
        }

        // main democrat start to 1 loop
        i = democratVoteShare;
        counter = 0;
        while (i <= 1) {
            // initialize counters for 1000 random vote simulations
            int totalRepublicanSeats = 0;
            int totalDemocratSeats = 0;

            // simulate 1000 random vote simulations
            for (int j = 0; j < 1000; j++) {
                // tells us which districts are overflowed
                Arrays.fill(districtOverflowedDemocrat, false);
                Arrays.fill(districtOverflowedRepublican, false);

                // count excess votes
                int excessDemocrat = 0;
                int excessRepublican = 0;

                // store district vote counts for this iteration
                Arrays.fill(updatedValuesDemocrat, 0);
                Arrays.fill(updatedValuesRepublican, 0);

                // iterate over each district and distribute votes
                for (int k = 0; k < numDistricts; k++) {
                    // get percentage of this district's rep/dem votes
                    updatedValuesDemocrat[k] = votesByDistrict.get(k).get(PoliticalGroup.DEMOCRAT) 
                        + (counter * SWING_CONSTANT) + (SWING_CONSTANT * (int)(Math.random() * 11 - 5)) + diff;
                    updatedValuesRepublican[k] = 1 - (updatedValuesDemocrat[k] - diff);

                    // account for possible overflow
                    if (updatedValuesDemocrat[k] > 1) {
                        excessDemocrat += 1;
                        districtOverflowedDemocrat[k] = true;
                    }
                    if (updatedValuesRepublican[k] > 1) {
                        excessRepublican += 1;
                        districtOverflowedRepublican[k] = true;
                    }
                }

                // iterate over each district to redistribute overflow(if any) and compute winner
                for (int k = 0; k < numDistricts; k++) {
                    // overflow mechanic
                    if (!districtOverflowedRepublican[k]) {
                        updatedValuesRepublican[k] -= 
                            SWING_CONSTANT * (excessRepublican / (numDistricts - excessRepublican));
                    }
                    if (!districtOverflowedDemocrat[k]) {
                        updatedValuesDemocrat[k] += 
                            SWING_CONSTANT * (excessDemocrat / (numDistricts - excessDemocrat));
                    }

                    // check who won this district and tally
                    if (updatedValuesRepublican[k] > .5) {
                        totalRepublicanSeats += 1;
                    }
                    if (updatedValuesDemocrat[k] > .5) {
                        totalDemocratSeats += 1;
                    }
                }
            }

            // update loop counters
            i += SWING_CONSTANT;
            counter++;

            // store generate seat curve data
            if (i > 0 && i + diff < 1) {
                republicanCoordinates.add(
                    new Coordinate(1 - i, (double)totalRepublicanSeats / ((double)numDistricts * 1000)));
                democratCoordinates.add(
                    new Coordinate(i + diff, (double)totalDemocratSeats / ((double)numDistricts * 1000)));
            }
        }

        // sort coordinate lists
        democratCoordinates.sort(Comparator.comparing(Coordinate::getX));
        republicanCoordinates.sort(Comparator.comparing(Coordinate::getX));

        // calculate bias as close to 50 as possible
        Coordinate republicanSeatsNear50 = republicanCoordinates.stream()
            .min(Comparator.comparingDouble(c -> Math.abs(c.getX() - .5)))
            .get();
        double bias = republicanSeatsNear50.getY() - republicanSeatsNear50.getX();

        // calculate symmetry
        List<Coordinate> republicanTemp = republicanCoordinates.stream()
            .filter(c -> c.getX() >= .45 && c.getX() < .55)
            .collect(Collectors.toList());
        List<Coordinate> democratTemp = democratCoordinates.stream()
            .filter(c -> c.getX() >= .45 && c.getX() < .55)
            .collect(Collectors.toList());
        
        double symmetry = 0;
        for (int j = 0; j < republicanTemp.size(); j++) {
            symmetry += Math.abs(republicanTemp.get(j).getY() - democratTemp.get(j).getY());
        }
        symmetry /= republicanTemp.size();

        // @TODO calculate responsiveness
        Coordinate rLast = republicanTemp.get(republicanTemp.size()-1);
        Coordinate rFirst = republicanTemp.get(0);
        double averageRepublicanSlope = (rLast.getY() - rFirst.getY()) / (rLast.getX() - rFirst.getX());

        Coordinate dLast = republicanTemp.get(republicanTemp.size()-1);
        Coordinate dFirst = republicanTemp.get(0);
        double averageDemocratSlope = (dLast.getY() - dFirst.getY()) / (dLast.getX() - dFirst.getX());

        double responsiveness = (averageDemocratSlope + averageRepublicanSlope) / 2.0;

        // @TODO POPULATE THIS OBJECT WITH DATA
        seatShareData.setDemocratData(democratCoordinates);
        seatShareData.setRepublicanData(republicanCoordinates);
        seatShareData.setBiasAt50(bias);
        seatShareData.setSymmetry(symmetry);
        seatShareData.setResponsiveness(responsiveness);
        return seatShareData;
    }

    /**
     * generates the box and whisker stats for this district plan
     * @return sorted stats for each demographic group
     */
    public Map<PoliticalGroup, List<Integer>> generateBoxAndWhiskerData() {
        // initialize return Object
        Map<PoliticalGroup, List<Integer>> data = new HashMap<PoliticalGroup, List<Integer>>();
        Integer[] temp;

        // iterate over each demographic group except total population
        for (PoliticalGroup group: PoliticalGroup.values()) {
            if (group != PoliticalGroup.TOTAL_POPULATION) {
                // get data for each district in this districting
                temp = new Integer[this.districts.size()];
                for (int i = 0; i < this.districts.size(); i++) {
                    temp[i] = this.districts.get(i).getPopulationData(group);
                }
                // sort the data in ascending order
                Arrays.sort(temp);
                data.put(group, Arrays.asList(temp));
            }
        }

        return data;
    }

}
