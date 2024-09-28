package com.tour.app.model.vo;

import com.tour.app.model.enums.Status;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class PackageCategoryTypeVO {

    public int id;
    public String packageType;
    public String description;
    public Status status;
}
