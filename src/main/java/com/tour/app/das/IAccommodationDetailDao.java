package com.tour.app.das;

import com.tour.app.entity.AccommodationDetails;

import java.math.BigInteger;
import java.util.List;

public interface IAccommodationDetailDao {
    AccommodationDetails add(AccommodationDetails accommodationDetail);

    List<AccommodationDetails> getByPackageId(BigInteger packageId);
}
