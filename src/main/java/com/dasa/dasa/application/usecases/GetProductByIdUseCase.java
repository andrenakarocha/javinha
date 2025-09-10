package com.dasa.dasa.application.usecases;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.dasa.dasa.domain.entities.Product;
import com.dasa.dasa.domain.interfaces.IProductRepository;

@Service
public class GetProductByIdUseCase {
    private final IProductRepository repository;

    public GetProductByIdUseCase(IProductRepository repository) {
        this.repository = repository;
    }

    public Product execute(String rawId) {
        UUID id = UUID.fromString(rawId);
        return repository.findById(id);
    }
}