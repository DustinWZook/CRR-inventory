package com.crr.inventory.controllers;

import com.crr.inventory.bean.*;
import com.crr.inventory.repositories.ProductRepository;
import com.crr.inventory.services.ProductExcelExporter;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.xml.stream.Location;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {
    private final ProductRepository productDao;


@Autowired
    public ProductController(ProductRepository productDao) {
        this.productDao = productDao;
    }


    @GetMapping("/products/export/excel")
    public void exportToExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=products_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);

        List<Product> listProducts = productDao.findAll();

        ProductExcelExporter excelExporter = new ProductExcelExporter(listProducts);

        excelExporter.export(response);
    }


    @GetMapping("/")
    public String showProducts(Model model) {

        model.addAttribute("products", productDao.findAll());
        return "index";
    }


    @GetMapping("/addProduct")
    public String addProduct(){
    return "addProduct";
    }

    @PostMapping("/addProduct")
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
        double totalStorePrice = ProductRepository.sumOfStorePrice(productStorePrice, productQuantity);
        double totalWholesalePrice = ProductRepository.sumOfWholesalePrice(productWholesale, productQuantity);
        product.setTotalStorePrice(totalStorePrice);
        product.setTotalWholesalePrice(totalWholesalePrice);

        productDao.save(product);

        return "redirect:/";
    }

    @PostMapping("products/delete")
    public String deleteProduct(@RequestParam(name = "id") long id){

        Product product = productDao.getReferenceById(id);
        productDao.delete(product);
//        System.out.println("testing delete method");
//        System.out.println(product.getProductName());
    return "redirect:/";
    }

    @GetMapping("products/edit/{id}")
    public String editProduct(@PathVariable String id, Model model){
    model.addAttribute("id", id);

    Optional<Product> product = productDao.findById(Long.valueOf(id));
    model.addAttribute("product", product);


    return "edit";
    }

    @PostMapping("products/edit")
    public String edit(@RequestParam(name = "id", required = false) long id, Model model) {
        model.addAttribute("id", id);

        Optional<Product> product = productDao.findById(Long.valueOf(id));
        model.addAttribute("product", product);
        return "edit";
    }

    @PostMapping("products/editProduct")
    public String editProduct(){


        return "redirect:/";
    }

}
