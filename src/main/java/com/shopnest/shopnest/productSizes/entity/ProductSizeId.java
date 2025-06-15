package com.shopnest.shopnest.productSizes.entity;

import java.io.Serializable;
import java.util.Objects;

public class ProductSizeId implements Serializable {
    private Long product;
    private Long size;

    public ProductSizeId() {}

    public ProductSizeId(Long product, Long size) {
        this.product = product;
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductSizeId)) return false;
        ProductSizeId that = (ProductSizeId) o;
        return Objects.equals(product, that.product) &&
                Objects.equals(size, that.size);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, size);
    }
}

