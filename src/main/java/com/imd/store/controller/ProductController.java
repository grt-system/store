package com.imd.store.controller;

import com.imd.store.model.Product;
import com.imd.store.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/store/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/{id}")
    public ResponseEntity<?> findProductById(@PathVariable("id") Long id) {
        Optional<Product> product = productService.findById(id);
        return ResponseEntity.ok().body("ok");
    }

    @PostMapping("/create")
    public ResponseEntity<?> createProduct(@RequestBody Product product) {
        Product productCreated = productService.create(product);

        return ResponseEntity.ok().body(productCreated);
    }
}
