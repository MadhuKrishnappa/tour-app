package com.tour.app.model.vo;

import com.tour.app.model.enums.Status;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@ToString
public class PackageItineraryVO {

    public BigInteger id;
    public BigInteger packageId;
    public String itineraryTitle;
    public String description;
    public String note;
    public int dayCount;
    public Date itineraryDate;
    public List<String> itineraryImages;
    public List<BigInteger> cityIds;
    public List<PackageItineraryAddons> itineraryAddons;
    public Status status;
    public Date createdAt;
    public Date updatedAt;
}
