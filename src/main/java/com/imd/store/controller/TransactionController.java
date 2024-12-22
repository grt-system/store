package com.imd.store.controller;

import com.imd.store.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/store/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/sell")
        public ResponseEntity<?> findProductById(@RequestParam Long id) {
        transactionService.create(id);
        return ResponseEntity.ok().body("ok");
    }
}
