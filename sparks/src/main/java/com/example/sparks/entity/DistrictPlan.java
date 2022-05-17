package com.example.sparks.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.persistence.Column;
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

    @OneToMany
    @JoinColumn(name = "district_plan_id")
    private List<District> districts;

    private String name;

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
        metrics.setCompactness(this.compactness);
        metrics.setEfficiencyGap(this.generateEfficiencyGap());
        metrics.setId(this.id);
        metrics.setIncumbentSafeDistricts(this.generateIncumbentSafeDistrictsMap());
        metrics.setMeanPopulationDeviation(this.generateMeanPopulationDeviation());
        metrics.setMajorityMinorityDistrictsMap(this.generateMajorityMinorityDistrictMap());
        metrics.setPoliticalLeaningMap(this.generatePoliticalLeaningMap());
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

        Coordinate rLast = republicanTemp.get(republicanTemp.size()-1);
        Coordinate rFirst = republicanTemp.get(0);
        double averageRepublicanSlope = (rLast.getY() - rFirst.getY()) / (rLast.getX() - rFirst.getX());

        Coordinate dLast = republicanTemp.get(republicanTemp.size()-1);
        Coordinate dFirst = republicanTemp.get(0);
        double averageDemocratSlope = (dLast.getY() - dFirst.getY()) / (dLast.getX() - dFirst.getX());

        double responsiveness = (averageDemocratSlope + averageRepublicanSlope) / 2.0;

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
            if (group != PoliticalGroup.TOTAL_POPULATION || group != PoliticalGroup.DEMOCRAT
            || group != PoliticalGroup.REPUBLICAN) {
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

    /**
     * maps each district id to the demographic with the simple majority (not including democrat/republican)
     * @return mapping of district id (Long) to demographic with the simple majority (PoliticalGroup)
     */
    public Map<Long, PoliticalGroup> generateMajorityMinorityDistrictMap() {
        Map<Long, PoliticalGroup> resultMap = new HashMap<Long, PoliticalGroup>();
        
        // iterate over districts in this plan
        for (District district: this.districts) {
            int currentHighest = 0;
            PoliticalGroup highestGroup = null;

            // iterate over demographic groups
            for (PoliticalGroup group: PoliticalGroup.values()) {
                // skip total population, democrat, and republican
                if (group == PoliticalGroup.TOTAL_POPULATION || group == PoliticalGroup.DEMOCRAT
                || group == PoliticalGroup.REPUBLICAN) {
                    continue;
                }

                // if this demographic is higher than previous highest, this is new simple majority
                int groupPopulation = district.getPopulationData(group);
                if (groupPopulation > currentHighest) {
                    currentHighest = groupPopulation;
                    highestGroup = group;
                }
            }

            // save group with simple majority
            resultMap.put(district.getId(), highestGroup);
        }

        return resultMap;
    }

    /**
     * maps each district with their political leaning (maps to null if equal political leaning)
     * @return mapping of district id (Long) to political group with simple majority (PoliticalGroup)
     */
    public Map<Long, PoliticalGroup> generatePoliticalLeaningMap() {
        Map<Long, PoliticalGroup> resultMap = new HashMap<Long, PoliticalGroup>();

        for (District district: this.districts) {
            int democratPopulation = district.getPopulationData(PoliticalGroup.DEMOCRAT);
            int republicanPopulation = district.getPopulationData(PoliticalGroup.REPUBLICAN);
            if (democratPopulation > republicanPopulation) {
                resultMap.put(district.getId(), PoliticalGroup.DEMOCRAT);
            } else if (republicanPopulation > democratPopulation) {
                resultMap.put(district.getId(), PoliticalGroup.REPUBLICAN);
            } else {
                resultMap.put(district.getId(), null);
            }
        }

        return resultMap;
    }

    /**
     * calculate the mean population deviation for this district plan
     * @return mean population deviation
     */
    public double generateMeanPopulationDeviation() {
        // first get average population of districts in this plan, and store total populations in array
        double average = 0;
        int[] totalPopulations = new int[this.districts.size()];
        for (int i = 0; i < this.districts.size(); i++) {
            int totalPopulation = this.districts.get(i).getPopulationData(PoliticalGroup.TOTAL_POPULATION);
            totalPopulations[i] = totalPopulation;
            average += totalPopulation;
        }
        average /= this.districts.size();

        // find average deviation from the mean
        double result = 0;
        for (int population: totalPopulations) {
            result += Math.abs(population - average);
        }
        result /= this.districts.size();

        return result;
    }

    /**
     * figure out which districts are incumbent safe and return a list of their IDs
     * @return list of IDs for incumbent safe districts
     */
    public List<Long> generateIncumbentSafeDistrictsMap() {
        return this.districts.stream()
            .filter(d -> Math.abs(
                (d.getPopulationData(PoliticalGroup.DEMOCRAT) / d.getPopulationData(PoliticalGroup.TOTAL_POPULATION))
                - (d.getPopulationData(PoliticalGroup.REPUBLICAN) / d.getPopulationData(PoliticalGroup.TOTAL_POPULATION)))
                > .1)
            .map(District::getId)
            .collect(Collectors.toList());
    }

    /**
     * calculate efficiency gap for this district plan
     * @return percent of wasted votes in this district plan
     */
    public double generateEfficiencyGap() {
        int republicanWasted = 0;
        int democratWasted = 0;
        int totalVotes = 0;

        for (District district: this.districts) {
            int republicanVotes = district.getPopulationData(PoliticalGroup.REPUBLICAN);
            int democratVotes = district.getPopulationData(PoliticalGroup.DEMOCRAT);
            totalVotes += republicanVotes + democratVotes;
            // totalVotes += district.getPopulationData(PoliticalGroup.TOTAL_POPULATION);
            int votesNeeded = ((republicanVotes + democratVotes) / 2) + 1;
            if (republicanVotes > democratVotes) {
                republicanWasted += republicanVotes - votesNeeded;
                democratWasted += democratVotes;
            } else {
                republicanWasted += republicanVotes;
                democratWasted += democratVotes - votesNeeded;
            }
        }

        return (double)(republicanWasted - democratWasted) / (double)totalVotes;
    }

    /**
     * calculate number of districts where total minority population is greater than white population
     * @return number of combined majority minority districts in this district plan
     */
    public int generateNumberCombinedMajorityMinorityDistricts() {
        int total = 0;

        for (District district: this.districts) {
            int totalMinorityPopulation = 0;
            for (PoliticalGroup group: PoliticalGroup.values()) {
                if (group == PoliticalGroup.DEMOCRAT || group == PoliticalGroup.REPUBLICAN
                || group == PoliticalGroup.TOTAL_POPULATION || group == PoliticalGroup.WHITE) {
                    totalMinorityPopulation += district.getPopulationData(group);
                }
            }
            if (totalMinorityPopulation > district.getPopulationData(PoliticalGroup.WHITE)) {
                total++;
            }
        }

        return total;
    }
}
