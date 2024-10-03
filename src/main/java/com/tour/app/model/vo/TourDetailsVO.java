package com.tour.app.model.vo;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@ToString
public class TourDetailsVO {

    public List<FlightDetailVO> flightDetails;
    public List<AccommodationDetailVO> accommodationDetails;
    public List<ReportingAndDroppingVO> reportingAndDroppingVOS;
}
