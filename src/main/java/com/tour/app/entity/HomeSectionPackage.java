package com.tour.app.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigInteger;

@Setter
@Getter
@ToString
public class HomeSectionPackage {

    @Column(name = "id")
    public BigInteger id;

    @Column(name = "name")
    public String name;

    @Column(name = "ranking")
    public int ranking;

    @Column(name = "duration_days")
    public int durationDays;

    @Column(name = "min_price")
    public Double minPrice;

    @Column(name = "total_packages")
    public int totalPackages;

    @Column(name = "total_ratings")
    public double totalRatings;

    @Column(name = "total_reviews")
    public int totalReviews;

    @Column(name = "discount_percentage")
    public int discountPercentage;
}
