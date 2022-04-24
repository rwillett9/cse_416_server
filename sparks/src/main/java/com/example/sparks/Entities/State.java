package com.example.sparks.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * This Entity will store all the data for each state, including geojson data
 */
@Entity
public class State {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(columnDefinition = "json")
    private String geoJson;

    // getters
    public Long getId() { return this.id; }
    public String getGeoJson() { return this.geoJson; }

    // setters
    public void setId(Long id) { this.id = id; }
    public void setGeoJson(String geoJson) { this.geoJson = geoJson; }
}
