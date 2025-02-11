package com.berkayderin.controller;

import com.berkayderin.dto.AuthRequest;
import com.berkayderin.dto.DtoUser;

public interface IRestAuthenticationController {

    public RootEntity<DtoUser> register(AuthRequest input);
}
