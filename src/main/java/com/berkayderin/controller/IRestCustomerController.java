package com.berkayderin.controller;

import com.berkayderin.dto.DtoCustomer;
import com.berkayderin.dto.DtoCustomerIU;

public interface IRestCustomerController {

    public RootEntity<DtoCustomer> saveCustomer(DtoCustomerIU dtoCustomerIU);
}
