package com.tour.app.model.vo;

import com.tour.app.model.enums.PackageThemeEnum;
import com.tour.app.model.enums.PackageTypeEnum;
import com.tour.app.model.enums.Status;
import com.tour.app.model.enums.TourIncludeEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Map;


@Setter
@Getter
@ToString
public class TourPackageVO {

    public BigInteger id;
    public String packageName;
    public String packageCode;
    public List<String> packageListImages;
    public List<String> packageDetailImages;
    public List<BigInteger> departureCities;
    public int durationDays;
    public int durationNights;
    public BigDecimal packageRating;
    public int totalPackageReviews;
    public BigDecimal minPackagePrice;
    public Map<BigInteger, List<Date>> departureCityDatesMappings;
    public List<Date> departureDates;
    public List<PackageTypeEnum> packageTypes;
    public List<PackageThemeEnum> packageThemes;
    public List<TourIncludeEnum> tourIncludes;
    public List<BigInteger> touringCities;
    public List<PackageRateVO> packageRates;
    public List<PackageItineraryVO> itineraries;
    public List<TourInformationVO> tourInformation;
    public TourDetailsVO tourDetails;
    public Status status;
    public Date createdAt;
    public Date updatedAt;

}
