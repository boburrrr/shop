package org.example.shop.model.product;

import jakarta.persistence.*;
import lombok.*;
import org.example.shop.model.user.User;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.util.UUID;

import static org.example.shop.model.product.Status.CREATED;

@Entity(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "product_id",referencedColumnName = "id")
    private Product product;
    private Integer number;
    private Double full_price;
    @Enumerated(EnumType.STRING) 
    private Status status = CREATED;
    private String buy_type;
    @CreationTimestamp
    private LocalDate create_date;
    @UpdateTimestamp
    private LocalDate update_date;
}
