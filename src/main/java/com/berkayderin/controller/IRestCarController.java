package com.berkayderin.controller;

import java.util.List;
import com.berkayderin.dto.DtoCar;
import com.berkayderin.dto.DtoCarIU;

public interface IRestCarController {

    public RootEntity<DtoCar> saveCar(DtoCarIU dtoCarIU);

    public RootEntity<List<DtoCar>> getAllCars();

    public RootEntity<DtoCar> getCarById(Long id);
}
