package com.shop.dao.impl;

import com.shop.dao.CategoryDAO;
import com.shop.model.Category;
import com.shop.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * This class implements all the functionality for fetching, updating and removing Category objects
 */
public class CategoryDAOImpl implements CategoryDAO {


    private static final Logger logger = LoggerFactory.getLogger(CategoryDAOImpl.class);

    /**
     * A configuration object from SessionFactory interface which contain all BD related property
     */
    private SessionFactory sessionFactory;

    public CategoryDAOImpl() {}

    public CategoryDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     *Add a new category object into database
     * @param category the type of object which will be created
     * @return a new category object which will be inserted in database
     */
    public Category addCategory(Category category) {
        this.sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(category);
        logger.info("Category saved successfully, Category Details=" + category);
        transaction.commit();
        session.close();
        sessionFactory.close();
        return category;
    }

    /**
     * Update an existing entry on database
     * @param category the type of object which will be updated
     */
    public void updateCategory(Category category) {
        this.sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(category);
        logger.info("Category updated successfully, Category Details=" + category);
        transaction.commit();
        session.close();
        sessionFactory.close();
    }

    /**
     * Displays a list of category items from a that table
     * @return a list of category objects
     */
    @SuppressWarnings("unchecked")
    public List<Category> listCategory() {
        this.sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Category> categoryList = session.createQuery("from Category ").list();
        for(Category c : categoryList){
            logger.info("Category List:" + c);
        }
        transaction.commit();
        session.close();
        sessionFactory.close();
        return categoryList;
    }

    /**
     *Display the category name based of id parameter
     * @param id unique value of a category object
     * @return information about a category object
     */
    public Category getCategoryById(int id) {
        this.sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from Category WHERE id=' " + id + "'");
        Category result = (Category) query.getSingleResult();
        logger.info("Category loaded successfully, Category details= " + result);
        transaction.commit();
        session.close();
        sessionFactory.close();
        return result;
    }

    /**
     *Delete a category entry from a database based on id parameter
     * @param id unique value of a category object
     */
    public void removeCategory(int id) {
        this.sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Category category = session.load(Category.class, id);
        if(null != category){
            session.delete(category);
        }
        logger.info("Category deleted successfully, category details= " + category);
        transaction.commit();
        session.close();
        sessionFactory.close();
    }

    /**
     * Return a list of product objects from a category
     * @param id unique value of a category object
     * @return a list of product objects
     */
    @Override
    public List<Product> getProductsByCategoryId(int id) {
        this.sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Product> productList = session.createQuery("from Product ").list();
        for(Product p : productList){
            logger.info("Product List:" + p);
        }
        transaction.commit();
        session.close();
        sessionFactory.close();
        return productList;
    }
}
