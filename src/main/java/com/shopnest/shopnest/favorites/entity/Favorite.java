
package com.shopnest.shopnest.favorites.entity;

import com.shopnest.shopnest.products.entity.Product;
import com.shopnest.shopnest.users.entity.UserEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "favorites")
public class Favorite {

    @EmbeddedId
    FavoriteId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    UserEntity user;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    Product product;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

}
