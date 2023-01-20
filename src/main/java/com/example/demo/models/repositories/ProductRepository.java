package com.example.demo.models.repositories;

import com.example.demo.models.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {
    // CrudRepository<Product, Integer> -> O primeiro é o tipo do modelo que iremos trabalhar. O segundo é o tipo do ID
}
