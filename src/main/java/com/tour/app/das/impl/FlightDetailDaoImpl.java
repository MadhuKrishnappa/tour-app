package com.tour.app.das.impl;

import com.tour.app.das.IFlightDetailDao;
import com.tour.app.entity.FlightDetails;
import com.tour.app.utilities.DatabaseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public class FlightDetailDaoImpl implements IFlightDetailDao {

    @Autowired
    @Qualifier("mysql")
    NamedParameterJdbcTemplate jdbcTemplate;


    @Override
    public FlightDetails add(FlightDetails flightDetail) {

        String query = DatabaseUtil.getInsertQuery(FlightDetails.class);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(query, DatabaseUtil.getParameterSource(flightDetail), keyHolder,
                new String[]{"id"});
        flightDetail.setId(new BigInteger(keyHolder.getKey().toString()));

        return flightDetail;
    }

    @Override
    public List<FlightDetails> getByPackageId(BigInteger packageId) {

        String query = " select * from flight_details fd  where package_id = :packageId  and status  = 'ACTIVE';  ";
        MapSqlParameterSource map= new MapSqlParameterSource();
        map.addValue("packageId", packageId);
        return jdbcTemplate.query(query, map, new BeanPropertyRowMapper<>(FlightDetails.class));

    }
}
