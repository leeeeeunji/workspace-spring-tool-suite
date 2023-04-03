package com.itwill.jpa.dao;

import java.util.List;

import com.itwill.jpa.dto.ProductResponseDto;
import com.itwill.jpa.entity.Product;


public interface ProductDAO {

    Product insertProduct(Product product);

    Product selectProduct(Long number);

    Product updateProductName(Long number, String name) throws Exception;

    void deleteProduct(Long number) throws Exception;
    
    List<Product> selectList();

}
