package com.tour.app.das.impl;

import com.tour.app.das.ITourInformationDao;
import com.tour.app.entity.TourInformation;
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
public class TourInformationDaoImpl implements ITourInformationDao {

    @Autowired
    @Qualifier("mysql")
    NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public TourInformation add(TourInformation tourInformation) {

        String query = DatabaseUtil.getInsertQuery(TourInformation.class);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(query, DatabaseUtil.getParameterSource(tourInformation), keyHolder,
                new String[]{"id"});
        tourInformation.setId(new BigInteger(keyHolder.getKey().toString()));

        return tourInformation;
    }

    @Override
    public List<TourInformation> getByPackageId(BigInteger packageId) {

        String query = " select * from tour_information  where package_id = :packageId and status = 'ACTIVE'  ";
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("packageId", packageId);
        return jdbcTemplate.query(query, map, new BeanPropertyRowMapper<>(TourInformation.class));
    }
}
