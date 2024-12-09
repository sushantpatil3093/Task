package com.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.demo.entity.Product;
import com.demo.repository.ProductRepo;

@Service
public class ProductService {

    @Autowired
    private ProductRepo pr;

    public Page<Product> getAllProducts(int page, int size) {
        return pr.findAll(PageRequest.of(page, size));
    }

    public Product createProduct(Product product) {
        return pr.save(product);
    }

    public Product getProductById(int id) {
        return pr.findById(id).orElse(null);
    }

    public Product updateProduct(int id, Product productDetails) {
        Product product = pr.findById(id).orElse(null);
        if (product != null) {
            product.setName(productDetails.getName());
            product.setCategory(productDetails.getCategory());
            return pr.save(product);
        }
        return null;
    }   

    public void deleteCategory(int id) {
        pr.deleteById(id);
    }
}
