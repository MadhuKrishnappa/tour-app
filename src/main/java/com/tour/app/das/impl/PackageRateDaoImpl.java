package com.tour.app.das.impl;

import com.tour.app.das.IPackageRateDao;
import com.tour.app.entity.PackageRates;
import com.tour.app.utilities.DatabaseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.math.BigInteger;
import java.util.List;


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

    @Override
    public List<PackageRates> getByPackageId(BigInteger packageId) {

        String query = " select * from  package_rates pr \n" +
                        "where pr.status = 'ACTIVE'\n" +
                        "and pr.package_id = :packageId ; ";
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("packageId", packageId);

        return  jdbcTemplate.query(query, map, new BeanPropertyRowMapper<>(PackageRates.class));
    }
}
