package com.tour.app.services.impl;

import com.tour.app.das.IHomePageSectionDao;
import com.tour.app.das.IHomePageSectionMappingDao;
import com.tour.app.entity.HomePageSection;
import com.tour.app.entity.HomePageSectionMapping;
import com.tour.app.entity.HomeSectionPackage;
import com.tour.app.model.HomePageSectionVO;
import com.tour.app.response.FetchHomePageSectionResponse;
import com.tour.app.services.IHomeSectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
public class HomeSectionServiceImpl implements IHomeSectionService {

    @Autowired
    IHomePageSectionDao homePageSectionDao;

    @Autowired
    IHomePageSectionMappingDao homePageSectionMappingDao;

    @Override
    public FetchHomePageSectionResponse fetchHomeSections() {

        FetchHomePageSectionResponse response = new FetchHomePageSectionResponse();
        List<HomePageSection> homeSectionList = homePageSectionDao.getAll();
        List<HomePageSectionVO> homePageSectionVOList = new ArrayList<>();
        if(!CollectionUtils.isEmpty(homeSectionList)){
            for(HomePageSection section : homeSectionList){
                HomePageSectionVO homePageSectionVO = new HomePageSectionVO();
                homePageSectionVO.setSectionType(section.getSectionType());
                homePageSectionVO.setSectionRanking(section.getSectionRanking());
                homePageSectionVO.setGroupByType(section.getGroupByType());
                homePageSectionVO.setGroupBy(section.getGroupBy());
                homePageSectionVO.setTitle(section.getTitle());
                homePageSectionVO.setSubTitle(section.getSubTitle());
                List<HomePageSectionMapping> sectionMappings = homePageSectionMappingDao.getByHomePageSectionId(section.getId());
                List<HomeSectionPackage> packages = new ArrayList<>();
                if(!CollectionUtils.isEmpty(sectionMappings)){
                    String groupBy = section.getGroupBy();
                    String groupByType = section.getGroupByType();
                    List<BigInteger> groupByIds = new ArrayList<>();
                    for (HomePageSectionMapping sectionMapping : sectionMappings){
                        groupByIds.add(sectionMapping.getGroupById());
                    }
                    if(groupByType.equals("PLACE") && groupBy.equals("STATE")) {
                        packages.addAll(homePageSectionMappingDao.getGroupByState(groupByIds));
                    }else if(groupByType.equals("PLACE") && groupBy.equals("COUNTRY")) {
                        packages.addAll(homePageSectionMappingDao.getGroupByCountry(groupByIds));
                    }else if(groupByType.equals("PACKAGE_THEME")){
                        packages.addAll(homePageSectionMappingDao.getByPackageThemes(groupByIds));
                    }
                }
                homePageSectionVO.setPackages(packages);
                homePageSectionVOList.add(homePageSectionVO);
            }
        }
        response.setHomePageData(homePageSectionVOList);
        return response;
    }
}
