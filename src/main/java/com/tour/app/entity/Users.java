package com.tour.app.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigInteger;
import java.util.Date;

@Setter
@Getter
@ToString
@NoArgsConstructor
@Table(name = "users")
public class Users {

    @Column(name = "id")
    public BigInteger id;


    @Column(name = "name")
    public String name;

    @Column(name = "username")
    public String username;

    @Column(name = "password")
    public String password;

    @Column(name = "contact_number")
    public String contactNumber;

    @Column(name = "email")
    public String email;

    @Column(name = "secondary_contact_number")
    public String secondaryContactNumber;

    @Column(name = "dob")
    public Date dob;

    @Column(name = "status")
    public String status;

    @Column(name = "verified")
    public boolean verified;

    @Column(name = "created_at")
    public Date createdAt;

    @Column(name = "updated_at")
    public Date updatedAt;
}
