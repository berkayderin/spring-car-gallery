package com.berkayderin.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoSaledCar extends DtoBase {

    private DtoCustomer customer;

    private DtoGallery gallery;

    private DtoCar car;
}
