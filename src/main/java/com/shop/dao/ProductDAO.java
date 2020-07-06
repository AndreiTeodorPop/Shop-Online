package com.shop.dao;

import com.shop.model.Product;

import java.util.List;

/**
 * This interface contain HTTP methods that must be implemented by ProductDAOImpl class
 */
public interface ProductDAO {

    Product addProduct(Product product);

    void updateProduct(Product product);

    List<Product> listProducts();

    Product getProductById(int id);

    void removeProduct(int id);
}
