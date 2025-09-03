package com.dasa.dasa.domain.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import com.dasa.dasa.domain.VOs.Barcode;
import com.dasa.dasa.domain.VOs.Name;
import com.dasa.dasa.domain.abstractions.BaseEntity;

public class Product extends BaseEntity {
    
    private Name name;
    private Barcode barcode;

    // Getters
    public String getName() {
        return name.getValue();
    }

    public String getBarCode(){
        return barcode.getValue();
    }

    // Private Constructors
    private Product(UUID id, Name name, Barcode barcode, LocalDateTime createdAt, LocalDateTime updatedAt) {
        super(id, createdAt, updatedAt);

        this.name = name;
        this.barcode = barcode;
    }

    private Product(Name name, Barcode barcode) {
        this.onCreate();

        this.name = name;
        this.barcode = barcode;
    }

    // Static Factory Methods
    public static Product Create(String name, String barcode){
        return new Product(new Name(name), new Barcode(barcode));
    }

    public static Product fromDb(String id, String name, String barcode, LocalDateTime createdAt, LocalDateTime updatedAt){
        return new Product(UUID.fromString(id), new Name(name), new Barcode(barcode), createdAt, updatedAt);
    }
}