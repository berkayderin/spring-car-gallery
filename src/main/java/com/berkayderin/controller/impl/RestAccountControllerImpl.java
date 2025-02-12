package com.berkayderin.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.berkayderin.controller.IRestAccountController;
import com.berkayderin.controller.RestBaseController;
import com.berkayderin.controller.RootEntity;
import com.berkayderin.dto.DtoAccount;
import com.berkayderin.dto.DtoAccountIU;
import com.berkayderin.service.IAccountService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class RestAccountControllerImpl extends RestBaseController implements IRestAccountController {

    @Autowired
    private IAccountService accountService;

    @PostMapping("/account")
    @Override
    public RootEntity<DtoAccount> saveAccount(@Valid @RequestBody DtoAccountIU dtoAccountIU) {
        return ok(accountService.saveAccount(dtoAccountIU));
    }

}
