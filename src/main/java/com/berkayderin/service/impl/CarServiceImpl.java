package com.berkayderin.service.impl;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.berkayderin.dto.DtoCar;
import com.berkayderin.dto.DtoCarIU;
import com.berkayderin.model.Car;
import com.berkayderin.repository.CarRepository;
import com.berkayderin.service.ICarService;

@Service
public class CarServiceImpl implements ICarService {

    @Autowired
    private CarRepository carRepository;

    private Car createCar(DtoCarIU dtoCarIU) {
        Car car = new Car();
        car.setCreateTime(new Date());

        BeanUtils.copyProperties(dtoCarIU, car);
        return car;
    }

    private DtoCar convertToDto(Car car) {
        DtoCar dtoCar = new DtoCar();
        BeanUtils.copyProperties(car, dtoCar);
        return dtoCar;
    }

    @Override
    public DtoCar saveCar(DtoCarIU dtoCarIU) {
        DtoCar dtoCar = new DtoCar();
        Car savedCar = carRepository.save(createCar(dtoCarIU));

        BeanUtils.copyProperties(savedCar, dtoCar);
        return dtoCar;
    }

    @Override
    public List<DtoCar> getAllCars() {
        List<Car> cars = carRepository.findAll();
        List<DtoCar> dtoCars = new ArrayList<>();

        for (Car car : cars) {
            dtoCars.add(convertToDto(car));
        }

        return dtoCars;
    }

}
