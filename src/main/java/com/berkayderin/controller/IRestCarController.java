package com.berkayderin.controller;

import com.berkayderin.dto.DtoCar;
import com.berkayderin.dto.DtoCarIU;

public interface IRestCarController {

    public RootEntity<DtoCar> saveCar(DtoCarIU dtoCarIU);
}
