package com.mesay.springsecuritydemo.service;

import com.mesay.springsecuritydemo.model.User;
import com.mesay.springsecuritydemo.web.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface UserService extends UserDetailsService{
    User save(UserRegistrationDto registrationDto);
}