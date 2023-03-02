package com.crr.inventory.controllers;

import com.crr.inventory.repositories.ProductRepository;
import org.springframework.stereotype.Controller;

@Controller
public class ProductController {
    private final ProductRepository productDao;

    public ProductController(ProductRepository productDao) {
        this.productDao = productDao;
    }


}
