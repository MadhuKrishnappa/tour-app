package com.tour.app.das.impl;

import com.tour.app.das.IPackageTypeMappingDao;
import com.tour.app.entity.PackageTypeMapping;
import com.tour.app.entity.Packages;
import com.tour.app.utilities.DatabaseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public class PackageTypeMappingDaoImpl implements IPackageTypeMappingDao {

    @Autowired
    @Qualifier("mysql")
    NamedParameterJdbcTemplate jdbcTemplate;


    @Override
    public PackageTypeMapping add(PackageTypeMapping packageTypeMapping) {

        String query = DatabaseUtil.getInsertQuery(PackageTypeMapping.class);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(query, DatabaseUtil.getParameterSource(packageTypeMapping), keyHolder,
                new String[]{"id"});
        packageTypeMapping.setId(new BigInteger(keyHolder.getKey().toString()));

        return packageTypeMapping;
    }
}
