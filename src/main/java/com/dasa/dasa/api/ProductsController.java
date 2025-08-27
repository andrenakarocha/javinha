package com.dasa.dasa.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductsController {

    @GetMapping("/products")
    public String sayHello() {
        return "Hello, Spring Boot!";
    }
}