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
public class CityVO {

    public BigInteger id;
    public String name;
    public String cityCode;
    public StateVO state;
    public Status status;
    public Date createdAt;
    public Date updatedAt;
}
