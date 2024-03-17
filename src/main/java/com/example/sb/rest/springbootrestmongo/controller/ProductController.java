package com.example.sb.rest.springbootrestmongo.controller;

import com.example.sb.rest.springbootrestmongo.model.Product;
import com.example.sb.rest.springbootrestmongo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getAllProducts(){
     return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable long id){
        return productService.getProductById(id);
    }
    @PostMapping
    public Product saveProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }

    @PutMapping
    public ResponseEntity<Product> updateProduct(@RequestBody Product product){
        return ResponseEntity.ok(productService.updateProduct(product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> updateProduct(@RequestParam long id){
        productService.deleteProduct(id);
        return ResponseEntity.ok(id);
    }
}
