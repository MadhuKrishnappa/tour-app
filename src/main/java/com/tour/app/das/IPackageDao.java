package com.tour.app.das;

import com.tour.app.entity.FetchPackageList;
import com.tour.app.entity.Packages;
import com.tour.app.request.FetchPackageRequest;

import java.util.List;

public interface IPackageDao {
    Packages getPackageById(int packageId);

    Packages addPackage(Packages packages);

    List<FetchPackageList> getPackageListingByFilter(FetchPackageRequest fetchPackageRequest);
}
