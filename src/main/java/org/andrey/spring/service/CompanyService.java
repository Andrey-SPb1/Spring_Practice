package org.andrey.spring.service;

public class CompanyService {

    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
