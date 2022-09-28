package com.example.security.jwt;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UsernameAndPasswordAuthenticationRequest {

    private String username;

    private String password;
}
