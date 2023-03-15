package com.crr.inventory.controllers;

import com.crr.inventory.bean.*;
import com.crr.inventory.repositories.*;
import com.crr.inventory.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {
    private final ProductRepository productDao;

    private final ProductCategoryController productCategoryDao;

    private final ProductLocationController productLocationDao;

@Autowired
    public ProductController(ProductRepository productDao, @Lazy ProductCategoryController productCategoryDao,@Lazy ProductLocationController productLocationDao) {
        this.productDao = productDao;
        this.productCategoryDao = productCategoryDao;
        this.productLocationDao = productLocationDao;
    }

    @GetMapping("/index")
    public String index(){
    return "index";
    }
}
