package com.crr.inventory.repositories;

import com.crr.inventory.bean.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {


}
