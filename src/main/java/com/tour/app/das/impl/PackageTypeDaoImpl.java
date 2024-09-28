package com.tour.app.das.impl;

import com.tour.app.das.IPackageTypeDao;
import com.tour.app.entity.PackageType;
import com.tour.app.model.enums.PackageTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Repository
public class PackageTypeDaoImpl implements IPackageTypeDao {

    @Autowired
    @Qualifier("mysql")
    NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public PackageType getByPackageType(PackageTypeEnum packageType) {

        String query = "select * from package_types where package_type = :packageType ";

        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("packageType", packageType.toString());

        List<PackageType> data = jdbcTemplate.query(query, source, new BeanPropertyRowMapper<>(PackageType.class));

        if(CollectionUtils.isEmpty(data)){
            return null;
        }

        return data.get(0);

    }
}
