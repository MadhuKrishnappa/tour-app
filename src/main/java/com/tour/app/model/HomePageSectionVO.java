package com.tour.app.model;

import com.tour.app.entity.Column;
import com.tour.app.entity.HomeSectionPackage;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class HomePageSectionVO {


    public String sectionType;

    public int sectionRanking;

    public String groupByType;

    public String groupBy;

    public String title;

    public String subTitle;

    public List<HomeSectionPackage> packages;


}
