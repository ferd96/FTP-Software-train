package com.fpt.repository;

import com.fpt.entity.Products;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductsRepo extends JpaRepository<Products, Long> {
    List<Products> findByIsDeleted(Boolean isDeleted); //Chữ IsDeleted phải viết Hoaaa
    // SELETECT * FROM products where isDeleted= isDeleted;

    @Query(value="SELECT*FROM products Where isDeleted = 1",nativeQuery = true)
    List<Products>findAllAvailable();


}
