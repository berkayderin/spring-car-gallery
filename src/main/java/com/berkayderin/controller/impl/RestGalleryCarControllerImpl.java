package com.berkayderin.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.berkayderin.controller.IRestGalleryCarController;
import com.berkayderin.controller.RestBaseController;
import com.berkayderin.controller.RootEntity;
import com.berkayderin.dto.DtoGalleryCar;
import com.berkayderin.dto.DtoGalleryCarIU;
import com.berkayderin.service.IGalleryCarService;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
@Tag(name = "Galeri Araç İşlemleri", description = "Galeri-araç ilişkisi yönetimi için API uç noktaları")
public class RestGalleryCarControllerImpl extends RestBaseController implements IRestGalleryCarController {

    @Autowired
    private IGalleryCarService galleryCarService;

    @PostMapping("/gallery-car")
    @Operation(summary = "Galeriye araç ekle", description = "Belirtilen galeriye yeni bir araç ekler")
    @Override
    public RootEntity<DtoGalleryCar> saveGalleryCar(@Valid @RequestBody DtoGalleryCarIU dtoGalleryCarIU) {
        return ok(galleryCarService.saveGalleryCar(dtoGalleryCarIU));
    }

}
