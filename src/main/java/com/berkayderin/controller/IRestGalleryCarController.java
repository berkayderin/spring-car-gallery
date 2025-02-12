package com.berkayderin.controller;

import com.berkayderin.dto.DtoGalleryCar;
import com.berkayderin.dto.DtoGalleryCarIU;

public interface IRestGalleryCarController {

    public RootEntity<DtoGalleryCar> saveGalleryCar(DtoGalleryCarIU dtoGalleryCarIU);
}
