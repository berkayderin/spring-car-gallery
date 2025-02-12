package com.berkayderin.controller;

import com.berkayderin.dto.DtoSaledCar;
import com.berkayderin.dto.DtoSaledCarIU;

public interface IRestSaledCarController {

    public RootEntity<DtoSaledCar> buyCar(DtoSaledCarIU dtoSaledCarIU);
}
