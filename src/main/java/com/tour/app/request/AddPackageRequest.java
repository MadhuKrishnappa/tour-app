package com.tour.app.request;


import com.tour.app.model.vo.TourPackageVO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@ToString
public class AddPackageRequest {

    public List<TourPackageVO> packages;
}
