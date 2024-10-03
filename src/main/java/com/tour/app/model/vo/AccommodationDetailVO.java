package com.tour.app.model.vo;

import com.tour.app.model.enums.Status;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@ToString
public class AccommodationDetailVO {

    public BigInteger id;
    public BigInteger packageId;
    public int sequenceCount;
    public BigInteger cityId;
    public CityVO city;
    public String hotelName;
    public Date checkInDate;
    public Date checkOutDate;
    public Status status;
    public Date createdAt;
    public Date updatedAt;
}
