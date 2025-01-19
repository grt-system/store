package com.imd.store.controller;

import com.imd.store.dto.ProductDTO;
import com.imd.store.model.Product;
import com.imd.store.service.ProductService;
import com.imd.store.service.FailureService;  // Importa o FailureService
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/store/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private FailureService failureService;  // Injetando o FailureService

    /**
     * Endpoint para buscar um produto pelo ID com falha de omissão simulada.
     *
     * @param id ID do produto
     * @return Dados do produto ou código 204 No Content em caso de falha de omissão
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> findProductById(@PathVariable("id") Long id) {
        // Verifica se a falha de omissão deve ser simulada
        if (failureService.simulateProductFailure()) {
            // Simula a falha de omissão e retorna 204 No Content
            return ResponseEntity.status(204).build();
        }

        // Caso contrário, busca o produto no banco de dados
        Optional<Product> product = productService.findById(id);

        //ProductDTO productDTO = new ProductDTO(1, "camisa", 30.30);

        // Verifica se o produto foi encontrado
        if (product.isPresent()) {
            return ResponseEntity.ok().body(product.get());  // Retorna o produto
        } else {
            return ResponseEntity.status(404).body("Product not found");  // Retorna 404 se não encontrado
        }
    }

    /**
     * Endpoint para criar um novo produto.
     *
     * @param product Produto a ser criado
     * @return O produto criado
     */
    @PostMapping("/create")
    public ResponseEntity<?> createProduct(@RequestBody Product product) {
        Product productCreated = productService.create(product);
        return ResponseEntity.ok().body(productCreated);
    }
}
