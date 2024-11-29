package com.example.demo.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Village {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String location;
    private int cottageCount;

    @OneToMany(mappedBy = "village")
    private List<Cottage> cottages;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getCottageCount() {
        return cottageCount;
    }

    public void setCottageCount(int cottageCount) {
        this.cottageCount = cottageCount;
    }

    public List<Cottage> getCottages() {
        return cottages;
    }

    public void setCottages(List<Cottage> cottages) {
        this.cottages = cottages;
    }
}

