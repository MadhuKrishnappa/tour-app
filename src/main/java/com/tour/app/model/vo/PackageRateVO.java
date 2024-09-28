package com.tour.app.model.vo;

import com.tour.app.model.enums.GuestSharingTypeEnum;
import com.tour.app.model.enums.GuestTypeEnum;
import com.tour.app.model.enums.PackageRateTypeEnum;
import com.tour.app.model.enums.Status;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

@Setter
@Getter
@ToString
public class PackageRateVO {

    public int id;
    public int packageId;
    public PackageRateTypeEnum packageRateType;
    public GuestSharingTypeEnum guestSharingType;
    public BigDecimal adultRate;
    public BigDecimal childRateWithBed;
    public BigDecimal childRateWithoutBed;
    public BigDecimal infantRate;
    public String description;
    public Status status;
    public Date createdAt;
    public Date updatedAt;

}

