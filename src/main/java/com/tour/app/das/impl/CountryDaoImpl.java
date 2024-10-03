package com.tour.app.das.impl;

import com.tour.app.das.ICountryDao;
import com.tour.app.entity.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.math.BigInteger;
import java.util.List;

@Repository
public class CountryDaoImpl implements ICountryDao {

    @Autowired
    @Qualifier("mysql")
    NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public Country getById(BigInteger countryId) {


        String query = "  select * from countries where id = :countryId ";
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("countryId", countryId);
        List<Country> dataList = jdbcTemplate.query(query, map, new BeanPropertyRowMapper<>(Country.class));
        if(CollectionUtils.isEmpty(dataList)){
            return null;
        }
        return dataList.get(0);
    }
}
