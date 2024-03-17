package com.example.sb.rest.springbootrestmongo.service;

import com.example.sb.rest.springbootrestmongo.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();

    Product createProduct(Product product);

    Product getProductById(long id);

    Product updateProduct(Product product);

    void deleteProduct(long id);
}
