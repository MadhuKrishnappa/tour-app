package com.tour.app.das;

import com.tour.app.entity.PackageItineraryAddon;

import java.math.BigInteger;
import java.util.List;

public interface IPackageItineraryAddonDao {
    PackageItineraryAddon add(PackageItineraryAddon itineraryAddon);

    List<PackageItineraryAddon> getByItineraryId(BigInteger itineraryId);
}
