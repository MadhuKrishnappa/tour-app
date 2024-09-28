package com.tour.app.das.impl;

import com.tour.app.das.IReportingAndDroppingDao;
import com.tour.app.entity.ReportingAndDroppingDetail;
import com.tour.app.utilities.DatabaseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

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
}
