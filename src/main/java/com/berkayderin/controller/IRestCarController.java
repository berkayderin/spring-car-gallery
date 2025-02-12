package com.berkayderin.controller;

import java.util.List;
import com.berkayderin.dto.DtoCar;
import com.berkayderin.dto.DtoCarIU;
import com.berkayderin.dto.DtoCarPriceIU;

public interface IRestCarController {

    public RootEntity<DtoCar> saveCar(DtoCarIU dtoCarIU);

    public RootEntity<List<DtoCar>> getAllCars();

    public RootEntity<DtoCar> getCarById(Long id);

    public RootEntity<DtoCar> updateCarPrice(Long id, DtoCarPriceIU dtoCarPriceIU);
}
