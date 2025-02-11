package com.berkayderin.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.berkayderin.controller.IRestAddressController;
import com.berkayderin.controller.RestBaseController;
import com.berkayderin.controller.RootEntity;
import com.berkayderin.dto.DtoAddress;
import com.berkayderin.dto.DtoAddressIU;
import com.berkayderin.service.IAddressService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class RestAddressControllerImpl extends RestBaseController implements IRestAddressController {

    @Autowired
    private IAddressService addressService;

    @PostMapping("/address")
    @Override
    public RootEntity<DtoAddress> saveAddress(@Valid @RequestBody DtoAddressIU dtoAddressIU) {
        return ok(addressService.saveAddress(dtoAddressIU));
    }

}
