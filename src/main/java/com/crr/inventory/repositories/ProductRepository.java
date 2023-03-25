package com.crr.inventory.repositories;

import com.crr.inventory.bean.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    public static double sumOfWholesalePrice(double wholesalePrice, int quantity){
        double sum = wholesalePrice * quantity;
        return  sum;
    }

    public static double sumOfStorePrice(double storePrice, int quantity){
        double sum = storePrice * quantity;
        return  sum;
    }

    Product deleteProductById(long id);

}
