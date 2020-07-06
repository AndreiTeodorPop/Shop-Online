package com.shop.service.impl;

import com.shop.dao.CategoryDAO;
import com.shop.dao.impl.CategoryDAOImpl;
import com.shop.model.Category;
import com.shop.model.Product;
import com.shop.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Used to gain access to the DB from the client
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    /**
     * Injected in this class
     */
    private CategoryDAO categoryDAO;

    public CategoryServiceImpl(CategoryDAOImpl categoryDAO) {
        this.categoryDAO = categoryDAO;
    }


    /**
     * Call the DAO layer in order to create a new category type object into that table
     * @param category the type of object which will be created
     */
    @Override
    public void addCategory(Category category) {
        this.categoryDAO.addCategory(category);
    }

    /**
     * Call the DAO layer in order to update details about a category type object to assigned table
     */
    @Override
    public void updateCategory(Category category) {
        this.categoryDAO.updateCategory(category);
    }

    /**
     * Call the DAO layer in order to display a list of category entries from database table
     * @return  a list of category objects
     */
    @Override
    public List<Category> listCategory() {
        return this.categoryDAO.listCategory();
    }

    /**
     * Call the DAO layer in order to get information about a category type object from DB
     * @param id unique value of a category object used for identification
     * @return a new category object
     */
    @Override
    public Category getCategoryById(int id) {
        return this.categoryDAO.getCategoryById(id);
    }

    /**
     * Call the DAO layer in order to get information about a list of products belonging to a category
     * @param id unique value of a category object used for identification
     * @return a list of product objects assigned to a category id
     */
    @Override
    public List<Product> getProductsByCategoryId(int id){
        Category category = categoryDAO.getCategoryById(id);
        List<Product> result = category.getProductList();
        return result;
    }

    /**
     * Call the DAO layer in order to remove an category object based on his id
     * @param id unique value of a category object used for identification
     */
    @Override
    public void removeCategory(int id) {
        this.categoryDAO.removeCategory(id);
    }

}