package com.tour.app.common.controller;


import com.tour.app.request.LoginRequest;
import com.tour.app.response.LoginResponse;
import com.tour.app.response.ResponseStatus;
import com.tour.app.response.ServiceResponse;
import com.tour.app.services.ILoginService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Component
@Controller
@RequestMapping("/v1/login")
public class UserLoginController {


    @Autowired
    ILoginService loginService;

    @RequestMapping(value = "/adminUser", method = RequestMethod.POST)
    public @ResponseBody
    ServiceResponse<LoginResponse> fetchPackages(HttpServletRequest request,
                                @RequestBody LoginRequest loginRequest) throws Exception {



       ServiceResponse response = new ServiceResponse();
        ResponseStatus status = new ResponseStatus();
        try {
            LoginResponse  loginResponse = loginService.userLogin(loginRequest);
            response.setResponse(loginResponse);
            status.setCode(HttpStatus.OK.value());
            status.setMessage("Login Successful");
        }catch (Exception e){
            e.printStackTrace();
            status.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            status.setMessage(e.getMessage());
        }
        response.setStatus(status);

        return response;
    }

}
