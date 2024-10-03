package com.tour.app.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigInteger;
import java.util.Date;

@Setter
@Getter
@ToString
@NoArgsConstructor
@Table(name = "cities")
public class City {

    @Column(name = "id")
    public BigInteger id;

    @Column(name = "name")
    public String name;

    @Column(name = "city_code")
    public String cityCode;

    @Column(name = "state_id")
    public BigInteger stateId;

    @Column(name = "status")
    public String status;

    @Column(name = "created_at")
    public Date createdAt;

    @Column(name = "updated_at")
    public Date updatedAt;

}
