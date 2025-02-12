package com.berkayderin.service.impl;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.berkayderin.dto.DtoAddress;
import com.berkayderin.dto.DtoGallery;
import com.berkayderin.dto.DtoGalleryIU;
import com.berkayderin.exception.BaseException;
import com.berkayderin.exception.ErrorMessage;
import com.berkayderin.exception.MessageType;
import com.berkayderin.model.Address;
import com.berkayderin.model.Gallery;
import com.berkayderin.repository.AddressRepository;
import com.berkayderin.repository.GalleryRepository;
import com.berkayderin.service.IGalleryService;

@Service
public class GalleryServiceImpl implements IGalleryService {

    @Autowired
    private GalleryRepository galleryRepository;

    @Autowired
    private AddressRepository addressRepository;

    private Gallery createGallery(DtoGalleryIU dtoGalleryIU) {
        Optional<Address> optAddress = addressRepository.findById(dtoGalleryIU.getAddressId());
        if (optAddress.isEmpty()) {
            throw new BaseException(
                    new ErrorMessage(MessageType.NO_RECORD_EXIST, dtoGalleryIU.getAddressId().toString()));
        }

        Gallery gallery = new Gallery();
        gallery.setCreateTime(new Date());

        BeanUtils.copyProperties(dtoGalleryIU, gallery);
        gallery.setAddress(optAddress.get());

        return gallery;
    }

    @Override
    public DtoGallery saveGallery(DtoGalleryIU dtoGalleryIU) {
        DtoGallery dtoGallery = new DtoGallery();
        DtoAddress dtoAddress = new DtoAddress();

        Gallery savedGallery = galleryRepository.save(createGallery(dtoGalleryIU));

        BeanUtils.copyProperties(savedGallery, dtoGallery);
        BeanUtils.copyProperties(savedGallery.getAddress(), dtoAddress);

        dtoGallery.setAddress(dtoAddress);
        return dtoGallery;
    }

}
