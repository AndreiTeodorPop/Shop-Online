package com.shop.service;

import com.shop.model.Product;

import java.util.List;

/**
 * Provide logic to operate on the data sent to and from the DAO and the client
 */
public interface ProductService {

    void addProduct(Product product);

    void updateProduct(Product product);

    List<Product> listProducts();

    Product getProductById(int id);

    void removeProduct(int id);

}
