package org.example.shop.model.product;

import jakarta.persistence.*;
import lombok.*;
import org.example.shop.model.user.User;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.UUID;

@Entity(name = "products")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User user;
    private String name;
    private Double price;
    @CreationTimestamp
    private LocalDate create_date;
    private Integer recurrence_period;
}
