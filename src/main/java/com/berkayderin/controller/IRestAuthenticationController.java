package com.berkayderin.controller;

import com.berkayderin.dto.AuthRequest;
import com.berkayderin.dto.AuthResponse;
import com.berkayderin.dto.DtoUser;
import com.berkayderin.dto.RefreshTokenRequest;

public interface IRestAuthenticationController {

    public RootEntity<DtoUser> register(AuthRequest input);

    public RootEntity<AuthResponse> authenticate(AuthRequest input);

    public RootEntity<AuthResponse> refreshToken(RefreshTokenRequest input);
}
