package com.example.sb.rest.springbootrestmongo.service;

import com.example.sb.rest.springbootrestmongo.exception.ResourceNotFoundException;
import com.example.sb.rest.springbootrestmongo.model.Product;
import com.example.sb.rest.springbootrestmongo.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product getProductById(long id) {
        Optional<Product> prod = productRepository.findById(id);
        if (prod.isPresent()){
            return prod.get();
        }
        else
            throw new ResourceNotFoundException("Product Not Found");
    }

    @Override
    public Product updateProduct(Product product) {
        Optional<Product> prod = productRepository.findById(product.getId());
        if (prod.isPresent()){
            Product productFromRepo = prod.get();
            productFromRepo.setName(product.getName());
            productFromRepo.setDescription(product.getDescription());
            return productRepository.save(productFromRepo);
        }
        else
            throw new ResourceNotFoundException("Product Not Found");
    }

    @Override
    public void deleteProduct(long id) {
        Optional<Product> prod = productRepository.findById(id);
        if (prod.isPresent()){
            productRepository.delete(prod.get());
        }
        else
            throw new ResourceNotFoundException("Product Not Found");    }
}
