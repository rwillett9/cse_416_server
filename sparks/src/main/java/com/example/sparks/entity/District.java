package com.example.sparks.entity;

import java.util.List;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.example.sparks.enumerable.PoliticalGroup;

@Entity
public class District {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "district_id")
    private Long id;

    // population data for each district
    @ElementCollection
    @CollectionTable(name = "district_population_metrics", joinColumns = @JoinColumn(name = "district_id"))
    private Map<PoliticalGroup, Integer> populationMetrics;

    // @TODO geojson for each district or 1 geojson with all districts?

    @ManyToMany
    @JoinTable(
        name = "precinct_district_map",
        joinColumns = @JoinColumn(name = "district_id"),
        inverseJoinColumns = @JoinColumn(name = "precinct_id"))
    private List<Precinct> precincts;

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
     * @return List<Precinct> return the precincts
     */
    public List<Precinct> getPrecincts() {
        return precincts;
    }

    /**
     * @param precincts the precincts to set
     */
    public void setPrecincts(List<Precinct> precincts) {
        this.precincts = precincts;
    }

    /**
     * @return Map<PoliticalGroup, Integer> return the populationMetrics
     */
    public Map<PoliticalGroup, Integer> getPopulationMetrics() {
        return populationMetrics;
    }

    /**
     * @param populationMetrics the populationMetrics to set
     */
    public void setPopulationMetrics(Map<PoliticalGroup, Integer> populationMetrics) {
        this.populationMetrics = populationMetrics;
    }

    /**
     * @param group demographic group to find population data for
     * @return population of group in this district
     */
    public int getPopulationData(PoliticalGroup group) {
        return this.populationMetrics.get(group);
        // return this.precincts.stream()
        //     .map(p -> p.getDemographicAndElectionData().get(group))
        //     .reduce(0, (a, b) -> a + b);
    }

    /**
     * generates population stats based on precincts in this district
     * @param group demographic to find population of
     * @return population of group in this district
     */
    public int generatePopulation(PoliticalGroup group) {
        return this.precincts.stream()
            .map(p -> p.getDemographicAndElectionData().get(group))
            .reduce(0, (a, b) -> a + b);
    }
}
