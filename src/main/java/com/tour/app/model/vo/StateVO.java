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
public class StateVO {

    public BigInteger id;
    public String name;
    public String stateCode;
    public CountryVO country;
    public Status status;
    public Date createdAt;
    public Date updatedAt;
}
