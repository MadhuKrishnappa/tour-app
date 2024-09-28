package com.tour.app.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

@Setter
@Getter
@ToString
@NoArgsConstructor
@Table(name = "package_rates")
public class PackageRates {


    @Column(name = "id")
    public BigInteger id;

    @Column(name = "package_id")
    public BigInteger packageId;

    @Column(name = "package_rate_type")
    public String packageRateType;

    @Column(name = "guest_sharing_type")
    public String guestSharingType;

    @Column(name = "adult_rate")
    public BigDecimal adultRate;

    @Column(name = "child_rate_with_bed")
    public BigDecimal childRateWithBed;

    @Column(name = "child_rate_without_bed")
    public BigDecimal childRateWithoutBed;

    @Column(name = "infant_rate")
    public BigDecimal infantRate;

    @Column(name = "description")
    public String description;

    @Column(name = "status")
    public String status;

    @Column(name = "created_at")
    public Date createdAt;

    @Column(name = "updated_at")
    public Date updatedAt;

}
