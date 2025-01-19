package com.imd.store.controller;

import com.imd.store.model.Transaction;
import com.imd.store.service.TransactionService;
import com.imd.store.service.FailureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.imd.store.dto.TransactionDTO;


@RestController
@RequestMapping("/store")
public class TransactionController {

        @Autowired
        private TransactionService transactionService;

        @Autowired
        private FailureService failureService;

        @PostMapping("/sell")
        public ResponseEntity<?> sellProduct(@RequestParam Long productId) {
            boolean isFailureSimulated = failureService.simulateFailure();

            if (isFailureSimulated) {
                return ResponseEntity.status(500).body("Simulated Error: The system is in an error state.");
            }
            TransactionDTO transactionDTO = transactionService.create(productId);
            return ResponseEntity.ok(transactionDTO);
        }
}


