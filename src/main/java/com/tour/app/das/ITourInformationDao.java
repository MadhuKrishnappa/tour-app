package com.tour.app.das;

import com.tour.app.entity.TourInformation;

import java.math.BigInteger;
import java.util.List;

public interface ITourInformationDao {
    TourInformation add(TourInformation tourInformation);

    List<TourInformation> getByPackageId(BigInteger packageId);
}
