package com.newSecurity.NewSecurity.service;
import com.newSecurity.NewSecurity.model.User;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import com.newSecurity.NewSecurity.DTO.Login;

@Component
public interface UserService{

    // register
    User register(User user);

    // getById
    User getByUserId(Long userId);

    // login
    Authentication login(Login login);



}
