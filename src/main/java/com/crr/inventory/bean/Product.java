package com.crr.inventory.bean;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String productName;

    @Column
    private String brandName;

    @Column
    private String description;

    @Column
    private double wholesalePrice;

    @Column
    private double storePrice;

    @Column
    private int quantity;

    @Column
    private String productLocation;

    @Column
    private String productCategory;

    public Product() {
    }

    public Product(Long id, String productName, String brandName, String description, double wholesalePrice, double storePrice, int quantity, String productLocation, String productCategory) {
        this.id = id;
        this.productName = productName;
        this.brandName = brandName;
        this.description = description;
        this.wholesalePrice = wholesalePrice;
        this.storePrice = storePrice;
        this.quantity = quantity;
        this.productLocation = productLocation;
        this.productCategory = productCategory;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getStorePrice() {
        return storePrice;
    }

    public void setStorePrice(double storePrice) {
        this.storePrice = storePrice;
    }


    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public double getWholesalePrice() {
        return wholesalePrice;
    }

    public void setWholesalePrice(double wholesalePrice) {
        this.wholesalePrice = wholesalePrice;
    }

    public String getProductLocation() {
        return productLocation;
    }

    public void setProductLocation(String productLocation) {
        this.productLocation = productLocation;

    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }
}
