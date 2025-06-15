package com.shopnest.shopnest.products.mapper;

import com.shopnest.shopnest.products.dto.ProductResponseDto;
import com.shopnest.shopnest.products.entity.Product;
import com.shopnest.shopnest.products.entity.ProductImage;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(source = "subcategory.category.categoryId", target = "category.id")
    @Mapping(source = "subcategory.category.categoryName", target = "category.name")
    @Mapping(target = "images", expression = "java(product.getImages().stream().map(img -> img.getUrl()).toList())")
    ProductResponseDto toProductResponseDto(Product product);

    @Named("mapImageUrls")
    static List<String> mapImageUrls(List<ProductImage> images) {
        if (images == null) return null;
        return images.stream()
                .map(ProductImage::getUrl)
                .collect(Collectors.toList());
    }
}