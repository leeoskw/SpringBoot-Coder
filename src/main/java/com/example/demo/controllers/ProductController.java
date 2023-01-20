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

    @PutMapping
    public Product alterProduct(Product product) {
        productRepository.save(product);
        return product;
    }

    // método newProduct é exatamente igual ao alterProduct, então podemos simplificar utilizando o method = {passar uma lista!}
    // esse método saveProduct faz o papel dos métodos newProduct e alterProduct. Poderia comentar os dois.
    @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
    public Product saveProduct(Product product){
        productRepository.save(product);
        return product;
    }

    @GetMapping()
    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Product> getProductById(@PathVariable int id) {
        return productRepository.findById(id);
        // como é uma variável que está presente dentro da URL, utilizamos @PathVariable
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable int id) {
        productRepository.deleteById(id);
    }


}
