package com.tour.app.services;

import com.tour.app.model.vo.TourPackageVO;
import com.tour.app.request.AddPackageRequest;
import com.tour.app.request.FetchPackageRequest;

public interface IPackageService {


    TourPackageVO fetchPackages(FetchPackageRequest fetchPackageRequest) throws Exception;

    void addPackages(AddPackageRequest addPackageRequest) throws Exception;

}
