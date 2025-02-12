package com.berkayderin.dto;

import java.math.BigDecimal;

import com.berkayderin.enums.CurrencyType;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoCarPriceIU {

    @NotNull
    private BigDecimal price;

    @NotNull
    private CurrencyType currencyType;
}