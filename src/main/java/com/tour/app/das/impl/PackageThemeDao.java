package com.tour.app.das.impl;

import com.tour.app.das.IPackageThemeDao;
import com.tour.app.entity.PackageTheme;
import com.tour.app.model.enums.PackageThemeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Repository
public class PackageThemeDao implements IPackageThemeDao {


    @Autowired
    @Qualifier("mysql")
    NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public PackageTheme getByPackageTheme(PackageThemeEnum packageTheme) {

        String query = "select * from package_themes where theme_type = :packageTheme ";

        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("packageTheme", packageTheme.toString());

        List<PackageTheme> data = jdbcTemplate.query(query, source, new BeanPropertyRowMapper<>(PackageTheme.class));

        if(CollectionUtils.isEmpty(data)){
            return null;
        }

        return data.get(0);

    }
}
