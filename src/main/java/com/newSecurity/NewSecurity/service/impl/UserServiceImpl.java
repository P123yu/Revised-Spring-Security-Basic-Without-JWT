package com.newSecurity.NewSecurity.service.impl;

import com.newSecurity.NewSecurity.DTO.Login;
import com.newSecurity.NewSecurity.model.User;
import com.newSecurity.NewSecurity.repository.UserRepository;
import com.newSecurity.NewSecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User register(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User saveUser=userRepository.save(user);
        return saveUser;
    }

    @Override
    public User getByUserId(Long userId) {
       User user= userRepository.findById(userId).orElse(null);
       return user;
    }

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public Authentication login(Login login) {
        System.out.println(login.getUsernameOrEmail()+" "+login.getPassword());
        UsernamePasswordAuthenticationToken userPasswordAuthToken=new UsernamePasswordAuthenticationToken(login.getUsernameOrEmail(), login.getPassword());
        Authentication auth=authenticationManager.authenticate(userPasswordAuthToken);
        return auth;
    }


}
