package com.tour.app.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

@Setter
@Getter
@ToString
public class FetchPackageList {

    @Column(name = "package_id")
    public BigInteger packageId;

    @Column(name = "package_name")
    public String packageName;

    @Column(name = "package_code")
    public String packageCode;

    @Column(name = "package_list_images")
    public String packageListImages;

    @Column(name = "package_detail_images")
    public String packageDetailImages;

    @Column(name = "package_types")
    public String packageTypes;

    @Column(name = "package_themes")
    public String packageThemes;

    @Column(name = "tour_includes")
    public String tourIncludes;

    @Column(name = "duration_days")
    public int durationDays;

    @Column(name = "duration_nights")
    public int durationNights;

    @Column(name = "package_rating")
    public BigDecimal packageRating;

    @Column(name = "package_reviews")
    public int packageReviews;

    @Column(name = "departure_cities")
    public String departureCities;

    @Column(name = "departure_city_ids")
    public String departureCityIds;

    @Column(name = "departure_dates")
    public String departureDates;

    @Column(name = "min_package_price")
    public BigDecimal minPackagePrice;

    @Column(name = "status")
    public String status;

    @Column(name = "created_at")
    public Date createdAt;

    @Column(name = "updated_at")
    public Date updatedAt;
    


}
