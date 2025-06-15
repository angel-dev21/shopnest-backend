package com.shopnest.shopnest.products.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductDto {

    private String name;
    private String code;
    private String description;
    private BigDecimal price;
    private BigDecimal discount;
    private Integer stock;
    private Long subcategoryId; // Referencia a la subcategoría
}

