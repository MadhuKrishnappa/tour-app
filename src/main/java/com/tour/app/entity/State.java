package com.tour.app.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigInteger;
import java.util.Date;

@Setter
@Getter
@ToString
@Table(name = "states")
public class State {

    @Column(name = "id")
    public BigInteger id;

    @Column(name = "name")
    public String name;

    @Column(name = "state_code")
    public String stateCode;

    @Column(name = "country_id")
    public BigInteger countryId;

    @Column(name = "status")
    public String status;

    @Column(name = "created_at")
    public Date createdAt;

    @Column(name = "updated_at")
    public Date updatedAt;
}
