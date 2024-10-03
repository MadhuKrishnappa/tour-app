package com.tour.app.das.impl;

import com.tour.app.das.IReportingAndDroppingDao;
import com.tour.app.entity.ReportingAndDroppingDetail;
import com.tour.app.utilities.DatabaseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public class ReportingAndDroppingDaoImpl implements IReportingAndDroppingDao {


    @Autowired
    @Qualifier("mysql")
    NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public ReportingAndDroppingDetail add(ReportingAndDroppingDetail reportingAndDroppingDetail) {

        String query = DatabaseUtil.getInsertQuery(ReportingAndDroppingDetail.class);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(query, DatabaseUtil.getParameterSource(reportingAndDroppingDetail), keyHolder,
                new String[]{"id"});
        reportingAndDroppingDetail.setId(new BigInteger(keyHolder.getKey().toString()));

        return reportingAndDroppingDetail;
    }

    @Override
    public List<ReportingAndDroppingDetail> getByPackageId(BigInteger packageId) {

        String query = " select * from reporting_and_dropping_details   where package_id = :packageId and status  = 'ACTIVE'; ";
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("packageId", packageId);
        return jdbcTemplate.query(query, map, new BeanPropertyRowMapper<>(ReportingAndDroppingDetail.class));
    }
}
