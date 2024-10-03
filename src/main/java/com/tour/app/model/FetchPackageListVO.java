package com.tour.app.model;

import com.tour.app.model.enums.TourIncludeEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@ToString
public class FetchPackageListVO {

    public BigInteger packageId;
    public String packageName;
    public String packageCode;
    public int durationDays;
    public int durationNights;
    public List<String> packageListImages;
    public BigDecimal packageRating;
    public int packageReviews;
    public List<String> tourIncludes;
    public List<String> departureCities;
    public List<String> departureDates;
    public BigDecimal packageRateStartsFrom;

}
