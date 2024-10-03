package com.tour.app.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigInteger;
import java.util.Date;

@Setter
@Getter
@ToString
@Table(name = "countries")
public class Country {

    @Column(name = "id")
    public BigInteger id;

    @Column(name = "name")
    public String name;

    @Column(name = "country_code")
    public String countryCode;

    @Column(name = "status")
    public String status;

    @Column(name = "created_at")
    public Date createdAt;

    @Column(name = "updated_at")
    public Date updatedAt;
}
