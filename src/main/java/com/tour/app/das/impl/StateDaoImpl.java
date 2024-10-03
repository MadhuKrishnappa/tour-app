package com.tour.app.das.impl;

import com.tour.app.das.IStateDao;
import com.tour.app.entity.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.math.BigInteger;
import java.util.List;

@Repository
public class StateDaoImpl implements IStateDao {

    @Autowired
    @Qualifier("mysql")
    NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public State getByStateId(BigInteger stateId) {

        String query = " select * from states where id = :stateId ";
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("stateId", stateId);
        List<State> dataList = jdbcTemplate.query(query, map, new BeanPropertyRowMapper<>(State.class));
        if(CollectionUtils.isEmpty(dataList)){
            return null;
        }
        return dataList.get(0);

    }
}
