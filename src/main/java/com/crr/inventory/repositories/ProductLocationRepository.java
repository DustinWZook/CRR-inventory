package com.crr.inventory.repositories;

import com.crr.inventory.bean.ProductLocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductLocationRepository extends JpaRepository<ProductLocation, Long> {

}
