package com.tour.app.model.vo;

import com.tour.app.model.enums.Status;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigInteger;
import java.util.Date;

@Setter
@Getter
@ToString
public class FlightDetailVO {

    public BigInteger id;
    public String flightName;
    public BigInteger departureCityId;
    public BigInteger arrivalCityId;
    public CityVO arrivalCity;
    public CityVO departureCity;
    public Date departureDate;
    public Date arrivalDate;
    public Status status;
    public Date createdAt;
    public Date updatedAt;
}
