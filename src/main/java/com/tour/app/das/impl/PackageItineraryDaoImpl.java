package com.tour.app.das.impl;

import com.tour.app.das.IPackageItineraryDao;
import com.tour.app.entity.PackageItinerary;
import com.tour.app.utilities.DatabaseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public class PackageItineraryDaoImpl implements IPackageItineraryDao {

    @Autowired
    @Qualifier("mysql")
    NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public PackageItinerary addPackageItinerary(PackageItinerary packageItinerary) {

        String query = DatabaseUtil.getInsertQuery(PackageItinerary.class);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(query, DatabaseUtil.getParameterSource(packageItinerary), keyHolder,
                new String[]{"id"});
        packageItinerary.setId(new BigInteger(keyHolder.getKey().toString()));

        return packageItinerary;
    }
}
