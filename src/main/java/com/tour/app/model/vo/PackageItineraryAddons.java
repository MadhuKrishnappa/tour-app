package com.tour.app.model.vo;

import com.tour.app.model.enums.PackageItineraryAddonTypeEnum;
import com.tour.app.model.enums.Status;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigInteger;
import java.util.Date;

@Setter
@Getter
@ToString
public class PackageItineraryAddons {

    public BigInteger id;
    public BigInteger packageItineraryId;
    public PackageItineraryAddonTypeEnum itineraryAddonType;
    public String description;
    public Status status;
    public Date createdAt;
    public Date updatedAt;
}
