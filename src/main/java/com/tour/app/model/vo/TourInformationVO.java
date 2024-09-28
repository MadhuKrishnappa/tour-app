package com.tour.app.model.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigInteger;


@Setter
@Getter
@ToString
public class TourInformationVO {

    public BigInteger packageId;

    public String informationType;

    public String description;
}
