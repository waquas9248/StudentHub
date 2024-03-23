package com.app.studenthub.model;

import jakarta.persistence.*;

import com.app.studenthub.util.OutletType;

@Entity
@Table(name = "outlet")
public class Outlet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "outlet_type",columnDefinition = "smallint", nullable = false)
    private OutletType outletType;

//    @Column(name = "subtype")
//    private String subtype;

    @OneToOne
    @JoinColumn(name = "location_id")
    private Location location;

    @Column(name = "rating")
    private Float rating;

    @Column(name = "body", columnDefinition = "text")
    private String body;

    // Constructors, getters, and setters

    // Relationships
    // Add relationships here

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

    public OutletType getOutletType() {
        return outletType;
    }

    public void setOutletType(OutletType outletType) {
        this.outletType = outletType;
    }

//    public String getSubtype() {
//        return subtype;
//    }
//
//    public void setSubtype(String subtype) {
//        this.subtype = subtype;
//    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
