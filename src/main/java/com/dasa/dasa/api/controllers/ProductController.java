package com.dasa.dasa.api.controllers;

import org.springframework.web.bind.annotation.*;

import com.dasa.dasa.application.usecases.GetProductByIdUseCase;
import com.dasa.dasa.domain.entities.Product;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final GetProductByIdUseCase getProductByIdUseCase;

    public ProductController(GetProductByIdUseCase getProductByIdUseCase) {
        this.getProductByIdUseCase = getProductByIdUseCase;
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable String id) {
        return getProductByIdUseCase.execute(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }
}
