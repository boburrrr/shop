package org.example.shop.model.card;

import jakarta.persistence.*;
import lombok.*;
import org.example.shop.model.user.User;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.UUID;

@Entity(name = "hisobs")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Hisob {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    private Double balance;
    @CreationTimestamp
    private LocalDate create_date;
}
