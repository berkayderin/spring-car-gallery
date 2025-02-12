package com.berkayderin.service.impl;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.berkayderin.dto.DtoAddress;
import com.berkayderin.dto.DtoCar;
import com.berkayderin.dto.DtoGallery;
import com.berkayderin.dto.DtoGalleryCar;
import com.berkayderin.dto.DtoGalleryCarIU;
import com.berkayderin.exception.BaseException;
import com.berkayderin.exception.ErrorMessage;
import com.berkayderin.exception.MessageType;
import com.berkayderin.model.Car;
import com.berkayderin.model.Gallery;
import com.berkayderin.model.GalleryCar;
import com.berkayderin.repository.CarRepository;
import com.berkayderin.repository.GalleryCarRepository;
import com.berkayderin.repository.GalleryRepository;
import com.berkayderin.service.IGalleryCarService;

@Service
public class GalleryCarServiceImpl implements IGalleryCarService {

    @Autowired
    private GalleryCarRepository galleryCarRepository;

    @Autowired
    private GalleryRepository galleryRepository;

    @Autowired
    private CarRepository carRepository;

    private GalleryCar createGalleryCar(DtoGalleryCarIU dtoGalleryCarIU) {
        Optional<Gallery> optGallery = galleryRepository.findById(dtoGalleryCarIU.getGalleryId());

        if (optGallery.isEmpty()) {
            throw new BaseException(
                    new ErrorMessage(MessageType.NO_RECORD_EXIST, dtoGalleryCarIU.getGalleryId().toString()));
        }

        Optional<Car> optCar = carRepository.findById(dtoGalleryCarIU.getCarId());

        if (optCar.isEmpty()) {
            throw new BaseException(
                    new ErrorMessage(MessageType.NO_RECORD_EXIST, dtoGalleryCarIU.getCarId().toString()));
        }

        GalleryCar galleryCar = new GalleryCar();
        galleryCar.setCreateTime(new Date());
        galleryCar.setGallery(optGallery.get());
        galleryCar.setCar(optCar.get());

        return galleryCar;
    }

    @Override
    public DtoGalleryCar saveGalleryCar(DtoGalleryCarIU dtoGalleryCarIU) {
        DtoGalleryCar dtoGalleryCar = new DtoGalleryCar();
        DtoGallery dtoGallery = new DtoGallery();
        DtoCar dtoCar = new DtoCar();

        DtoAddress dtoAddress = new DtoAddress();

        GalleryCar savedGalleryCar = galleryCarRepository.save(createGalleryCar(dtoGalleryCarIU));

        BeanUtils.copyProperties(savedGalleryCar, dtoGalleryCar);
        BeanUtils.copyProperties(savedGalleryCar.getGallery(), dtoGallery);
        BeanUtils.copyProperties(savedGalleryCar.getGallery().getAddress(), dtoAddress);
        BeanUtils.copyProperties(savedGalleryCar.getCar(), dtoCar);

        dtoGallery.setAddress(dtoAddress);
        dtoGalleryCar.setGallery(dtoGallery);
        dtoGalleryCar.setCar(dtoCar);

        return dtoGalleryCar;
    }

}
