package com.imd.store.respository;

import com.imd.store.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepsitory extends JpaRepository<Transaction, Long> {
}
