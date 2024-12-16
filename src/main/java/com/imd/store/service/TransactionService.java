package com.imd.store.service;

import com.imd.store.respository.TransactionRepsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepsitory transactionRepsitory;
}
