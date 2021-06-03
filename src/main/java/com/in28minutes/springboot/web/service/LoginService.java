package com.in28minutes.springboot.web.service;

import org.springframework.stereotype.Component;

@Component
public class LoginService {
    public boolean isValid(String user, String password) {
        return user.equalsIgnoreCase("AB") && password.equalsIgnoreCase("ab123");
    }
}
