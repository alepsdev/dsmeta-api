package com.alepdev.dsmeta.dtos;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
public class SaleDTO {


    @NotBlank
    private String sellerName;

    @NotNull
    private Integer visited;

    @NotNull
    private Integer deals;

    @NotNull
    private Double amount;

    @NotNull
    private LocalDate dateSale;
}
