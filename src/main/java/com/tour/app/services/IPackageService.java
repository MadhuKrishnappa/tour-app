package com.tour.app.services;

import com.tour.app.request.AddPackageRequest;
import com.tour.app.request.FetchPackageRequest;
import com.tour.app.response.FetchPackageResponse;
import com.tour.app.response.PackageDetailResponse;

import java.math.BigInteger;

public interface IPackageService {


    FetchPackageResponse fetchPackages(FetchPackageRequest fetchPackageRequest) throws Exception;

    void addPackages(AddPackageRequest addPackageRequest) throws Exception;

    PackageDetailResponse fetchPackageDetails(BigInteger packageId) throws Exception;
}
