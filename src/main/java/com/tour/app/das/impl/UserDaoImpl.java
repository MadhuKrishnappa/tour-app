package com.tour.app.das.impl;

import com.tour.app.das.IUserDao;
import com.tour.app.entity.Packages;
import com.tour.app.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.List;


@Repository
public class UserDaoImpl implements IUserDao {

    @Autowired
    @Qualifier("mysql")
    NamedParameterJdbcTemplate jdbcTemplate;


    @Override
    public Users getByUserNameAndPassword(String userName, String password) {



        String query = "select * from users where username = :username and password = :password and status = '1' ";

        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("username", userName);
        source.addValue("password", password);

        List<Users> data = jdbcTemplate.query(query, source, new BeanPropertyRowMapper<>(Users.class));

        if(CollectionUtils.isEmpty(data)){
            return null;
        }

        return data.get(0);
    }
}
