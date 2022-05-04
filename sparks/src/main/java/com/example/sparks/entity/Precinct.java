package com.example.sparks.entity;

import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import com.example.sparks.enumerable.PoliticalGroup;

@Entity
public class Precinct {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "precinct_id")
    private Long id;

    @ElementCollection
    @CollectionTable(name = "precinct_demographic_and_election_data", joinColumns = @JoinColumn(name = "precinct_id"))
    private Map<PoliticalGroup, Integer> demographicAndElectionData;

    // @TODO geojson for each precinct or 1 geojson for all precincts?

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
     * @return Map<PoliticalGroup, Integer> return the demographicAndElectionData
     */
    public Map<PoliticalGroup, Integer> getDemographicAndElectionData() {
        return demographicAndElectionData;
    }

    /**
     * @param demographicAndElectionData the demographicAndElectionData to set
     */
    public void setDemographicAndElectionData(Map<PoliticalGroup, Integer> demographicAndElectionData) {
        this.demographicAndElectionData = demographicAndElectionData;
    }

}
