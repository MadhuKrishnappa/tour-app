package com.tour.app.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigInteger;
import java.util.Date;

@Setter
@Getter
@ToString
@Table(name = "flight_details")
public class FlightDetails {


    @Column(name = "id")
    public BigInteger id;

    @Column(name = "package_id")
    public BigInteger packageId;

    @Column(name = "flight_name")
    public String flightName;

    @Column(name = "departure_city_id")
    public BigInteger departureCityId;

    @Column(name = "departure_date")
    public Date departureDate;

    @Column(name = "arrival_city_id")
    public BigInteger arrivalCityId;

    @Column(name = "arrival_date")
    public Date arrivalDate;

    @Column(name = "status")
    public String status;

    @Column(name = "created_at")
    public Date createdAt;

    @Column(name = "updated_at")
    public Date updatedAt;


}
