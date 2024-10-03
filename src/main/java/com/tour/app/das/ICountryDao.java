package com.tour.app.das;

import com.tour.app.entity.Country;

import java.math.BigInteger;

public interface ICountryDao {
    Country getById(BigInteger countryId);
}
