package com.div.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema = "delivery",name = "sellers")
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "create_date")
    private LocalDate creatDate;
    @Column(name = "location")
    private String location;
    @Column(name = "status")
    private Boolean status;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "seller_catagory",
            joinColumns = @JoinColumn(name = "seller_id"),
            inverseJoinColumns = @JoinColumn(name = "catagory_id"))
    private List<Catagory> catagories;
//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "food_id", referencedColumnName = "id")
//    private List<Food> foods;





}
