package com.berkayderin.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.berkayderin.controller.IRestGalleryController;
import com.berkayderin.controller.RestBaseController;
import com.berkayderin.controller.RootEntity;
import com.berkayderin.dto.DtoGallery;
import com.berkayderin.dto.DtoGalleryIU;
import com.berkayderin.service.IGalleryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class RestGalleryControllerImpl extends RestBaseController implements IRestGalleryController {

    @Autowired
    private IGalleryService galleryService;

    @PostMapping("/gallery")
    @Override
    public RootEntity<DtoGallery> saveGallery(@Valid @RequestBody DtoGalleryIU dtoGalleryIU) {
        return ok(galleryService.saveGallery(dtoGalleryIU));
    }

}
