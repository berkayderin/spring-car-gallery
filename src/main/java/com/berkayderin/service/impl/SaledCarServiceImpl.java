package com.berkayderin.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.berkayderin.dto.CurrencyRatesResponse;
import com.berkayderin.dto.DtoCar;
import com.berkayderin.dto.DtoCustomer;
import com.berkayderin.dto.DtoGallery;
import com.berkayderin.dto.DtoSaledCar;
import com.berkayderin.dto.DtoSaledCarIU;
import com.berkayderin.enums.CarStatusType;
import com.berkayderin.exception.BaseException;
import com.berkayderin.exception.ErrorMessage;
import com.berkayderin.exception.MessageType;
import com.berkayderin.model.Car;
import com.berkayderin.model.Customer;
import com.berkayderin.model.SaledCar;
import com.berkayderin.repository.CarRepository;
import com.berkayderin.repository.CustomerRepository;
import com.berkayderin.repository.GalleryRepository;
import com.berkayderin.repository.SaledCarRepository;
import com.berkayderin.service.ICurrencyRatesService;
import com.berkayderin.service.ISaledCarService;
import com.berkayderin.utils.DateUtils;

@Service
public class SaledCarServiceImpl implements ISaledCarService {

    @Autowired
    private SaledCarRepository saledCarRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private GalleryRepository galleryRepository;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private ICurrencyRatesService currencyRatesService;

    public BigDecimal convertCustomerAmountToUSD(Customer customer) {
        CurrencyRatesResponse currencyRatesResponse = currencyRatesService.getCurrencyRates(
                DateUtils.getCurrendDate(new Date()),
                DateUtils.getCurrendDate(new Date()));

        BigDecimal usd = new BigDecimal(currencyRatesResponse.getItems().get(0).getUsd());

        BigDecimal customerUSDAmount = customer.getAccount().getAmount().divide(usd, 2, RoundingMode.HALF_UP);

        return customerUSDAmount;
    }

    public boolean checkCarStatus(Long carId) {
        Optional<Car> optCar = carRepository.findById(carId);
        if (optCar.isPresent() && optCar.get().getCarStatusType().name().equals(CarStatusType.SALED.name())) {
            return false;
        }
        return true;
    }

    public BigDecimal remaningCustomerAmount(Customer customer, Car car) {
        BigDecimal customerUSDAmount = convertCustomerAmountToUSD(customer);
        BigDecimal remaningCustomerUSDAmount = customerUSDAmount.subtract(car.getPrice());

        CurrencyRatesResponse currencyRatesResponse = currencyRatesService.getCurrencyRates(
                DateUtils.getCurrendDate(new Date()),
                DateUtils.getCurrendDate(new Date()));

        BigDecimal usd = new BigDecimal(currencyRatesResponse.getItems().get(0).getUsd());
        return remaningCustomerUSDAmount.multiply(usd);
    }

    public boolean checkAmount(DtoSaledCarIU dtoSaledCarIU) {
        Optional<Customer> optCustomer = customerRepository.findById(dtoSaledCarIU.getCustomerId());
        if (optCustomer.isEmpty()) {
            throw new BaseException(
                    new ErrorMessage(MessageType.NO_RECORD_EXIST, dtoSaledCarIU.getCarId().toString()));
        }

        Optional<Car> optCar = carRepository.findById(dtoSaledCarIU.getCarId());
        if (optCar.isEmpty()) {
            throw new BaseException(
                    new ErrorMessage(MessageType.NO_RECORD_EXIST, dtoSaledCarIU.getCarId().toString()));
        }

        BigDecimal customerUSDAmount = convertCustomerAmountToUSD(optCustomer.get());

        if (customerUSDAmount.compareTo(optCar.get().getPrice()) == 0
                || customerUSDAmount.compareTo(optCar.get().getPrice()) > 0) {
            return true;
        }
        return false;
    }

    private SaledCar createSaledCar(DtoSaledCarIU dtoSaledCarIU) {
        SaledCar saledCar = new SaledCar();
        saledCar.setCreateTime(new Date());

        saledCar.setCustomer(customerRepository.findById(dtoSaledCarIU.getCustomerId()).orElse(null));
        saledCar.setGallery(galleryRepository.findById(dtoSaledCarIU.getGalleryId()).orElse(null));
        saledCar.setCar(carRepository.findById(dtoSaledCarIU.getCarId()).orElse(null));

        return saledCar;
    }

    @Override
    public DtoSaledCar buyCar(DtoSaledCarIU dtoSaledCarIU) {
        if (!checkAmount(dtoSaledCarIU)) {
            throw new BaseException(new ErrorMessage(MessageType.CUSTOMER_AMOUNT_IS_NOT_ENOUGH, ""));
        }

        if (!checkCarStatus(dtoSaledCarIU.getCarId())) {
            throw new BaseException(
                    new ErrorMessage(MessageType.CAR_STATUS_IS_ALREADY_SALED, dtoSaledCarIU.getCarId().toString()));
        }

        SaledCar savedSaledCar = saledCarRepository.save(createSaledCar(dtoSaledCarIU));
        Car car = savedSaledCar.getCar();
        car.setCarStatusType(CarStatusType.SALED);

        Customer customer = savedSaledCar.getCustomer();
        customer.getAccount().setAmount(remaningCustomerAmount(customer, car));
        customerRepository.save(customer);

        return toDTO(savedSaledCar);
    }

    public DtoSaledCar toDTO(SaledCar saledCar) {
        DtoSaledCar dtoSaledCar = new DtoSaledCar();
        DtoCustomer dtoCustomer = new DtoCustomer();
        DtoGallery dtoGallery = new DtoGallery();
        DtoCar dtoCar = new DtoCar();

        BeanUtils.copyProperties(saledCar, dtoSaledCar);
        BeanUtils.copyProperties(saledCar.getCustomer(), dtoCustomer);
        BeanUtils.copyProperties(saledCar.getGallery(), dtoGallery);
        BeanUtils.copyProperties(saledCar.getCar(), dtoCar);

        dtoSaledCar.setCustomer(dtoCustomer);
        dtoSaledCar.setGallery(dtoGallery);
        dtoSaledCar.setCar(dtoCar);
        return dtoSaledCar;
    }

}
