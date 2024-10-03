package com.tour.app.das;

import com.tour.app.entity.PackageRates;

import java.math.BigInteger;
import java.util.List;

public interface IPackageRateDao {
    PackageRates addPackageRates(PackageRates packageRates);

    List<PackageRates> getByPackageId(BigInteger packageId);
}
