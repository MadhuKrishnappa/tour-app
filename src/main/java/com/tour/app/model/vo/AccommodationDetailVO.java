package com.tour.app.model.vo;

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

    public int sequenceCount;
    public List<BigInteger> cityIds;
    public String hotelName;
    public Date checkInDate;
    public Date checkOutDate;
}
