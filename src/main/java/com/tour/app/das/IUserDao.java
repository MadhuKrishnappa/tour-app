package com.tour.app.das;

import com.tour.app.entity.Users;

public interface IUserDao {
    Users getByUserNameAndPassword(String userName, String password);
}
