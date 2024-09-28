package com.tour.app.das;

import com.tour.app.entity.Packages;

public interface IPackageDao {
    Packages getPackageById(int packageId);

    Packages addPackage(Packages packages);
}
