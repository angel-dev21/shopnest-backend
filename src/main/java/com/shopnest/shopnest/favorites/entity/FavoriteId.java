
package com.shopnest.shopnest.favorites.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Embeddable
public class FavoriteId implements Serializable {

    @Column(name = "user_id")
    private Long userId;
    @Column(name = "product_id")
    private Long productId;

}