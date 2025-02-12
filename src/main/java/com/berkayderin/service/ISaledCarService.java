package com.berkayderin.service;

import com.berkayderin.dto.DtoSaledCar;
import com.berkayderin.dto.DtoSaledCarIU;

public interface ISaledCarService {

    public DtoSaledCar buyCar(DtoSaledCarIU dtoSaledCarIU);
}
