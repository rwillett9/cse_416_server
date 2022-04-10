package com.sparks.sparks.Entities;

import java.util.HashMap;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.sparks.sparks.Enums.PoliticalGroups;

// import org.hibernate.annotations.Type;

@Entity // tells Hibernate to make a table from this class
public class Precinct {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private HashMap<PoliticalGroups, Integer> demographicData;

    // @Type(type = "json")
    @Column(columnDefinition = "json")
    private String geoJsonData;

    private Set<Long> neighborIds;

    public Long getId() { return this.id; }
    public HashMap<PoliticalGroups, Integer> getDemographicData() { return this.demographicData; }
    public String getGeoJsonData() { return this.geoJsonData; }
    public Set<Long> getNeighborIds() { return this.neighborIds; }

    public void setId(Long id) { this.id = id; }
    public void setDemographicData(HashMap<PoliticalGroups, Integer> demographicData) { this.demographicData = demographicData; }
    public void setGeoJsonData(String geoJsonData) { this.geoJsonData = geoJsonData; }
    public void setNeighborIds(Set<Long> neighborIds) { this.neighborIds = neighborIds; }
}
