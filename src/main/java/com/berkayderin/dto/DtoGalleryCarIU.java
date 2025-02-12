package com.berkayderin.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoGalleryCarIU {

    @NotNull
    private Long galleryId;

    @NotNull
    private Long carId;
}
