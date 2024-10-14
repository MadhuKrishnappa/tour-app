package com.tour.app.das;

import com.tour.app.entity.HomePageSectionMapping;
import com.tour.app.entity.HomeSectionPackage;

import java.math.BigInteger;
import java.util.Collection;
import java.util.List;

public interface IHomePageSectionMappingDao {
    List<HomePageSectionMapping> getByHomePageSectionId(BigInteger id);

    List<HomeSectionPackage> getGroupByState(List<BigInteger> groupByIds);

    List<HomeSectionPackage> getGroupByCountry(List<BigInteger> groupByIds);

    Collection<? extends HomeSectionPackage> getByPackageThemes(List<BigInteger> groupByIds);
}
