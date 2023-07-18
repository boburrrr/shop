package org.example.shop.model.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;
import org.example.shop.model.card.Card;
import org.example.shop.model.card.Hisob;
import org.example.shop.model.product.Order;
import org.example.shop.model.product.Product;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import static org.example.shop.model.user.Role.USER;


@Entity(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    @Column(unique = true,nullable = false)
    @NotBlank
    private String tel_number;
    @Column(nullable = false)
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role = USER;
    @CreationTimestamp
    private LocalDate create_date;
    @UpdateTimestamp
    private LocalDate update_date;
    @Enumerated(EnumType.STRING)
    private Blocked blocked = Blocked.BLOCK;
//    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    private List<Product> productArrayList;
//    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    List<Order> orderArrayList;
//    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    List<Card> cardArrayList;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    Hisob hisob;
}
