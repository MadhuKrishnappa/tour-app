package com.tour.app.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigInteger;
import java.util.Date;

@Setter
@Getter
@ToString
@Table(name = "tour_information")
public class TourInformation {

    @Column(name = "id")
    public BigInteger id;

    @Column(name = "package_id")
    public BigInteger packageId;

    @Column(name = "information_type")
    public String informationType;

    @Column(name = "description")
    public String description;

    @Column(name = "status")
    public String status;

    @Column(name = "created_at")
    public Date createdAt;

    @Column(name = "updated_at")
    public Date updatedAt;
}
