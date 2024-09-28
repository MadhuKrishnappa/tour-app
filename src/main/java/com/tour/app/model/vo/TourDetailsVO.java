package com.tour.app.model.vo;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Setter
@Getter
@ToString
public class TourDetailsVO {

    public FlightDetailVO flightDetails;
    public List<AccommodationDetailVO> accommodationDetails;
    public List<ReportingAndDropping> reportingAndDroppings;
}
