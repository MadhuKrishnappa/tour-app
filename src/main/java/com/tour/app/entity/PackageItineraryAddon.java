package com.tour.app.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigInteger;
import java.util.Date;

@Setter
@Getter
@ToString
@Table(name = "package_itinerary_addons")
public class PackageItineraryAddon {

    @Column(name = "id")
    public BigInteger id;

    @Column(name = "package_itinerary_id")
    public BigInteger packageItineraryId;

    @Column(name = "addon_type")
    public String addonType;

    @Column(name = "description")
    public String description;

    @Column(name = "status")
    public String status;

    @Column(name = "created_at")
    public Date createdAt;

    @Column(name = "updated_at")
    public Date updatedAt;


}
