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
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api")
@Tag(name = "Araç İşlemleri", description = "Araç yönetimi için API uç noktaları")
public class RestCarControllerImpl extends RestBaseController implements IRestCarController {

    @Autowired
    private ICarService carService;

    @PostMapping("/car")
    @Operation(summary = "Yeni araç ekle", description = "Sisteme yeni bir araç kaydı ekler")
    @Override
    public RootEntity<DtoCar> saveCar(@Valid @RequestBody DtoCarIU dtoCarIU) {
        return ok(carService.saveCar(dtoCarIU));
    }

    @GetMapping("/cars")
    @Operation(summary = "Tüm araçları listele", description = "Sistemdeki tüm araçları listeler")
    @Override
    public RootEntity<List<DtoCar>> getAllCars() {
        return ok(carService.getAllCars());
    }

    @GetMapping("/car/{id}")
    @Operation(summary = "Araç detayı getir", description = "Belirtilen ID'ye sahip aracın detaylarını getirir")
    @Override
    public RootEntity<DtoCar> getCarById(@PathVariable Long id) {
        return ok(carService.getCarById(id));
    }

    @PutMapping("/car/{id}/price")
    @Operation(summary = "Araç fiyatı güncelle", description = "Belirtilen ID'ye sahip aracın fiyatını günceller")
    @Override
    public RootEntity<DtoCar> updateCarPrice(@PathVariable Long id, @Valid @RequestBody DtoCarPriceIU dtoCarPriceIU) {
        return ok(carService.updateCarPrice(id, dtoCarPriceIU));
    }
}
