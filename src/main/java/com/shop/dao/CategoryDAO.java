package com.shop.dao;

import com.shop.model.Category;
import com.shop.model.Product;

import java.util.List;

/**
 * This interface keep the domain model(Category) completely decoupled from the persistence layer
 * Contain HTTP methods that must be implemented by CategoryDAOImpl class
 */
public interface CategoryDAO {

    Category addCategory(Category category);

    void updateCategory(Category category);

    List<Category> listCategory();

    Category getCategoryById(int id);

    List<Product> getProductsByCategoryId(int id);

    void removeCategory(int id);
}
