package com.tour.app.das;

import com.tour.app.entity.FlightDetails;

import java.math.BigInteger;
import java.util.List;

public interface IFlightDetailDao {
    FlightDetails add(FlightDetails flightDetail);

    List<FlightDetails> getByPackageId(BigInteger packageId);
}
