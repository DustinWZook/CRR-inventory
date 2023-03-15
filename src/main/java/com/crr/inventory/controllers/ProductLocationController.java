package com.crr.inventory.controllers;

import com.crr.inventory.bean.*;
import com.crr.inventory.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductLocationController {
    private final ProductRepository productDao;

    private final ProductCategoryRepository productCategoryDao;

    private final ProductLocationRepository productLocationDao;

    @Autowired
    public ProductLocationController(ProductRepository productDao, ProductCategoryRepository productCategoryDao, ProductLocationRepository productLocationDao) {
        this.productDao = productDao;
        this.productCategoryDao = (ProductCategoryRepository) productCategoryDao;
        this.productLocationDao = (ProductLocationRepository) productLocationDao;
    }

//    @GetMapping("/productLocation/create")
//    public String showCreateForm(Model model) {
//        model.addAttribute("productLocation", new ProductLocation());
//        return "/index";
//    }

    @PostMapping("/createLocation")
    public String createLocation(@ModelAttribute ProductLocation productLocation, @RequestParam(name = "newLocation") String location) {
        // save the ad...
        // redirect to to the index with all the ads
        productLocation.setName(location);
        productLocationDao.save(productLocation);

        return "redirect:/";
    }


}
