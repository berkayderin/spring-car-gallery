package com.berkayderin.controller;

import com.berkayderin.dto.DtoAddress;
import com.berkayderin.dto.DtoAddressIU;

public interface IRestAddressController {

    public RootEntity<DtoAddress> saveAddress(DtoAddressIU dtoAddressIU);
}
