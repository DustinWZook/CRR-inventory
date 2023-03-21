package com.crr.inventory.repositories;

import com.crr.inventory.bean.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {


}
