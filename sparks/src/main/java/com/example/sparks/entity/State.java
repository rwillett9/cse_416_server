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
import com.example.sparks.embeddable.Coordinate;
import com.example.sparks.embeddable.MajorityMinorityMap;
import com.example.sparks.embeddable.RepublicanDemocratSplit;
import com.example.sparks.enumerable.PoliticalGroup;
import com.example.sparks.nonentity.BoxAndWhiskerData;
import com.example.sparks.nonentity.SeatShareData;
import com.example.sparks.nonentity.SeawulfRawData;
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

    private String geoJson;

    @OneToMany
    @JoinColumn(name = "state_id")
    private List<DistrictPlan> districtPlans;

    // START SEAWULF DATA
    @ElementCollection
    @CollectionTable(name = "seawulf_box_and_whisker_data", joinColumns = @JoinColumn(name = "state_id"))
    @Embedded
    private List<BoxAndWhiskerMap> seawulfBoxAndWhiskerMap;

    @ElementCollection
    @CollectionTable(name = "seawulf_majority_minority", joinColumns = @JoinColumn(name = "state_id"))
    @Embedded
    private List<MajorityMinorityMap> seawulfMajorityMinorityMap;

    @ElementCollection
    @CollectionTable(name = "seawulf_republican_democrat_split", joinColumns = @JoinColumn(name = "state_id"))
    @Embedded
    private List<RepublicanDemocratSplit> seawulfRepublicanDemocratSplit;

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
    // @TODO figure out how other seat share metrics work for seawulf data
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
     * @return String return the geoJson
     */
    public String getGeoJson() {
        return geoJson;
    }

    /**
     * @param geoJson the geoJson to set
     */
    public void setGeoJson(String geoJson) {
        this.geoJson = geoJson;
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

        summary.setBoxAndWhiskerData(this.createSeawulfBoxAndWhiskerMap());
        summary.setMajorityMinorityRange(this.createSeawulfMajorityMinorityRange());

        // @TODO discuss best format for this data (along with @TODO in SeawulfSummary.java)
        // // next, we reformat republican democrat split data
        // // format is key="<repSeats> <demSeats>", value=count
        // Map<String, Integer> tempRepublicanDemocratSplitMap = this.getSeawulfRepublicanDemocratSplit().stream()
        //     .collect(Collectors.toMap(d -> d.getRepublicanSeats() + " " + d.getDemocratSeats(),d -> d.getCount()));
        summary.setRepublicanDemocratSplit(this.seawulfRepublicanDemocratSplit);

        // @TODO seat share data
        summary.setSeatShareData(this.createSeawulfSeatShareData());

        return summary;
    }

    public SeawulfRawData createSeawulfRawData() {
        SeawulfRawData data = new SeawulfRawData();
        data.setSeawulfBoxAndWhiskerMap(this.seawulfBoxAndWhiskerMap);
        data.setSeawulfDemocratSeatShareData(this.seawulfDemocratSeatShareData);
        data.setSeawulfMajorityMinorityMap(this.seawulfMajorityMinorityMap);
        data.setSeawulfRepublicanDemocratSplit(this.seawulfRepublicanDemocratSplit);
        data.setSeawulfRepublicanSeatShareData(this.seawulfRepublicanSeatShareData);
        return data;
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
                    d.getUpperQuartile()
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
}
