package com.tour.app.das.impl;

import com.tour.app.das.IPackageDao;
import com.tour.app.entity.Packages;
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
public class PackageDaoImpl implements IPackageDao {


    @Autowired
    @Qualifier("mysql")
    NamedParameterJdbcTemplate jdbcTemplate;


    @Override
    public Packages getPackageById(int packageId) {

        String query = "select * from packages where id = :packageId ";

        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("packageId", packageId);

        List<Packages> data = jdbcTemplate.query(query, source, new BeanPropertyRowMapper<>(Packages.class));

        if(CollectionUtils.isEmpty(data)){
            return null;
        }

        return data.get(0);
    }

    @Override
    public Packages addPackage(Packages packages) {

        String query = DatabaseUtil.getInsertQuery(Packages.class);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(query, DatabaseUtil.getParameterSource(packages), keyHolder,
                new String[]{"id"});
        packages.setId(new BigInteger(keyHolder.getKey().toString()));

        return packages;
    }
}
