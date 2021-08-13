package com.codegym.demo.model;

import javax.persistence.*;

@Entity
@Table
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int area;
    private int gdp;
    private String description;
    @ManyToOne
    @JoinColumn(name = "nation_id")
    private Nation nation;

    public City() {
    }

    public City(Long id, String name, int area, int gdp, String description, Nation nation) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.gdp = gdp;
        this.description = description;
        this.nation = nation;

    }

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

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getGdp() {
        return gdp;
    }

    public void setGdp(int gdp) {
        this.gdp = gdp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Nation getNation() {
        return nation;
    }

    public void setNation(Nation nation) {
        this.nation = nation;
    }
}
