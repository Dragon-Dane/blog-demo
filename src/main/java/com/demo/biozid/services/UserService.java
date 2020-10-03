package com.demo.biozid.services;

import com.demo.biozid.dtos.UserRegistrationDto;
import com.demo.biozid.models.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User findByEmail(String email);

    User save(UserRegistrationDto registration);
}
