package com.tour.app.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigInteger;
import java.util.Date;

@Setter
@Getter
@ToString
@Table(name = "home_page_section_mappings")
public class HomePageSectionMapping {

    @Column(name = "id")
    public BigInteger id;

    @Column(name = "home_page_section_id")
    public BigInteger homePageSectionId;

    @Column(name = "section_ranking")
    public int sectionRanking;

    @Column(name = "group_by_id")
    public BigInteger groupById;

    @Column(name = "ranking")
    public int ranking;

    @Column(name = "status")
    public String status;

    @Column(name = "created_at")
    public Date createdAt;

    @Column(name = "updated_at")
    public Date updatedAt;
}
