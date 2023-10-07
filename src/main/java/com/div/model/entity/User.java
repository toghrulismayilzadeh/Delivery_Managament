package com.div.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(schema = "delivery",name = "user")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "create_date")
    private LocalDateTime creatDate;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "location")
    private String location;
    @Column(name = "balance")
    private Float balance;
    @Column(name = "uuid")
    private UUID uuid;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private Role role;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private List<Order> orders;
    @OneToOne(mappedBy = "user")
    private OrderPlace orderPlace;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return role.getPermissions()
                .stream()
                .map(Permission::getName)
                .distinct()
                .map(SimpleGrantedAuthority::new)
                .toList();
    }

    public String username;

    public boolean accountNonExpired;

    public boolean accountNonLocked;

    public boolean credentialsNonExpired;

    public boolean enabled;

}
