package com.tour.app.common.controller;


import com.tour.app.request.FetchPackageRequest;
import com.tour.app.response.FetchHomePageSectionResponse;
import com.tour.app.response.FetchPackageResponse;
import com.tour.app.response.ResponseStatus;
import com.tour.app.response.ServiceResponse;
import com.tour.app.services.IHomeSectionService;
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
@RequestMapping("/v1/home")
public class HomePageController {


    @Autowired
    IHomeSectionService homeSectionService;

    @RequestMapping(value = "/fetchSections", method = RequestMethod.GET)
    public @ResponseBody
    ServiceResponse<FetchHomePageSectionResponse> fetchSections(HttpServletRequest httpServletRequest) throws Exception {


        ServiceResponse<FetchHomePageSectionResponse> response = new ServiceResponse<>();
        ResponseStatus status = new ResponseStatus();

        try {

            response.setResponse(homeSectionService.fetchHomeSections());
            status.setCode(HttpStatus.OK.value());
            status.setMessage("Home Section Fetched Successfully");
        }catch (Exception e){
            e.printStackTrace();
            status.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            status.setMessage(e.getMessage());
        }
        response.setStatus(status);
        return response;
    }
}
