package com.tour.app.das.impl;

import com.tour.app.das.IPackageDao;
import com.tour.app.entity.FetchPackageList;
import com.tour.app.entity.Packages;
import com.tour.app.request.FetchPackageRequest;
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
import java.util.ArrayList;
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

    @Override
    public List<FetchPackageList> getPackageListingByFilter(FetchPackageRequest fetchPackageRequest) {

        MapSqlParameterSource source = new MapSqlParameterSource();
        String query =  " select  p.id as package_id, p.package_name, p.package_code, p.duration_days, p.duration_nights, p.package_rating, \n" +
                "p.package_reviews, p.tour_includes , p.package_list_images, GROUP_CONCAT(distinct c3.name) as departure_cities,\n" +
                "GROUP_CONCAT(DISTINCT pdcdm.departure_date) as departure_dates,MIN(pr.adult_rate) as min_package_price,\n" +
                "GROUP_CONCAT(DISTINCT pt.package_type) as package_types, GROUP_CONCAT(DISTINCT pt2.theme_type) as package_themes,\n" +
                "p.status, p.created_at , p.updated_at, GROUP_CONCAT(distinct c3.id) as departure_city_ids \n" +
                "from packages p \n" +
                "join package_type_mappings ptm on p.id = ptm.package_id and ptm.status = 'ACTIVE'\n" +
                "join package_types pt on pt.id = ptm.package_type_id and pt.status = 'ACTIVE'\n" +
                "join package_theme_mappings ptm2 on p.id = ptm2.package_id and ptm2.status = 'ACTIVE'\n" +
                "join package_themes pt2 on pt2.id = ptm2.package_theme_id and pt2.status = 'ACTIVE'\n" +
                "join package_touring_city_mappings ptcm on ptcm.package_id = p.id and ptcm.status = 'ACTIVE'\n" +
                "join cities c on c.id = ptcm.city_id and c.status = 'ACTIVE'\n" +
                "join states s on s.id = c.state_id and s.status = 'ACTIVE'\n" +
                "join countries c2 on c2.id = s.country_id and c2.status = 'ACTIVE'\n" +
                "join package_rates pr on pr.package_id = p.id and pr.status = 'ACTIVE'\n" +
                "join package_departure_city_date_mappings pdcdm on pdcdm.package_id = p.id and pdcdm.status = 'ACTIVE'\n" +
                "JOIN cities c3 on c3.id = pdcdm.city_id \n" +
                "where true \n" ;
        if(fetchPackageRequest != null && !CollectionUtils.isEmpty(fetchPackageRequest.getPackageTypes())) {
            source.addValue("packageTypes", fetchPackageRequest.getPackageTypes());
           query += " and pt.package_type in (:packageTypes) \n" ;
        }

        if(fetchPackageRequest != null && !CollectionUtils.isEmpty(fetchPackageRequest.getPackageThemes())) {
            source.addValue("packageThemes", fetchPackageRequest.getPackageThemes());
            query += " and pt2.theme_type in (:packageThemes) \n" ;
        }

        if(fetchPackageRequest != null && !CollectionUtils.isEmpty(fetchPackageRequest.getPackageIds())) {
            source.addValue("packageIds", fetchPackageRequest.getPackageIds());
            query += " and p.id in (:packageIds) \n" ;
        }
        if (fetchPackageRequest != null && !CollectionUtils.isEmpty(fetchPackageRequest.getCityIds())){
            source.addValue("cityIds", fetchPackageRequest.getCityIds());
            query += " and c.id in (:cityIds) \n" ;
        }
        if (fetchPackageRequest != null && !CollectionUtils.isEmpty(fetchPackageRequest.getStateIds())){
            source.addValue("stateIds", fetchPackageRequest.getStateIds());
            query += " and s.id in (:stateIds) \n" ;
        }
        if (fetchPackageRequest != null && !CollectionUtils.isEmpty(fetchPackageRequest.getCountryIds())){
            source.addValue("countryIds", fetchPackageRequest.getCountryIds());
            query += " and c2.id in (:countryIds) \n" ;
        }
        if(!CollectionUtils.isEmpty(fetchPackageRequest.getStatuses())){
            source.addValue("statuses", fetchPackageRequest.getStatuses());
            query += " and p.status in (:statuses) ";
        }
        if(fetchPackageRequest.getDurationNights() != null && fetchPackageRequest.getDurationNights().getFrom() > 0
                && fetchPackageRequest.getDurationNights().getTo() > 0){
            source.addValue("from", fetchPackageRequest.getDurationNights().getFrom());
            source.addValue("to", fetchPackageRequest.getDurationNights().getTo());
            query += " and p.duration_nights BETWEEN :from and :to ";
        }
        if(fetchPackageRequest.getFilterPackagePrice() != null){
            source.addValue("filterPackagePrice", fetchPackageRequest.getFilterPackagePrice());
            query += " and pr.adult_rate <= :filterPackagePrice ";
        }


        query += "group by p.id;";

        System.out.println(query);

        List<FetchPackageList> data = jdbcTemplate.query(query, source, new BeanPropertyRowMapper<>(FetchPackageList.class));

        if(CollectionUtils.isEmpty(data)){
            return new ArrayList<>();
        }

        return data;

    }
}
