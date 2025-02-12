package com.berkayderin.service;

import com.berkayderin.dto.DtoGalleryCar;
import com.berkayderin.dto.DtoGalleryCarIU;

public interface IGalleryCarService {

    public DtoGalleryCar saveGalleryCar(DtoGalleryCarIU dtoGalleryCarIU);
}
