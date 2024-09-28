package com.tour.app.das.impl;

import com.tour.app.das.IPackageRateDao;
import com.tour.app.entity.PackageRates;
import com.tour.app.utilities.DatabaseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;


@Repository
public class PackageRateDaoImpl implements IPackageRateDao {


    @Autowired
    @Qualifier("mysql")
    NamedParameterJdbcTemplate jdbcTemplate;


    @Override
    public PackageRates addPackageRates(PackageRates packageRates) {

        String query = DatabaseUtil.getInsertQuery(PackageRates.class);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(query, DatabaseUtil.getParameterSource(packageRates), keyHolder,
                new String[]{"id"});
        packageRates.setId(new BigInteger(keyHolder.getKey().toString()));

        return packageRates;
    }
}
