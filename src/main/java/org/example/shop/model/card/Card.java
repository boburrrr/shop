package org.example.shop.model.card;

import jakarta.persistence.*;
import lombok.*;
import org.example.shop.model.user.User;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.UUID;

@Entity(name = "cards")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    @Enumerated(EnumType.STRING)
    private Type type = Type.HUMO;
    @Column(unique = true,nullable = false)
    private String card_number;
    private String valid_thru;
    private String password;
    private Double balance;
    @CreationTimestamp
    private LocalDate create_date;
}
