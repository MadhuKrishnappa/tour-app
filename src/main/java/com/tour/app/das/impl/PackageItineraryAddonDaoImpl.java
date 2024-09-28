package com.tour.app.das.impl;

import com.tour.app.das.IPackageItineraryAddonDao;
import com.tour.app.entity.PackageItineraryAddon;
import com.tour.app.utilities.DatabaseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public class PackageItineraryAddonDaoImpl implements IPackageItineraryAddonDao {

    @Autowired
    @Qualifier("mysql")
    NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public PackageItineraryAddon add(PackageItineraryAddon itineraryAddon) {

        String query = DatabaseUtil.getInsertQuery(PackageItineraryAddon.class);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(query, DatabaseUtil.getParameterSource(itineraryAddon), keyHolder,
                new String[]{"id"});
        itineraryAddon.setId(new BigInteger(keyHolder.getKey().toString()));

        return itineraryAddon;
    }
}
