package com.tour.app.das.impl;

import com.tour.app.das.IPackageThemeMappingDao;
import com.tour.app.entity.PackageThemeMapping;
import com.tour.app.utilities.DatabaseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public class PackageThemeMappingDaoImpl implements IPackageThemeMappingDao {

    @Autowired
    @Qualifier("mysql")
    NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public PackageThemeMapping add(PackageThemeMapping packageThemeMapping) {

        String query = DatabaseUtil.getInsertQuery(PackageThemeMapping.class);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(query, DatabaseUtil.getParameterSource(packageThemeMapping), keyHolder,
                new String[]{"id"});
        packageThemeMapping.setId(new BigInteger(keyHolder.getKey().toString()));

        return packageThemeMapping;
    }
}
