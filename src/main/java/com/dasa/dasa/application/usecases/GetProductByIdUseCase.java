package com.dasa.dasa.application.usecases;

import java.util.Optional;
import java.util.UUID;

import com.dasa.dasa.domain.entities.*;
import com.dasa.dasa.domain.interfaces.IProductRepository;

public class GetProductByIdUseCase {
    private final IProductRepository repository;

    public GetProductByIdUseCase(IProductRepository repository) {
        this.repository = repository;
    }

    public Optional<Product> execute(String rawId) {
        UUID id = UUID.fromString(rawId);
        return repository.findById(id);
    }
}