package com.newSecurity.NewSecurity.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Login {
    private String usernameOrEmail;
    private String password;
}
