package com.fpt.service.impl;

import com.fpt.entity.Products;
import com.fpt.repository.ProductsRepo;
import com.fpt.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsServiceImpl implements ProductsService {
    @Autowired
    private ProductsRepo repo ;
    @Override
    public List<Products> findAll() {
        return repo.findByIsDeleted(false);
    }
}
