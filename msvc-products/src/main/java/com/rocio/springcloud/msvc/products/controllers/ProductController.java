package com.rocio.springcloud.msvc.products.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.rocio.springcloud.msvc.products.entities.Product;
import com.rocio.springcloud.msvc.products.services.ProductService;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class ProductController {
    
    final ProductService service;

    //Alternativa al autowired
    public ProductController (ProductService service){

        this.service =service;
    }

    @GetMapping
    public List<Product> list() {
        return this.service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> details (@PathVariable Long id) {
        Optional<Product> productOptional = service.findById(id); 
        if (productOptional.isPresent()){
            return ResponseEntity.ok(productOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }
    
    

}
