package com.berkayderin.dto;

import java.math.BigDecimal;

import com.berkayderin.enums.CurrencyType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoAccount extends DtoBase {
    private String accountNo;

    private String iban;

    private BigDecimal amount;

    private CurrencyType currencyType;
}
