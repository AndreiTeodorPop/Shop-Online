package com.shop.service.impl;

import com.shop.dao.ProductDAO;
import com.shop.dao.impl.ProductDAOImpl;
import com.shop.model.Product;
import com.shop.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Used to gain access to the DB from the client
 */
@Service
public class ProductServiceImpl implements ProductService {

    /**
     * Injected in this class
     */
    private ProductDAO productDAO;

    public ProductServiceImpl() {}

    public ProductServiceImpl(ProductDAOImpl productDAO) {
        this.productDAO = productDAO;
    }

    /**
     * Call the DAO layer in order to create a new product type object into that table
     * @param product the type of object which will be created
     */
    @Override
    public void addProduct(Product product) {
        this.productDAO.addProduct(product);
    }

    /**
     * Call the DAO layer in order to update details about a product type object to assigned table
     */
    @Override
    public void updateProduct(Product product) {
        this.productDAO.updateProduct(product);
    }

    /**
     * Call the DAO layer in order to display a list of product entries from database table
     * @return  a list of product objects
     */
    @Override
    public List<Product> listProducts() {
        return this.productDAO.listProducts();
    }

    /**
     * Call the DAO layer in order to get information about a product type object from DB
     * @param id unique value of a product object used for identification
     * @return a new product object
     */
    @Override
    public Product getProductById(int id) {
        return this.productDAO.getProductById(id);
    }

    /**
     * Call the DAO layer in order to remove an category object based on his id
     * @param id unique value of a category object used for identification
     */
    @Override
    public void removeProduct(int id) {
        this.productDAO.removeProduct(id);
    }

}
