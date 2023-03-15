package com.crr.inventory.controllers;

import com.crr.inventory.bean.*;
import com.crr.inventory.repositories.*;
import com.crr.inventory.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {
    private final ProductRepository productDao;

    private final ProductCategoryRepository productCategoryDao;

    private final ProductLocationRepository productLocationDao;

@Autowired
    public ProductController(ProductRepository productDao, ProductCategoryRepository productCategoryDao,ProductLocationRepository productLocationDao) {
        this.productDao = productDao;
        this.productCategoryDao = productCategoryDao;
        this.productLocationDao = productLocationDao;
    }

    @GetMapping("/index")
    public String index(){
    return "index";
    }

    @PostMapping("/createProduct")
    public String createProduct(@ModelAttribute Product product,@RequestParam(name = "newProductName") String productName,@RequestParam(name = "newProductBrand") String productBrand,@RequestParam(name = "newProductDescription") String productDescription,@RequestParam(name = "newProductQuantity") int productQuantity,@RequestParam(name = "newProductWholesalePrice") double productWholesale,@RequestParam(name = "newProductStorePrice") double productStorePrice) {
        // save the ad...
        // redirect to to the index with all the ads
        product.setProductName(productName);
        product.setBrandName(productBrand);
        product.setDescription(productDescription);
        product.setQuantity(productQuantity);
        product.setWholesalePrice(productWholesale);
        product.setStorePrice(productStorePrice);


        productDao.save(product);

        return "redirect:/";
    }

}
