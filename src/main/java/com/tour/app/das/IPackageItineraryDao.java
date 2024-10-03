package com.tour.app.das;

import com.tour.app.entity.PackageItinerary;

import java.math.BigInteger;
import java.util.List;

public interface IPackageItineraryDao {
    PackageItinerary addPackageItinerary(PackageItinerary packageItinerary);

    List<PackageItinerary> getByPackageId(BigInteger packageId);
}
