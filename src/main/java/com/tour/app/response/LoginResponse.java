package com.tour.app.response;

import com.tour.app.framework.model.UserContext;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class LoginResponse implements IResponse{


    public UserContext userContext;
}
