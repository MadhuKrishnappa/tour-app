package com.tour.app.das.impl;

import com.tour.app.das.IPackageTouringCityMapping;
import com.tour.app.entity.PackageTouringCityMapping;
import com.tour.app.utilities.DatabaseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public class PackageTouringCityMappingImpl implements IPackageTouringCityMapping {

    @Autowired
    @Qualifier("mysql")
    NamedParameterJdbcTemplate jdbcTemplate;


    @Override
    public PackageTouringCityMapping add(PackageTouringCityMapping packageTouringCityMapping) {

        String query = DatabaseUtil.getInsertQuery(PackageTouringCityMapping.class);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(query, DatabaseUtil.getParameterSource(packageTouringCityMapping), keyHolder,
                new String[]{"id"});
        packageTouringCityMapping.setId(new BigInteger(keyHolder.getKey().toString()));

        return packageTouringCityMapping;
    }
}
