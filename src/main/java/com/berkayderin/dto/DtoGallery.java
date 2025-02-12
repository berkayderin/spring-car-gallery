package com.berkayderin.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoGallery extends DtoBase {

    private String firstName;

    private String lastName;

    private DtoAddress address;
}
