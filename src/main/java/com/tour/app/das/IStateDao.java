package com.tour.app.das;

import com.tour.app.entity.State;

import java.math.BigInteger;

public interface IStateDao {
    State getByStateId(BigInteger stateId);
}
