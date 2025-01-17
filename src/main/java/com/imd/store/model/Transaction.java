package com.imd.store.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long productId;
    private LocalDateTime transactionDate;


    public Transaction(Long productId, LocalDateTime transactionDate) {
        this.productId = productId;
        this.transactionDate = transactionDate;
    }


    private Transaction(Builder builder) {
        this.productId = builder.productId;
        this.transactionDate = builder.transactionDate;
    }

    public Transaction() {

    }


    public Long getId() {
        return id;
    }

    public Long getProductId() {
        return productId;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }


    public static class Builder {
        private Long productId;
        private LocalDateTime transactionDate;


        public Builder productId(Long productId) {
            this.productId = productId;
            return this;
        }

        public Builder transactionDate(LocalDateTime transactionDate) {
            this.transactionDate = transactionDate;
            return this;
        }

        // Método que cria a instância de Transaction
        public Transaction build() {
            return new Transaction(this);
        }
    }
}
