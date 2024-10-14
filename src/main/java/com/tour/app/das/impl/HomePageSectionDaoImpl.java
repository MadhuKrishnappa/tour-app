package com.tour.app.das.impl;

import com.tour.app.das.IHomePageSectionDao;
import com.tour.app.entity.HomePageSection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HomePageSectionDaoImpl implements IHomePageSectionDao {


    @Autowired
    @Qualifier("mysql")
    NamedParameterJdbcTemplate jdbcTemplate;


    @Override
    public List<HomePageSection> getAll() {

        String query = " select * from home_page_sections where status = 'ACTIVE' ";
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(HomePageSection.class));
    }
}
