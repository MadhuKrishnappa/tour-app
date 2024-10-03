package com.tour.app.response;

import com.tour.app.model.vo.PackageDetailsVO;
import com.tour.app.model.vo.TourPackageVO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@ToString
public class PackageDetailResponse implements IResponse{

    public PackageDetailsVO packageDetails;
}
