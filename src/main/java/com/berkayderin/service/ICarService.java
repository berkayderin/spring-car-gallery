package com.berkayderin.service;

import com.berkayderin.dto.DtoCar;
import com.berkayderin.dto.DtoCarIU;

public interface ICarService {

    public DtoCar saveCar(DtoCarIU dtoCarIU);
}
