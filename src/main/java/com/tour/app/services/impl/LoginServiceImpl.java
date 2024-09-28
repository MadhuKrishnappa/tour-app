package com.tour.app.services.impl;

import com.tour.app.das.IUserDao;
import com.tour.app.entity.Users;
import com.tour.app.framework.model.UserContext;
import com.tour.app.request.LoginRequest;
import com.tour.app.response.LoginResponse;
import com.tour.app.services.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements ILoginService {


    @Autowired
    IUserDao userDao;

    @Override
    public LoginResponse userLogin(LoginRequest loginRequest) throws Exception {

        validateLoginRequest(loginRequest);


        Users users = userDao.getByUserNameAndPassword(loginRequest.getUserName(), loginRequest.getPassword());
        if(users == null){
            throw new Exception("Invalid User credentials");
        }

        LoginResponse response = new LoginResponse();
        UserContext userContext = new UserContext();
        userContext.setUserId(users.getId());
        userContext.setEmailId(users.getEmail());
        userContext.setUserName(users.getUsername());
        userContext.setName(users.getName());
        userContext.setMobileNumber(users.contactNumber);
        response.setUserContext(userContext);

        return response;
    }

    private void validateLoginRequest(LoginRequest loginRequest) throws Exception {


        if(loginRequest == null){
            throw new Exception("Login request is mandatory");
        }

        if(loginRequest.getUserName() == null){
            throw new Exception("UserName is mandatory");
        }

        if(loginRequest.getPassword() == null){
            throw new Exception("Password is mandatory");
        }
    }
}
