package com.dawntechbd.schoolDemo.config;

public interface SecurityService {
    String findLoggedInUsername();
    void autoLogin(String username, String password);

}
