package com.tour.app.das.impl;

import com.tour.app.das.IAccommodationDetailDao;
import com.tour.app.entity.AccommodationDetails;
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
public class AccommodationDetailDaoImpl implements IAccommodationDetailDao {

    @Autowired
    @Qualifier("mysql")
    NamedParameterJdbcTemplate jdbcTemplate;


    @Override
    public AccommodationDetails add(AccommodationDetails accommodationDetail) {

        String query = DatabaseUtil.getInsertQuery(AccommodationDetails.class);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(query, DatabaseUtil.getParameterSource(accommodationDetail), keyHolder,
                new String[]{"id"});
        accommodationDetail.setId(new BigInteger(keyHolder.getKey().toString()));

        return accommodationDetail;
    }

    @Override
    public List<AccommodationDetails> getByPackageId(BigInteger packageId) {

        String query = " select * from accommodation_details ad  where package_id = :packageId and status  = 'ACTIVE'; ";
        MapSqlParameterSource map= new MapSqlParameterSource();
        map.addValue("packageId", packageId);
        return jdbcTemplate.query(query, map, new BeanPropertyRowMapper<>(AccommodationDetails.class));
    }
}
