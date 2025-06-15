package com.shopnest.shopnest.orderitems.entity;

import com.shopnest.shopnest.orders.entity.Order;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orderitems")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_item_id")
    private Long orderItemId;
    @Column(name = "product_id")
    private Long productId;
    @Column(name = "size_id")
    private Long sizeId;
    @Column(name = "quantity")
    private Long quantity;
    @Column(name = "unit_price")
    private Long unitPrice;

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "order_id")
    private Order order;
}
