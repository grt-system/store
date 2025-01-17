package com.imd.store.service;

import com.imd.store.dto.TransactionDTO;
import com.imd.store.model.Transaction;
import com.imd.store.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public TransactionDTO create(Long productId) {
        Transaction transaction = new Transaction.Builder()
                .productId(productId)
                .transactionDate(LocalDateTime.now())
                .build();
        transactionRepository.save(transaction);

        return new TransactionDTO(transaction.getId());
    }
}
