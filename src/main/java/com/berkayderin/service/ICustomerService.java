package com.berkayderin.service;

import com.berkayderin.dto.DtoCustomer;
import com.berkayderin.dto.DtoCustomerIU;

public interface ICustomerService {

    public DtoCustomer saveCustomer(DtoCustomerIU dtoCustomerIU);
}
