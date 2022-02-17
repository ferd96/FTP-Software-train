package com.fpt.api;



import com.fpt.entity.Products;
import com.fpt.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // dành cho api
@RequestMapping("/api/product")
public class ProductApi {
    @Autowired
    private ProductsService productsService;
    @GetMapping
    public ResponseEntity<?> doGetAll(){
        List<Products> productsList = productsService.findAll();

        if ( productsList.isEmpty()){
            return (ResponseEntity<?>) ResponseEntity.notFound();
        }
        return  ResponseEntity.ok(productsList);
    }
}
