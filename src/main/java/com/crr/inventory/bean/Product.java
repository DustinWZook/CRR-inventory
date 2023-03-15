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
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "product_location",
            joinColumns = {@JoinColumn(name = "product_id")},
            inverseJoinColumns = {@JoinColumn(name = "location_id")}
    )
    private List<ProductLocation> locations;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "product_category",
            joinColumns = {@JoinColumn(name = "product_id")},
            inverseJoinColumns = {@JoinColumn(name = "category_id")}
    )
    private List<ProductCategory> categories;


    public Product() {
    }

    public Product(Long id, String productName, String brandName, String description, double wholesalePrice, double storePrice, int quantity, List<ProductLocation> locations, List<ProductCategory> categories) {
        this.id = id;
        this.productName = productName;
        this.brandName = brandName;
        this.description = description;
        this.wholesalePrice = wholesalePrice;
        this.storePrice = storePrice;
        this.quantity = quantity;
        this.locations = locations;
        this.categories = categories;
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

    public List<ProductCategory> getCategories() {
        return categories;
    }

    public void setCategories(List<ProductCategory> categories) {
        this.categories = categories;
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

    public List<ProductLocation> getLocations() {
        return locations;
    }

    public void setLocations(List<ProductLocation> locations) {
        this.locations = locations;
    }
}
