package com.tour.app.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigInteger;
import java.util.Date;

@Setter
@Getter
@ToString
@Table(name = "package_departure_city_date_mappings")
public class PackageDepartureCityDateMapping {


    @Column(name = "id")
    public BigInteger id;

    @Column(name = "city_id")
    public BigInteger cityId;

    @Column(name = "departure_date")
    public Date departureDate;

    @Column(name = "package_id")
    public BigInteger packageId;

    @Column(name = "status")
    public String status;

    @Column(name = "created_at")
    public Date createdAt;

    @Column(name = "updated_at")
    public Date updatedAt;


}
