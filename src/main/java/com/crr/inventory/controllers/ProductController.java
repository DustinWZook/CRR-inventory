package com.crr.inventory.controllers;

import com.crr.inventory.bean.*;
import com.crr.inventory.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductController {
    private final ProductRepository productDao;


@Autowired
    public ProductController(ProductRepository productDao) {
        this.productDao = productDao;
    }

    @GetMapping("/")
    public String showProducts(Model model) {

        model.addAttribute("products", productDao.findAll());
        return "index";
    }

//    @GetMapping("/index")
//    public String index(){
//    return "index";
//    }

    @PostMapping("/createProduct")
    public String createProduct(@ModelAttribute Product product,@RequestParam(name = "newProductName") String productName,@RequestParam(name = "newProductBrand") String productBrand,@RequestParam(name = "newProductDescription") String productDescription,@RequestParam(name = "newProductQuantity") int productQuantity,@RequestParam(name = "newProductWholesalePrice") double productWholesale,@RequestParam(name = "newProductStorePrice") double productStorePrice, @RequestParam(name = "newProductCategory") String productCategory, @RequestParam(name = "newProductLocation") String productLocation) {
        // save the ad...
        // redirect to to the index with all the ads
        product.setProductName(productName);
        product.setBrandName(productBrand);
        product.setDescription(productDescription);
        product.setQuantity(productQuantity);
        product.setWholesalePrice(productWholesale);
        product.setStorePrice(productStorePrice);
        product.setProductCategory(productCategory);
        product.setProductLocation(productLocation);


        productDao.save(product);

        return "redirect:/";
    }

}
