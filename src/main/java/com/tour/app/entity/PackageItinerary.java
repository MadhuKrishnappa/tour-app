package com.tour.app.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigInteger;
import java.util.Date;

@Setter
@Getter
@ToString
@Table(name = "package_itineraries")
public class PackageItinerary {

    @Column(name = "id")
    public BigInteger id;

    @Column(name = "package_id")
    public BigInteger packageId;

    @Column(name = "itinerary_title")
    public String itineraryTitle;

    @Column(name = "description")
    public String description;

    @Column(name = "day_count")
    public int dayCount;

    @Column(name = "itinerary_date")
    public Date itineraryDate;

    @Column(name = "itinerary_images")
    public String itineraryImages;

    @Column(name = "note")
    public String note;

    @Column(name = "city_ids")
    public String cityIds;

    @Column(name = "status")
    public String status;

    @Column(name = "created_at")
    public Date createdAt;

    @Column(name = "updated_at")
    public Date updatedAt;


}
