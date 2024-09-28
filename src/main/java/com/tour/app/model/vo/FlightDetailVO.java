package com.tour.app.model.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigInteger;
import java.util.Date;

@Setter
@Getter
@ToString
public class FlightDetailVO {

    public String flightName;
    public BigInteger departureCityId;
    public BigInteger arrivalCityId;
    public Date departureDate;
    public Date arrivalDate;
}
