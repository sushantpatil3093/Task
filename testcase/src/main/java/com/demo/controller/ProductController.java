package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import com.demo.entity.Product;
import com.demo.repository.ProductRepo;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductRepo pr;

   
    @GetMapping
    public List<Product> getProducts(@RequestParam(defaultValue = "0") int page) {
        return pr.findAll(PageRequest.of(page, 10)).getContent();
    }

 
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return pr.save(product);
    }

 
    @GetMapping("/{di}")
    public Optional<Product> getProductById(@PathVariable int id) {
        return pr.findById(id);
    }

   
    @PutMapping("/{di}")
    public Product updateProduct(@PathVariable int id, @RequestBody Product productDetails) {
        Product product = pr.findById(id).orElseThrow();
        product.setName(productDetails.getName());
        product.setPrice(productDetails.getPrice());
        return pr.save(product);
    }

    @DeleteMapping("/{di}")
    public void deleteProduct(@PathVariable int id) {
        pr.deleteById(id);
    }
}
