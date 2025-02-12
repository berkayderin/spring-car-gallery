package com.berkayderin.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoGalleryCar extends DtoBase {

    private DtoGallery gallery;

    private DtoCar car;
}
