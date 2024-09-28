package com.tour.app.model.vo;

import com.tour.app.model.enums.PackageDetailTypeEnum;
import com.tour.app.model.enums.Status;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigInteger;
import java.util.Date;

@Setter
@Getter
@ToString
public class PackageDetailsVO {

    public BigInteger id;
    public BigInteger packageId;
    public PackageDetailTypeEnum packageDetailType;
    public String description;
    public Status status;
    public Date createdAt;
    public Date updatedAt;
}
