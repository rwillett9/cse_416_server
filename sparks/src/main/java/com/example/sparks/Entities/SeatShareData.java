package com.example.sparks.Entities;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import com.example.sparks.Embeddables.Coordinate;

import java.util.List;
// import org.springframework.data.util.Pair;

/**
 * For storing data to create the Seat Share Curve.
 * we require x and y values to plot for both democrats and republicans,
 * bias at 50%,
 * responsiveness and symmetry
 */
@Entity
public class SeatShareData {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "seat_share_data_id")
    private Long id;

    private double biasAt50;

    @Embedded
    @ElementCollection
    @CollectionTable(name = "democrat_data", joinColumns = @JoinColumn(name = "seat_share_data_id"))
    private List<Coordinate> democratData;

    @Embedded
    @ElementCollection
    @CollectionTable(name = "republican_data", joinColumns = @JoinColumn(name = "seat_share_data_id"))
    private List<Coordinate> republicanData;

    private double responsiveness;
    private double symmetry;

    // getters
    public Long getId() { return this.id; }
    public double getBiasAt50() { return this.biasAt50; }
    public List<Coordinate> getDemocratData() { return this.democratData; }
    public List<Coordinate> getRepublicanData() { return this.republicanData; }
    public double getReponsiveness() { return this.responsiveness; }
    public double getSymmetry() { return this.symmetry; }

    // setters
    public void setId(Long id) { this.id = id; }
    public void setBiasAt50(double biasAt50) { this.biasAt50 = biasAt50; }
    public void setDemocratData(List<Coordinate> democratData) { this.democratData = democratData; }
    public void setRepublicanData(List<Coordinate> republicanData) { this.republicanData = republicanData; }
    public void setResponsiveness(double responsiveness) { this.responsiveness = responsiveness; }
    public void setSymmetry(double symmetry) { this.symmetry = symmetry; }
}
