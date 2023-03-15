package com.crr.inventory.controllers;

import com.crr.inventory.bean.*;
import com.crr.inventory.repositories.*;
import com.crr.inventory.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductCategoryController {
    private final ProductRepository productDao;

    private final ProductCategoryRepository productCategoryDao;

    private final ProductLocationRepository productLocationDao;

    @Autowired
    public ProductCategoryController(ProductRepository productDao,ProductCategoryRepository productCategoryDao,ProductLocationRepository productLocationDao) {
        this.productDao = productDao;
        this.productCategoryDao = productCategoryDao;
        this.productLocationDao = productLocationDao;
    }

    @PostMapping("/createCategory")
    public String createLocation(@ModelAttribute ProductCategory productCategory, @RequestParam(name = "newCategory") String location) {
        // save the ad...
        // redirect to to the index with all the ads
        productCategory.setName(location);
        productCategoryDao.save(productCategory);

        return "redirect:/";
    }
}
