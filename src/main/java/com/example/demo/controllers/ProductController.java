package com.example.demo.controllers;

import com.example.demo.models.entities.Product;
import com.example.demo.models.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

    @GetMapping()
    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Product> getProductById(@PathVariable int id) {
        return productRepository.findById(id);
        // como é uma variável que está presente dentro da URL, utilizamos @PathVariable
    }
}
