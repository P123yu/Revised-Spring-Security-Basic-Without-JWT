package com.newSecurity.NewSecurity.controller;

import com.newSecurity.NewSecurity.DTO.Login;
import com.newSecurity.NewSecurity.model.User;
import com.newSecurity.NewSecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?>register(@RequestBody  User user){
        User userSave=userService.register(user);
        if(userSave !=null){
            return ResponseEntity.ok(userSave);
        }
        else{
            return ResponseEntity.badRequest().body("Username or Email already exists!");
        }
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        User user=userService.getByUserId(id);
        if(user !=null){
            return ResponseEntity.ok(user);
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/get")
    private ResponseEntity<?>get(){
        return ResponseEntity.ok("Hello, User!");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Login login){
        System.out.println(String.valueOf(login)+"login");
        Authentication auth =userService.login(login);
        if(auth !=null){
            return ResponseEntity.ok(auth.getPrincipal());
        }
        else{
            return ResponseEntity.badRequest().body("Invalid credentials!");
        }
    }
}
