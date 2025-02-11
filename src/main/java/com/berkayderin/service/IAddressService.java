package com.berkayderin.service;

import com.berkayderin.dto.DtoAddress;
import com.berkayderin.dto.DtoAddressIU;

public interface IAddressService {

    public DtoAddress saveAddress(DtoAddressIU dtoAddressIU);
}
