package com.tour.app.request;

import com.tour.app.model.enums.PackageThemeEnum;
import com.tour.app.model.enums.PackageTypeEnum;
import com.tour.app.model.vo.Duration;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Setter
@Getter
@ToString
public class FetchPackageRequest {

    public List<String> statuses;
    public List<BigInteger> packageIds;
    public List<BigInteger> countryIds;
    public List<BigInteger> stateIds;
    public List<BigInteger> cityIds;
    public List<String> packageThemes;
    public List<String> packageTypes;
    public BigDecimal filterPackagePrice;
    public Duration durationNights;


}
