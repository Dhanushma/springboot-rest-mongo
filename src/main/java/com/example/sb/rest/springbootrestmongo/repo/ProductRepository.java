package com.example.sb.rest.springbootrestmongo.repo;

import com.example.sb.rest.springbootrestmongo.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, Long> {
}
