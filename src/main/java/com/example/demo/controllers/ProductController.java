package com.example.demo.controllers;

import com.example.demo.models.entities.Product;
import com.example.demo.models.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;


//    @PostMapping
//    public Product newProduct(@RequestParam String name, @RequestParam double price) {
//        Product product = new Product(name, price);
//        productRepository.save(product);
//        return product;
//    }

    @PostMapping
    public Product newProduct(Product product) {
        productRepository.save(product);
        return product;
    }

    // as duas formas acima funcionam: seja recebendo cada atributo individualmente, ou recebendo o próprio objeto completo.
}
