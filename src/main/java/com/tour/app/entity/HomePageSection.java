package com.tour.app.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigInteger;
import java.util.Date;

@Setter
@Getter
@ToString
@Table(name = "home_page_sections")
public class HomePageSection {

    @Column(name = "id")
    public BigInteger id;

    @Column(name = "title")
    public String title;

    @Column(name = "sub_title")
    public String subTitle;

    @Column(name = "section_type")
    public String sectionType;

    @Column(name = "section_ranking")
    public int sectionRanking;

    @Column(name = "group_by_type")
    public String groupByType;

    @Column(name = "group_by")
    public String groupBy;

    @Column(name = "status")
    public String status;

    @Column(name = "created_at")
    public Date createdAt;

    @Column(name = "updated_at")
    public Date updatedAt;


}
