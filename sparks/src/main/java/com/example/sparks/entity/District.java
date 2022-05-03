package com.example.sparks.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class District {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "district_id")
    private Long id;

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

}
