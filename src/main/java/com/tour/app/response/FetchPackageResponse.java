package com.tour.app.response;


import com.tour.app.model.FetchPackageListVO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@ToString
public class FetchPackageResponse implements IResponse{

    public List<FetchPackageListVO> fetchPackageList;

}
