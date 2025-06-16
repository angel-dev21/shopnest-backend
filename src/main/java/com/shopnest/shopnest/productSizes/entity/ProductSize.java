package com.shopnest.shopnest.productSizes.entity;

import com.shopnest.shopnest.products.entity.Product;
import com.shopnest.shopnest.sizes.entity.Size;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Product_Sizes")
@IdClass(ProductSizeId.class)
public class ProductSize {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "size_id", nullable = false)
    private Size size;

    @Column(name = "stock", nullable = false)
    private int stock;
}
