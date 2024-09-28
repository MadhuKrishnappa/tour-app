package com.tour.app.framework.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;


@Setter
@Getter
@ToString
public class UserContext implements Serializable {

	private static final long serialVersionUID = 1L;
	private BigInteger userId;
	private String userName;
	private String name;
	private String userProfileImage;
	private Date signInTime;
	private String emailId;
	private String mobileNumber;
	transient private String uuid; 
	transient private RequestPaginationToken requestPaginationToken;
	transient private ResponsePaginationToken responsePaginationToken;

 
}
