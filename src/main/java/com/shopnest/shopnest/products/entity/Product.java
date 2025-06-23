package com.shopnest.shopnest.products.entity;

import com.shopnest.shopnest.favorites.entity.Favorite;
import com.shopnest.shopnest.productSizes.entity.ProductSize;
import com.shopnest.shopnest.subCategories.entity.Subcategory;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "product_code", unique = true)
    private String productCode;
    @Column(name = "product_description")
    private String productDescription;
    @Column(name = "price")
    private BigDecimal productPrice;
    @Column(name = "discount")
    private BigDecimal discount;
    @Column(name = "stock_quantity", nullable = false)
    private Integer stockQuantity;


    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subcategory_id")
    private Subcategory subcategory;

    //Obtener las imagenes de un producto
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductImage> images = new ArrayList<>();

    //Obtener las tallas de un producto
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductSize> productSizes = new ArrayList<>();

    @OneToMany(mappedBy = "product")
    Set<Favorite> favorites;
}