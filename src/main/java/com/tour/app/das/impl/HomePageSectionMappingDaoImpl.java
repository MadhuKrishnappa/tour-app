package com.tour.app.das.impl;

import com.tour.app.das.IHomePageSectionMappingDao;
import com.tour.app.entity.HomePageSectionMapping;
import com.tour.app.entity.HomeSectionPackage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Repository
public class HomePageSectionMappingDaoImpl implements IHomePageSectionMappingDao {


    @Autowired
    @Qualifier("mysql")
    NamedParameterJdbcTemplate jdbcTemplate;


    @Override
    public List<HomePageSectionMapping> getByHomePageSectionId(BigInteger homePageSectionId) {

        String query = " select * from home_page_section_mappings where home_page_section_id = :homePageSectionId ";
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("homePageSectionId", homePageSectionId);

        return jdbcTemplate.query(query, map, new BeanPropertyRowMapper<>(HomePageSectionMapping.class));
    }

    @Override
    public List<HomeSectionPackage> getGroupByState(List<BigInteger> groupByIds) {

        String query = " select s.id, s.name, GROUP_CONCAT(DISTINCT hpsm.ranking) as ranking, MAX(p.duration_days) duration_days,\n" +
                "MIN(pr.adult_rate) min_price, COUNT(DISTINCT p.id) total_packages,\n" +
                "AVG(DISTINCTROW p.package_rating) as total_ratings,\n" +
                "sum(DISTINCTROW p.package_reviews) as total_reviews\n" +
                "from home_page_section_mappings hpsm \n" +
                "join states s on s.id = hpsm.group_by_id and s.status = 'ACTIVE' \n" +
                "join cities c on c.state_id = s.id and c.status = 'ACTIVE'\n" +
                "join package_touring_city_mappings ptcm on ptcm.city_id = c.id and ptcm.status = 'ACTIVE'\n" +
                "join packages p on p.id = ptcm.package_id \n" +
                "join package_rates pr on pr.package_id = p.id\n" +
                "where hpsm.status = 'ACTIVE'\n" +
                "and hpsm.group_by_id in (:groupByIds)\n" +
                "GROUP by s.id \n" +
                "ORDER by ranking ASC ;  ";
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("groupByIds", groupByIds);

        List<HomeSectionPackage> data = jdbcTemplate.query(query, map, new BeanPropertyRowMapper<>(HomeSectionPackage.class));
        if(CollectionUtils.isEmpty(data)){
            return new ArrayList<>();
        }
        return data;
    }

    @Override
    public List<HomeSectionPackage> getGroupByCountry(List<BigInteger> groupByIds) {

        String query = " select c2.id, c2.name, GROUP_CONCAT(DISTINCT hpsm.ranking) as ranking, MAX(p.duration_days) duration_days,\n" +
                "MIN(pr.adult_rate) min_price, COUNT(DISTINCT p.id) total_packages,\n" +
                "AVG(DISTINCTROW p.package_rating) as total_ratings,\n" +
                "sum(DISTINCTROW p.package_reviews) as total_reviews\n" +
                "from home_page_section_mappings hpsm \n" +
                "join countries c2 on c2.id = hpsm.group_by_id and c2.status = 'ACTIVE'\n" +
                "join states s on s.country_id = c2.id and s.status = 'ACTIVE'\n" +
                "join cities c on c.state_id = s.id and c.status = 'ACTIVE'\n" +
                "join package_touring_city_mappings ptcm on ptcm.city_id = c.id and ptcm.status = 'ACTIVE'\n" +
                "join packages p on p.id = ptcm.package_id \n" +
                "join package_rates pr on pr.package_id = p.id\n" +
                "where hpsm.status = 'ACTIVE' " +
                "and hpsm.group_by_id in (:groupByIds)\n" +
                "GROUP by c2.id \n" +
                "ORDER by ranking ASC ; ";
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("groupByIds", groupByIds);

        List<HomeSectionPackage> data = jdbcTemplate.query(query, map, new BeanPropertyRowMapper<>(HomeSectionPackage.class));
        if(CollectionUtils.isEmpty(data)){
            return new ArrayList<>();
        }
        return data;
    }

    @Override
    public Collection<? extends HomeSectionPackage> getByPackageThemes(List<BigInteger> groupByIds) {

        String query = " select p.id, p.package_name as name, 1 as ranking, p.duration_days, MIN(pr.adult_rate) as min_price,\n" +
                "1 as total_packages, p.package_rating as total_ratings, p.package_reviews as total_reviews, 0 as discount_percentage\n" +
                "from home_page_section_mappings hpsm \n" +
                "join package_themes pt on hpsm.group_by_id = pt.id\n" +
                "join package_theme_mappings ptm on ptm.package_theme_id  = pt.id and ptm.status = 'ACTIVE'\n" +
                "join packages p on p.id = ptm.package_id and p.status = 'ACTIVE'\n" +
                "join package_rates pr on pr.package_id = p.id and pr.status = 'ACTIVE'\n" +
                "where pt.status = 'ACTIVE'\n" +
                "and hpsm.group_by_id in (:groupByIds)\n" +
                "group by p.id\n" +
                "ORDER by p.updated_at desc; ";
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("groupByIds", groupByIds);

        List<HomeSectionPackage> data = jdbcTemplate.query(query, map, new BeanPropertyRowMapper<>(HomeSectionPackage.class));
        if(CollectionUtils.isEmpty(data)){
            return new ArrayList<>();
        }
        return data;
    }
}
