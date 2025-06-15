package com.shopnest.shopnest.categories.mapper;

import com.shopnest.shopnest.categories.dto.CategoryDto;
import com.shopnest.shopnest.categories.entity.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryDto toCategoryDto(Category category);
}
