package com.tour.app.das;

import com.tour.app.entity.City;

import java.math.BigInteger;
import java.util.List;

public interface ICityDao {
    List<City> getByIds(List<BigInteger> cityIds);



}
