package com.tour.app.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

@Setter
@Getter
@ToString
@NoArgsConstructor
@Table(name = "packages")
public class Packages implements Serializable {

    @Column(name = "id")
    public BigInteger id;

    @Column(name = "package_name")
    public String packageName;

    @Column(name = "package_code")
    public String packageCode;

    @Column(name = "package_list_images")
    public String packageListImages;

    @Column(name = "package_detail_images")
    public String packageDetailImages;

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

    @Column(name = "status")
    public String status;

    @Column(name = "created_at")
    public Date createdAt;

    @Column(name = "updated_at")
    public Date updatedAt;

}
