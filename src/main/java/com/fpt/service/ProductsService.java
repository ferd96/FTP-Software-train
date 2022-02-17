package com.fpt.service;

import com.fpt.entity.Products;
import org.springframework.stereotype.Service;

import java.util.List;
public interface ProductsService {
    List<Products> findAll();
}
