package com.shop.dao.impl;

import com.shop.dao.ProductDAO;
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
 * This class implements all the functionality for fetching, updating and removing Product objects
 */
public class ProductDAOImpl implements ProductDAO {

    private static final Logger logger = LoggerFactory.getLogger(ProductDAOImpl.class);

    /**
     * A configuration object from SessionFactory interface which contain all BD related property
     */
    private SessionFactory sessionFactory;

    public ProductDAOImpl() {}

    public ProductDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     *Add a new product object into database
     * @param product the type of object which will be created
     * @return a new object which will be inserted in database
     */
    public Product addProduct(Product product) {
        this.sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(product);
        logger.info("Product saved successfully, Product Details=" + product);
        transaction.commit();
        session.close();
        sessionFactory.close();
        return product;
    }

    /**
     * Update an existing entry on database
     * @param product the type of object which will be updated
     */
    public void updateProduct(Product product) {
        this.sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(product);
        logger.info("Product updated successfully, Product Details=" + product);
        transaction.commit();
        session.close();
        sessionFactory.close();
    }

    /**
     * Displays a list of product items from a that table
     * @return a list of product objects
     */
    @SuppressWarnings("unchecked")
    public List<Product> listProducts() {
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

    /**
     *Display the product name based of id parameter
     * @param id unique value of a product object
     * @return information about a product object
     */
    public Product getProductById(int id) {
        this.sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Product product;
        Query query = session.createQuery("from Product WHERE id=' " + id + "'");
        product = (Product) query.getSingleResult();
        logger.info("Product loaded successfully, Product details= " + product);
        transaction.commit();
        session.close();
        sessionFactory.close();
        return product;
    }

    /**
     *Delete a product entry from a database based on id parameter
     * @param id unique value of a product object
     */
    public void removeProduct(int id) {
        this.sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Product product = session.load(Product.class, new Integer(id));
        if(null != product){
            session.delete(product);
        }
        logger.info("Product deleted successfully, product details= " + product);
        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
