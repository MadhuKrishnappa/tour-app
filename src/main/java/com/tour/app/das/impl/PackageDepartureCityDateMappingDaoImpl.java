package com.tour.app.das.impl;

import com.tour.app.das.IPackageDepartureCityDateMappingDao;
import com.tour.app.entity.PackageDepartureCityDateMapping;
import com.tour.app.utilities.DatabaseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public class PackageDepartureCityDateMappingDaoImpl implements IPackageDepartureCityDateMappingDao {

    @Autowired
    @Qualifier("mysql")
    NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public PackageDepartureCityDateMapping add(PackageDepartureCityDateMapping departureCityDateMapping) {

        String query = DatabaseUtil.getInsertQuery(PackageDepartureCityDateMapping.class);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(query, DatabaseUtil.getParameterSource(departureCityDateMapping), keyHolder,
                new String[]{"id"});
        departureCityDateMapping.setId(new BigInteger(keyHolder.getKey().toString()));

        return departureCityDateMapping;
    }
}
