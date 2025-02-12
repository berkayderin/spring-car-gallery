package com.berkayderin.controller;

import com.berkayderin.dto.DtoGallery;
import com.berkayderin.dto.DtoGalleryIU;

public interface IRestGalleryController {

    public RootEntity<DtoGallery> saveGallery(DtoGalleryIU dtoGalleryIU);
}
