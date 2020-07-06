package com.shop.service;

import com.shop.model.Category;
import com.shop.model.Product;

import java.util.List;

/**
 * Provide logic to operate on the data sent to and from the DAO and the client
 */
public interface CategoryService {

    void addCategory(Category category);

    void updateCategory(Category category);

    List<Category> listCategory();

    Category getCategoryById(int id);

    List<Product> getProductsByCategoryId(int id);

    void removeCategory(int id);

}
