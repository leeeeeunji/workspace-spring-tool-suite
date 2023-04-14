package com.springboot.security.service;

import com.springboot.security.data.dto.ProductDto;
import com.springboot.security.data.dto.ProductResponseDto;

import java.util.List;

public interface ProductService {

	ProductResponseDto getProduct(Long number);

	List<ProductResponseDto> getProductList();

	ProductResponseDto saveProduct(ProductDto productDto);

	ProductResponseDto changeProductName(Long number, String name) throws Exception;

	void deleteProduct(Long number) throws Exception;

}