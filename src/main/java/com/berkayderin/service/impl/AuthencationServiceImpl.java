package com.berkayderin.service.impl;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.berkayderin.dto.AuthRequest;
import com.berkayderin.dto.DtoUser;
import com.berkayderin.model.User;
import com.berkayderin.repository.UserRepository;
import com.berkayderin.service.IAuthenticationService;

@Service
public class AuthencationServiceImpl implements IAuthenticationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    private User createUser(AuthRequest input) {
        User user = new User();
        user.setCreateTime(new Date());
        user.setUsername(input.getUsername());
        user.setPassword(passwordEncoder.encode(input.getPassword()));

        return user;
    }

    @Override
    public DtoUser register(AuthRequest input) {
        DtoUser dtoUser = new DtoUser();

        User user = createUser(input);
        userRepository.save(user);

        BeanUtils.copyProperties(user, dtoUser);
        return dtoUser;
    }

}
