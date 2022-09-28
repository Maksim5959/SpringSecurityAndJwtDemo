package com.example.security.repository;

import com.example.security.auth.ApplicationUser;

import java.util.Optional;

public interface UserDAO {
    Optional<ApplicationUser> selectUser(String username);
}
