package com.tour.app.das.impl;

import com.tour.app.das.ICityDao;
import com.tour.app.entity.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public class CityDaoImpl implements ICityDao {

    @Autowired
    @Qualifier("mysql")
    NamedParameterJdbcTemplate jdbcTemplate;


    @Override
    public List<City> getByIds(List<BigInteger> cityIds) {

        String query = "  select * from cities where id in (:cityIds ) and status = 'ACTIVE' ";
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("cityIds", cityIds);
        return jdbcTemplate.query(query, map, new BeanPropertyRowMapper<>(City.class));
    }
}
