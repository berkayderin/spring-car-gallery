package com.berkayderin.controller;

import com.berkayderin.dto.DtoAccount;
import com.berkayderin.dto.DtoAccountIU;

public interface IRestAccountController {

    public RootEntity<DtoAccount> saveAccount(DtoAccountIU dtoAccountIU);
}
