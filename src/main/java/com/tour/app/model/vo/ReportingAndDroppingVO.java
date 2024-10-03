package com.tour.app.model.vo;

import com.tour.app.model.enums.Status;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigInteger;
import java.util.Date;

@Setter
@Getter
@ToString
public class ReportingAndDroppingVO {

    public BigInteger id;
    public BigInteger packageId;
    public String guestType;
    public String reportingPoint;
    public String droppingPoint;
    public Status status;
    public Date createdAt;
    public Date updatedAt;
}
