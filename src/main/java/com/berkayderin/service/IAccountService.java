package com.berkayderin.service;

import com.berkayderin.dto.DtoAccount;
import com.berkayderin.dto.DtoAccountIU;

public interface IAccountService {

    public DtoAccount saveAccount(DtoAccountIU dtoAccountIU);
}
