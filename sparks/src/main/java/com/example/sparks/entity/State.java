package com.example.sparks.entity;

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

import com.example.sparks.embeddable.BoxAndWhiskerMap;
import com.example.sparks.embeddable.CombinedMajorityMinorityMap;
import com.example.sparks.embeddable.Coordinate;
import com.example.sparks.embeddable.HistogramMap;
import com.example.sparks.embeddable.MajorityMinorityMap;
import com.example.sparks.embeddable.RepublicanDemocratSplit;
import com.example.sparks.enumerable.PoliticalGroup;
import com.example.sparks.nonentity.BoxAndWhiskerData;
import com.example.sparks.nonentity.SeatShareData;
import com.example.sparks.nonentity.SeawulfSummary;

/**
 * This Entity will store all the data for each state, including geojson data(?)
 */
@Entity
public class State {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "state_id")
    private Long id;

    @OneToMany
    @JoinColumn(name = "state_id")
    private List<DistrictPlan> districtPlans;

    // START SEAWULF DATA
    @ElementCollection
    @CollectionTable(name = "seawulf_box_and_whisker_data", joinColumns = @JoinColumn(name = "state_id"))
    @Embedded
    private List<BoxAndWhiskerMap> seawulfBoxAndWhiskerMap;

    @ElementCollection
    @CollectionTable(name = "seawulf_combined_majority_minority", joinColumns = @JoinColumn(name = "state_id"))
    @Embedded
    private List<CombinedMajorityMinorityMap> seawulfCombinedMajorityMinorityMap;

    @ElementCollection
    @CollectionTable(name = "seawulf_majority_minority", joinColumns = @JoinColumn(name = "state_id"))
    @Embedded
    private List<MajorityMinorityMap> seawulfMajorityMinorityMap;

    @ElementCollection
    @CollectionTable(name = "seawulf_republican_democrat_split", joinColumns = @JoinColumn(name = "state_id"))
    @Embedded
    private List<RepublicanDemocratSplit> seawulfRepublicanDemocratSplit;

    @ElementCollection
    @CollectionTable(name = "seawulf_compactness", joinColumns = @JoinColumn(name = "state_id"))
    @Embedded
    private List<HistogramMap> seawulfCompactnessData;

    @ElementCollection
    @CollectionTable(name = "seawulf_efficiency_gap", joinColumns = @JoinColumn(name = "state_id"))
    @Embedded
    private List<HistogramMap> seawulfEfficiencyGapData;

    @ElementCollection
    @CollectionTable(name = "seawulf_democrat_seat_share", joinColumns = @JoinColumn(name = "state_id"))
    @Embedded
    private List<Coordinate> seawulfDemocratSeatShareData;

    @ElementCollection
    @CollectionTable(name = "seawulf_republican_seat_share", joinColumns = @JoinColumn(name = "state_id"))
    @Embedded
    private List<Coordinate> seawulfRepublicanSeatShareData;

    private double seawulfSeatShareBiasAt50;
    private double seawulfSeatShareResponsiveness;
    private double seawulfSeatShareSymmetry;
    // END SEAWULF DATA

    private String stateCode;

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
     * @return String return the stateCode
     */
    public String getStateCode() {
        return stateCode;
    }

    /**
     * @param stateCode the stateCode to set
     */
    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }


    /**
     * @return List<DistrictPlan> return the districtPlans
     */
    public List<DistrictPlan> getDistrictPlans() {
        return districtPlans;
    }

    /**
     * @param districtPlans the districtPlans to set
     */
    public void setDistrictPlans(List<DistrictPlan> districtPlans) {
        this.districtPlans = districtPlans;
    }

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

    /**
     * @return double return the seawulfSeatShareBiasAt50
     */
    public double getSeawulfSeatShareBiasAt50() {
        return seawulfSeatShareBiasAt50;
    }

    /**
     * @param seawulfSeatShareBiasAt50 the seawulfSeatShareBiasAt50 to set
     */
    public void setSeawulfSeatShareBiasAt50(double seawulfSeatShareBiasAt50) {
        this.seawulfSeatShareBiasAt50 = seawulfSeatShareBiasAt50;
    }

    /**
     * @return double return the seawulfSeatShareResponsiveness
     */
    public double getSeawulfSeatShareResponsiveness() {
        return seawulfSeatShareResponsiveness;
    }

    /**
     * @param seawulfSeatShareResponsiveness the seawulfSeatShareResponsiveness to set
     */
    public void setSeawulfSeatShareResponsiveness(double seawulfSeatShareResponsiveness) {
        this.seawulfSeatShareResponsiveness = seawulfSeatShareResponsiveness;
    }

    /**
     * @return double return the seawulfSeatShareSymmetry
     */
    public double getSeawulfSeatShareSymmetry() {
        return seawulfSeatShareSymmetry;
    }

    /**
     * @param seawulfSeatShareSymmetry the seawulfSeatShareSymmetry to set
     */
    public void setSeawulfSeatShareSymmetry(double seawulfSeatShareSymmetry) {
        this.seawulfSeatShareSymmetry = seawulfSeatShareSymmetry;
    }

    /**
     * @return List<CombinedMajorityMinorityMap> return the seawulfCombinedMajorityMinorityMap
     */
    public List<CombinedMajorityMinorityMap> getSeawulfCombinedMajorityMinorityMap() {
        return seawulfCombinedMajorityMinorityMap;
    }

    /**
     * @param seawulfCombinedMajorityMinorityMap the seawulfCombinedMajorityMinorityMap to set
     */
    public void setSeawulfCombinedMajorityMinorityMap(List<CombinedMajorityMinorityMap> seawulfCombinedMajorityMinorityMap) {
        this.seawulfCombinedMajorityMinorityMap = seawulfCombinedMajorityMinorityMap;
    }

    /**
     * @return List<HistogramMap> return the seawulfCompactnessData
     */
    public List<HistogramMap> getSeawulfCompactnessData() {
        return seawulfCompactnessData;
    }

    /**
     * @param seawulfCompactnessData the seawulfCompactnessData to set
     */
    public void setSeawulfCompactnessData(List<HistogramMap> seawulfCompactnessData) {
        this.seawulfCompactnessData = seawulfCompactnessData;
    }

    /**
     * @return List<HistogramMap> return the seawulfEfficiencyGapData
     */
    public List<HistogramMap> getSeawulfEfficiencyGapData() {
        return seawulfEfficiencyGapData;
    }

    /**
     * @param seawulfEfficiencyGapData the seawulfEfficiencyGapData to set
     */
    public void setSeawulfEfficiencyGapData(List<HistogramMap> seawulfEfficiencyGapData) {
        this.seawulfEfficiencyGapData = seawulfEfficiencyGapData;
    }

    /**
     * @param districtPlanId the id of the plan to retrieve
     * @return DistrictPlan with matching id if it exists, otherwise null
     */
    public DistrictPlan getDistrictPlanById(Long districtPlanId) {
        return districtPlans.stream()
        .filter(plan -> districtPlanId.equals(plan.getId()))
        .findAny()
        .orElse(null);
    }

    /**
     * formats the seawulf summary data into a better format for the frontend
     * @return SeawulfSummary Object
     */
    public SeawulfSummary createSeawulfSummary() {
        // we need to reformat the data from the database into a more organized format
        SeawulfSummary summary = new SeawulfSummary();
        summary.setMajorityMinorityRange(this.createSeawulfMajorityMinorityRange());
        summary.setRepublicanDemocratSplit(this.createSeawulfRepublicanDemocratSplit());
        summary.setCombinedMajorityMinorityMap(this.createSeawulfCombinedMajorityMinorityMap());
        summary.setCompactnessData(this.createSeawulfCompactnessMap());
        summary.setEfficiencyGapData(this.createSeawulfEfficiencyGapMap());
        return summary;
    }

    /**
     * organizes database data into a more readable and sorted form for the frontend
     * @return map of demographic group to its corresponding box and whisker data
     */
    public Map<PoliticalGroup,List<BoxAndWhiskerData>> createSeawulfBoxAndWhiskerMap() {
        // first, box and whisker and majority minority becomes indexed by Political Group
        // each political group contains the sorted list (increasing order) of box and whisker data
        Map<PoliticalGroup,List<BoxAndWhiskerData>> tempBoxAndWhiskerMap = 
            new HashMap<PoliticalGroup, List<BoxAndWhiskerData>>();
        for (PoliticalGroup group: PoliticalGroup.values()) {
            // skip these metrics for total population
            if (group == PoliticalGroup.TOTAL_POPULATION) {
                continue;
            }
            // for each group, we filter out other groups, map the data to a manageable format,
            // then sort the data in ascending order
            List<BoxAndWhiskerData> tempList = this.getSeawulfBoxAndWhiskerMap().stream()
                .filter(d -> d.getPoliticalGroup() == group)
                .map(d -> new BoxAndWhiskerData(
                    d.getLowerQuartile(),
                    d.getMaximum(),
                    d.getMedian(),
                    d.getMinimum(),
                    d.getUpperQuartile(),
                    d.getMean()
                ))
                .sorted(Comparator.comparingDouble(BoxAndWhiskerData::getMedian))
                .collect(Collectors.toList());
            tempBoxAndWhiskerMap.put(group, tempList);
        }
        return tempBoxAndWhiskerMap;
    }

    /**
     * organizes majority minority range data into a readable format for the frontend to read
     * @return map of political group to coordinate data
     */
    public Map<PoliticalGroup, Map<Integer, Integer>> createSeawulfMajorityMinorityRange() {
        Map<PoliticalGroup, Map<Integer, Integer>> tempMajorityMinorityRangeMap =
            new HashMap<PoliticalGroup, Map<Integer, Integer>>();

        for (PoliticalGroup group: PoliticalGroup.values()) {
            // we can reuse this loop since majority minority range is also indexed by Political Group
            // don't do these calculations for white demographic
            if (group == PoliticalGroup.WHITE) {
                continue;
            }
            // for each group, filter out other groups, and map data to manageable format
            Map<Integer, Integer> tempMap = this.getSeawulfMajorityMinorityMap().stream()
                .filter(d -> d.getPoliticalGroup() == group)
                .collect(Collectors.toMap(d -> d.getNumMajorityMinorityDistricts(), d -> d.getCount()));
            tempMajorityMinorityRangeMap.put(group, tempMap);
        }

        return tempMajorityMinorityRangeMap;
    }

    /**
     * organizes seawulf seat share data into one SeatShareData Object
     * @return SeatShareData Object
     */
    public SeatShareData createSeawulfSeatShareData() {
        SeatShareData seatShareData = new SeatShareData();
        seatShareData.setDemocratData(this.seawulfDemocratSeatShareData);
        seatShareData.setRepublicanData(this.seawulfRepublicanSeatShareData);
        seatShareData.setBiasAt50(this.seawulfSeatShareBiasAt50);
        seatShareData.setResponsiveness(this.seawulfSeatShareResponsiveness);
        seatShareData.setSymmetry(this.seawulfSeatShareSymmetry);
        return seatShareData;
    }

    /**
     * organizes seawulf republican democrat split histogram data
     * @return List of RepublicanDemocratSplits
     */
    public List<RepublicanDemocratSplit> createSeawulfRepublicanDemocratSplit() {
        this.seawulfRepublicanDemocratSplit.sort(Comparator.comparing(RepublicanDemocratSplit::getRepublicanSeats));
        return this.seawulfRepublicanDemocratSplit;
    }

    /**
     * sorts combined majority minority histogram data and returns it
     * @return List of CombinedMajorityMinorityMaps
     */
    public List<CombinedMajorityMinorityMap> createSeawulfCombinedMajorityMinorityMap() {
        this.seawulfCombinedMajorityMinorityMap.sort(
            Comparator.comparing(CombinedMajorityMinorityMap::getNumCombinedMajorityMinorityDistricts));
        return this.seawulfCombinedMajorityMinorityMap;
    }

    /**
     * sorts seawulf compactness histogram data and returns it
     * @return List of HistogramMaps
     */
    public List<HistogramMap> createSeawulfCompactnessMap() {
        this.seawulfCompactnessData.sort(Comparator.comparing(HistogramMap::getRangeMinimum));
        return this.seawulfCompactnessData;
    }

    /**
     * sorts seawulf efficiency gap histogram data and returns it
     * @return List of HistogramMaps
     */
    public List<HistogramMap> createSeawulfEfficiencyGapMap() {
        this.seawulfEfficiencyGapData.sort(Comparator.comparing(HistogramMap::getRangeMinimum));
        return this.seawulfEfficiencyGapData;
    }
}
