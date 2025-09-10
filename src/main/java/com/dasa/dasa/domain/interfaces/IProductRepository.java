package com.dasa.dasa.domain.interfaces;

import java.util.UUID;

import com.dasa.dasa.domain.entities.Product;

public interface IProductRepository {

    public int createProduct(Product product);

    public Product findById(UUID id);
}
