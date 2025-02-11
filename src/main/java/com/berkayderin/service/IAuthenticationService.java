package com.berkayderin.service;

import com.berkayderin.dto.AuthRequest;
import com.berkayderin.dto.AuthResponse;
import com.berkayderin.dto.DtoUser;
import com.berkayderin.dto.RefreshTokenRequest;

public interface IAuthenticationService {

    public DtoUser register(AuthRequest input);

    public AuthResponse authenticate(AuthRequest input);

    public AuthResponse refreshToken(RefreshTokenRequest input);
}
