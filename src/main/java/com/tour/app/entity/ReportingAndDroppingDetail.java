package com.tour.app.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigInteger;
import java.util.Date;

@Setter
@Getter
@ToString
@Table(name = "reporting_and_dropping_details")
public class ReportingAndDroppingDetail {


    @Column(name = "id")
    public BigInteger id;

    @Column(name = "package_id")
    public BigInteger packageId;

    @Column(name = "guest_type")
    public String guestType;

    @Column(name = "reporting_point")
    public String reportingPoint;

    @Column(name = "dropping_point")
    public String droppingPoint;

    @Column(name = "status")
    public String status;

    @Column(name = "created_at")
    public Date createdAt;

    @Column(name = "updated_at")
    public Date updatedAt;


}
