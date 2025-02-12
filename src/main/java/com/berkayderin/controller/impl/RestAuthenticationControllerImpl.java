package com.berkayderin.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.berkayderin.controller.IRestAuthenticationController;
import com.berkayderin.controller.RestBaseController;
import com.berkayderin.controller.RootEntity;
import com.berkayderin.dto.AuthRequest;
import com.berkayderin.dto.AuthResponse;
import com.berkayderin.dto.DtoUser;
import com.berkayderin.dto.RefreshTokenRequest;
import com.berkayderin.service.IAuthenticationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;

import jakarta.validation.Valid;

@RestController
@Tag(name = "Kimlik Doğrulama", description = "Kullanıcı kimlik doğrulama işlemleri için API uç noktaları")
public class RestAuthenticationControllerImpl extends RestBaseController implements IRestAuthenticationController {

    @Autowired
    private IAuthenticationService authenticationService;

    @PostMapping("/register")
    @Operation(summary = "Kullanıcı kaydı", description = "Yeni bir kullanıcı hesabı oluşturur")
    @Override
    public RootEntity<DtoUser> register(@Valid @RequestBody AuthRequest input) {
        return ok(authenticationService.register(input));
    }

    @PostMapping("/authenticate")
    @Operation(summary = "Giriş yap", description = "Kullanıcı girişi yaparak token alır")
    @Override
    public RootEntity<AuthResponse> authenticate(@Valid @RequestBody AuthRequest input) {
        return ok(authenticationService.authenticate(input));
    }

    @PostMapping("/refreshToken")
    @Operation(summary = "Token yenile", description = "Yenileme tokeni ile yeni bir erişim tokeni alır")
    @Override
    public RootEntity<AuthResponse> refreshToken(@Valid @RequestBody RefreshTokenRequest input) {
        return ok(authenticationService.refreshToken(input));
    }

}
