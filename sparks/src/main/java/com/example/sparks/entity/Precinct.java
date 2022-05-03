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
    @CollectionTable(name = "precinct_demographic_data", joinColumns = @JoinColumn(name = "precinct_id"))
    private Map<PoliticalGroup, Integer> demographicData;

    // @TODO geojson for each precinct or 1 geojson for all precincts?

    private int totalPopulation;

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
     * @return Map<PoliticalGroup, Integer> return the demographicData
     */
    public Map<PoliticalGroup, Integer> getDemographicData() {
        return demographicData;
    }

    /**
     * @param demographicData the demographicData to set
     */
    public void setDemographicData(Map<PoliticalGroup, Integer> demographicData) {
        this.demographicData = demographicData;
    }

    /**
     * @return int return the totalPopulation
     */
    public int getTotalPopulation() {
        return totalPopulation;
    }

    /**
     * @param totalPopulation the totalPopulation to set
     */
    public void setTotalPopulation(int totalPopulation) {
        this.totalPopulation = totalPopulation;
    }

}
