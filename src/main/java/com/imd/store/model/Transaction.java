package com.imd.store.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long productId;
    private LocalDateTime transactionDate;

    @Builder
    public Transaction(Long productId, LocalDateTime transactionDate) {
        this.productId = productId;
        this.transactionDate = transactionDate;
    }

    public Long getId() {
        return id;
    }
}
