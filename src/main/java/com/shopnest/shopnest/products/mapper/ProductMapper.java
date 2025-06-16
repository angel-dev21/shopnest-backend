package com.shopnest.shopnest.products.mapper;

import com.shopnest.shopnest.productSizes.entity.ProductSize;
import com.shopnest.shopnest.products.dto.ProductDto;
import com.shopnest.shopnest.products.dto.ProductResponseDto;
import com.shopnest.shopnest.products.dto.ProductSizeDto;
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
    //@Mapping(source = "productName", target = "name")
    @Mapping(target = "images", expression = "java(product.getImages().stream().map(img -> img.getUrl()).toList())")
    ProductResponseDto toProductResponseDto(Product product);

    Product toProduct(ProductDto productDto);

    // ✅ Mapea una talla de producto (ProductSize) a su DTO
    @Mapping(source = "size.sizeId", target = "sizeId")
    @Mapping(source = "size.sizeLabel", target = "sizeLabel")
    @Mapping(source = "stock", target = "stock")
    ProductSizeDto toProductSizeDto(ProductSize productSize);

    // ✅ Para listas
    List<ProductSizeDto> toProductSizeDtoList(List<ProductSize> productSizes);

    /*@Named("mapImageUrls")
    static List<String> mapImageUrls(List<ProductImage> images) {
        if (images == null) return null;
        return images.stream()
                .map(ProductImage::getUrl)
                .collect(Collectors.toList());
    }*/
}