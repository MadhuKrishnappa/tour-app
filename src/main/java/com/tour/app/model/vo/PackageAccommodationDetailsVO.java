package com.tour.app.model.vo;

import com.tour.app.model.enums.Status;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigInteger;
import java.util.BitSet;
import java.util.Date;

@Setter
@Getter
@ToString
public class PackageAccommodationDetailsVO {


    public BigInteger id;
    public BigInteger packageId;
    public String city;
    public String hotelName;
    public String description;
    public Date checkInDate;
    public Date checkOutDate;
    public Status status;
    public Date createdAt;
    public Date updatedAt;


}
