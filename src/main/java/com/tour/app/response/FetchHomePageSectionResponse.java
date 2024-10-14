package com.tour.app.response;

import com.tour.app.model.HomePageSectionVO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@ToString
public class FetchHomePageSectionResponse implements IResponse {


    public List<HomePageSectionVO> homePageData;

}
