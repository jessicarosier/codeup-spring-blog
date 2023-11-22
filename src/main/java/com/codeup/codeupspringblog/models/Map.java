package com.codeup.codeupspringblog.models;

import jakarta.persistence.*;

@Entity
@Table(name = "maps")
public class Map {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "latitude", length = 250)
    private Double latitude;

    @Column(name = "longitude", length = 250)
    private Double longitude;

    @Column(name = "zoom_level", length = 250)
    private Integer zoomLevel;

    @OneToOne(mappedBy = "map")
    private User user;


    public Map() {
    }

    public Map(Long id, Double latitude, Double longitude, Integer zoomLevel) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.zoomLevel = zoomLevel;
    }

    public Map(Double latitude, Double longitude, Integer zoomLevel) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.zoomLevel = zoomLevel;
    }

    public Map(Double latitude, Double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Integer getZoomLevel() {
        return zoomLevel;
    }

    public void setZoomLevel(Integer zoomLevel) {
        this.zoomLevel = zoomLevel;
    }
}
