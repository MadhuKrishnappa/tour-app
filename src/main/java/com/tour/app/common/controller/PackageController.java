package com.tour.app.common.controller;


import com.tour.app.model.vo.TourPackageVO;
import com.tour.app.request.AddPackageRequest;
import com.tour.app.request.FetchPackageRequest;
import com.tour.app.response.AddPackageResponse;
import com.tour.app.response.ResponseStatus;
import com.tour.app.response.ServiceResponse;
import com.tour.app.services.IPackageService;
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
@RequestMapping("/v1/packages")
public class PackageController {

    @Autowired
    IPackageService packageService;




    @RequestMapping(value = "/fetch", method = RequestMethod.POST)
    public @ResponseBody
    TourPackageVO fetchPackages(HttpServletRequest request,
                                @RequestBody FetchPackageRequest fetchPackageRequest) throws Exception {

        TourPackageVO tourPackageVO = packageService.fetchPackages(fetchPackageRequest);

        return null;
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public @ResponseBody
    ServiceResponse<AddPackageResponse> addPackage(HttpServletRequest httpServletRequest,
                                                   @RequestBody AddPackageRequest addPackageRequest) throws Exception {

        ServiceResponse<AddPackageResponse> response = new ServiceResponse<>();
        ResponseStatus status = new ResponseStatus();

        try {
            packageService.addPackages(addPackageRequest);
            status.setCode(HttpStatus.OK.value());
            status.setMessage("Package Successful Created");
        }catch (Exception e){
            e.printStackTrace();
            status.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            status.setMessage(e.getMessage());
        }
        response.setStatus(status);

        return response;
    }




}
