package com.div.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema = "delivery",name = "order_place")
public class OrderPlace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "total_price")
    private Float totalPrice;
    @Column(name = "pay_type")//TRUE->Kart / FALSE->Chash
    private Boolean pat_type;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "food_id", referencedColumnName = "id")
    private List<Food> foods;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private User user;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "driver_id", referencedColumnName = "id")
    private Driver driver;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "orderr_id", referencedColumnName = "id")
    private Order order;



}

