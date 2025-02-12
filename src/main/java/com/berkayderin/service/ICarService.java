package com.berkayderin.service;

import java.util.List;
import com.berkayderin.dto.DtoCar;
import com.berkayderin.dto.DtoCarIU;
import com.berkayderin.dto.DtoCarPriceIU;

public interface ICarService {

    public DtoCar saveCar(DtoCarIU dtoCarIU);

    public List<DtoCar> getAllCars();

    public DtoCar getCarById(Long id);

    public DtoCar updateCarPrice(Long id, DtoCarPriceIU dtoCarPriceIU);
}
