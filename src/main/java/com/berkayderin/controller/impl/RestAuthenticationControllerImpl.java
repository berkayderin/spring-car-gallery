package com.berkayderin.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.berkayderin.controller.IRestAuthenticationController;
import com.berkayderin.controller.RestBaseController;
import com.berkayderin.controller.RootEntity;
import com.berkayderin.dto.AuthRequest;
import com.berkayderin.dto.DtoUser;
import com.berkayderin.service.IAuthenticationService;

import jakarta.validation.Valid;

@RestController()
public class RestAuthenticationControllerImpl extends RestBaseController implements IRestAuthenticationController {

    @Autowired
    private IAuthenticationService authenticationService;

    @PostMapping("/register")
    @Override
    public RootEntity<DtoUser> register(@Valid @RequestBody AuthRequest input) {

        return ok(authenticationService.register(input));
    }

}
