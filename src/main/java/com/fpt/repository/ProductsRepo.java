package com.fpt.repository;

import com.fpt.entity.Products;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductsRepo extends JpaRepository<Products, Long> {
    List<Products> findByIsDeletedAndQuantityGreaterThan(Boolean isDeleted, Integer quantity); //Chữ IsDeleted phải viết Hoa , số lượng lớn hơn 0
    // SELETECT * FROM products where isDeleted= isDeleted;

    @Query(value="SELECT*FROM products Where isDeleted = 1 AND  quantity >0",nativeQuery = true)
    List<Products>findAllAvailable();

}
