package com.itwill.jpa.service;


import java.util.List;

import com.itwill.jpa.dto.ProductDto;
import com.itwill.jpa.dto.ProductResponseDto;

public interface ProductService {

    ProductResponseDto getProduct(Long number);

    ProductResponseDto saveProduct(ProductDto productDto);

    ProductResponseDto changeProductName(Long number, String name) throws Exception;

    void deleteProduct(Long number) throws Exception;
    
    List<ProductResponseDto> products();
}