package com.rocio.springcloud.msvc.products.services;

import java.util.List;
import java.util.Optional;

import com.rocio.springcloud.msvc.products.entities.Product;

public interface ProductService {

    List <Product> findAll();
//Devuelve el resultado de la consulta impidiendo que devuelva un null
Optional<Product> findById (Long id);

}
