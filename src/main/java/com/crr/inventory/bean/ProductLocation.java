package com.crr.inventory.bean;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "locations")
public class ProductLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @ManyToMany(mappedBy = "locations")
    private List<Product> products;

    public ProductLocation() {
    }

    public ProductLocation(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public ProductLocation(long id, String name, List<Product> products) {
        this.id = id;
        this.name = name;
        this.products = products;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
