package com.tour.app.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigInteger;
import java.util.Date;

@Setter
@Getter
@ToString
@Table(name = "accommodation_details")
public class AccommodationDetails {


    @Column(name = "id")
    public BigInteger id;

    @Column(name = "package_id")
    public BigInteger packageId;

    @Column(name = "sequence_count")
    public int sequenceCount;

    @Column(name = "city_id")
    public BigInteger cityId;

    @Column(name = "hotel_name")
    public String hotelName;

    @Column(name = "check_in_date")
    public Date checkInDate;

    @Column(name = "check_out_date")
    public Date checkOutDate;

    @Column(name = "status")
    public String status;

    @Column(name = "created_at")
    public Date createdAt;

    @Column(name = "updated_at")
    public Date updatedAt;


}
