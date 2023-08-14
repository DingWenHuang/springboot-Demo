package com.example.springboot0814training.dao;

import com.example.springboot0814training.dto.ProductRequest;
import com.example.springboot0814training.model.Product;

import java.util.List;

public interface ProductDAO {

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProduct(Integer productId);

    List<Product> getProducts();
}
