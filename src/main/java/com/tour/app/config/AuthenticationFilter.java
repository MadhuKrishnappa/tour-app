package com.tour.app.config;

import com.auth0.jwt.interfaces.Claim;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.tour.app.cache.ICache;
import com.tour.app.model.UserBO;
import com.tour.app.response.IResponse;
import com.tour.app.response.ResponseStatus;
import com.tour.app.response.ServiceResponse;
import com.tour.app.utilities.JWTUtils;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.util.Map;
import java.util.UUID;


public class AuthenticationFilter implements Filter {


    @Autowired
    ICache cache;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @SneakyThrows
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        MultiReadHttpServletRequest multiReadRequest = new MultiReadHttpServletRequest((HttpServletRequest) request);

        // record time taken to execute the request
        long start = System.currentTimeMillis();
        MDC.put("requestTime",String.valueOf(start));



        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        UUID globalRequestId = UUID.randomUUID();
        MDC.put("GlobalRequestId", globalRequestId.toString());

        System.out.println("httpRequest.getRequestURI() : "+ httpRequest.getRequestURI());

        if (false && !httpRequest.getRequestURI().equals("/v1/login/adminUser") &&
                !httpRequest.getRequestURI().equals("/v1/packages/add") &&
                !httpRequest.getRequestURI().equals("/v1/logout")){

            String token = httpRequest.getHeader("token");
            String tokenId = httpRequest.getHeader("tokenId");
            if (token == null || tokenId == null) {
                buildErrorResponse(httpResponse, "Token/TokenId not found", null);
                return;
            }
            String key = (String) cache.get(tokenId);
            if (key == null) {
                buildErrorResponse(httpResponse, "Invalid tokenId", null);
                return;
            }

            Map<String, Claim> claims = null;
            try {
                claims = JWTUtils.checkToken(token, key);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (CollectionUtils.isEmpty(claims)) {
                buildErrorResponse(httpResponse, "Invalid token", null);
                return;
            }
            String userBOString = (String) cache.get(key);
            UserBO userBO = new Gson().fromJson(userBOString, UserBO.class);

            httpRequest.setAttribute("user", userBO);
            cache.put(tokenId, key, 2);
        }
        chain.doFilter(multiReadRequest, response);
    }

    private void buildErrorResponse(HttpServletResponse httpResponse, String message, HttpStatus customErrorCode)
            throws IOException {

        long start = System.currentTimeMillis();
        httpResponse.setStatus(HttpStatus.OK.value());
        ServiceResponse<IResponse> serviceResponse = new ServiceResponse<>();
        serviceResponse.setStatus(new ResponseStatus(customErrorCode == null ? 401 : customErrorCode.value(), message));

        ObjectMapper mapper = new ObjectMapper();
        httpResponse.getWriter().write(mapper.writeValueAsString(serviceResponse));
        //log.info("AuthenticationFilter_DEBUG: TimeTakenIn buildErrorResponse is {} ms", System.currentTimeMillis() - start);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
