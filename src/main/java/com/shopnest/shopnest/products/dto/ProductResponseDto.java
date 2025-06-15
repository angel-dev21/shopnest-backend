package com.shopnest.shopnest.products.dto;

import com.shopnest.shopnest.categories.dto.CategoryDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseDto {

    private String productName;
    private String productCode;
    private String productDescription;
    private BigDecimal productPrice;
    private BigDecimal discount;
    private Integer stockQuantity;

    private CategoryDto category;
    private List<String> images;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

