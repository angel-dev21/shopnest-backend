package com.shopnest.shopnest.products.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductSizeDto {

    private Long sizeId;
    private String sizeLabel;
    private int stock;

}
