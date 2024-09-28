package com.tour.app.services;

import com.tour.app.request.LoginRequest;
import com.tour.app.response.LoginResponse;

public interface ILoginService {
    LoginResponse userLogin(LoginRequest loginRequest) throws Exception;
}
