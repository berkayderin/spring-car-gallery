package com.berkayderin.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.berkayderin.controller.IRestCarController;
import com.berkayderin.controller.RestBaseController;
import com.berkayderin.controller.RootEntity;
import com.berkayderin.dto.DtoCar;
import com.berkayderin.dto.DtoCarIU;
import com.berkayderin.dto.DtoCarPriceIU;
import com.berkayderin.service.ICarService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class RestCarControllerImpl extends RestBaseController implements IRestCarController {

    @Autowired
    private ICarService carService;

    @PostMapping("/car")
    @Override
    public RootEntity<DtoCar> saveCar(@Valid @RequestBody DtoCarIU dtoCarIU) {
        return ok(carService.saveCar(dtoCarIU));
    }

    @GetMapping("/cars")
    @Override
    public RootEntity<List<DtoCar>> getAllCars() {
        return ok(carService.getAllCars());
    }

    @GetMapping("/car/{id}")
    @Override
    public RootEntity<DtoCar> getCarById(@PathVariable Long id) {
        return ok(carService.getCarById(id));
    }

    @PutMapping("/car/{id}/price")
    @Override
    public RootEntity<DtoCar> updateCarPrice(@PathVariable Long id, @Valid @RequestBody DtoCarPriceIU dtoCarPriceIU) {
        return ok(carService.updateCarPrice(id, dtoCarPriceIU));
    }
}
