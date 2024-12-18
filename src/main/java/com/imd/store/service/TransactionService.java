package com.imd.store.service;

import com.imd.store.dto.TransactionDTO;
import com.imd.store.model.Transaction;
import com.imd.store.respository.TransactionRepsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepsitory transactionRepsitory;

    public TransactionDTO create(Long idProduct) {
        Transaction transaction = Transaction.builder()
                .productId(idProduct)
                .transactionDate(LocalDateTime.now())
                .build();

        transactionRepsitory.save(transaction);

        return new TransactionDTO(transaction.getId());
    }
}
