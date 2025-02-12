package com.berkayderin.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.berkayderin.controller.IRestCustomerController;
import com.berkayderin.controller.RestBaseController;
import com.berkayderin.controller.RootEntity;
import com.berkayderin.dto.DtoCustomer;
import com.berkayderin.dto.DtoCustomerIU;
import com.berkayderin.service.ICustomerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class RestCustomerControllerImpl extends RestBaseController implements IRestCustomerController {

    @Autowired
    private ICustomerService customerService;

    @PostMapping("/customer")
    @Override
    public RootEntity<DtoCustomer> saveCustomer(@Valid @RequestBody DtoCustomerIU dtoCustomerIU) {
        return ok(customerService.saveCustomer(dtoCustomerIU));
    }

}
