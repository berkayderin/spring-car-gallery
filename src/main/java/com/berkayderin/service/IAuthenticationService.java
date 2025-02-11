package com.berkayderin.service;

import com.berkayderin.dto.AuthRequest;
import com.berkayderin.dto.AuthResponse;
import com.berkayderin.dto.DtoUser;

public interface IAuthenticationService {

    public DtoUser register(AuthRequest input);

    public AuthResponse authenticate(AuthRequest input);
}
