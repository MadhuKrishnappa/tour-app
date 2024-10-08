package com.tour.app.model.vo;

import com.tour.app.model.enums.Status;
import com.tour.app.model.enums.TourInformationEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigInteger;
import java.util.Date;


@Setter
@Getter
@ToString
public class TourInformationVO {

    public BigInteger id;

    public BigInteger packageId;

    public TourInformationEnum informationType;

    public String description;

    public Status status;

    public Date createdAt;

    public Date updatedAt;
}
