package com.itwill.jpa.dao.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.itwill.jpa.dao.ProductDAO;
import com.itwill.jpa.dto.ProductResponseDto;
import com.itwill.jpa.entity.Product;
import com.itwill.jpa.repository.ProductRepository;

@Repository
public class ProductDAOImpl implements ProductDAO {

    private ProductRepository productRepository;
    
    @Override
    public List<Product> selectList() {
    	// TODO Auto-generated method stub
    	return productRepository.findAll();
    }

    @Autowired
    public ProductDAOImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

  
    @Override
    public Product insertProduct(Product product) {
        Product savedProduct = productRepository.save(product);

        return savedProduct;
    }


    @Override
    public Product selectProduct(Long number) {
        Product selectedProduct = productRepository.getById(number);

        return selectedProduct;
    }

 
    @Override
    public Product updateProductName(Long number, String name) throws Exception {
        Optional<Product> selectedProduct = productRepository.findById(number);

        Product updatedProduct;
        if (selectedProduct.isPresent()) {
            Product product = selectedProduct.get();

            product.setName(name);
            product.setUpdatedAt(LocalDateTime.now());

            updatedProduct = productRepository.save(product);
        } else {
            throw new Exception();
        }

        return updatedProduct;
    }

  
    @Override
    public void deleteProduct(Long number) throws Exception {
        Optional<Product> selectedProduct = productRepository.findById(number);

        if (selectedProduct.isPresent()) {
            Product product = selectedProduct.get();

            productRepository.delete(product);
        } else {
            throw new Exception();
        }
    }


}