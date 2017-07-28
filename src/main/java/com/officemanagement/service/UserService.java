package com.officemanagement.service;


import com.officemanagement.model.Users;

/**
 * Created by Abdurahman on 7/27/2017.
 */
public interface UserService {
    public Users findUserByEmail(String email);
    public void saveUser(Users users);
}
