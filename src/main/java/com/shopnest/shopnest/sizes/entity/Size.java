package com.shopnest.shopnest.sizes.entity;

import com.shopnest.shopnest.productSizes.entity.ProductSize;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Sizes")
public class Size {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "size_id")
    private Long sizeId;

    @Column(name = "size_label", unique = true, nullable = false)
    private String sizeLabel;

    @OneToMany(mappedBy = "size", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ProductSize> productSizes = new HashSet<>();
}
