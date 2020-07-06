package com.shop.dao.impl;

import com.shop.dao.ReviewDAO;
import com.shop.model.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * This class implements all the functionality for fetching, updating and removing review objects
 */
public class ReviewDAOImpl implements ReviewDAO {

    private static final Logger logger = LoggerFactory.getLogger(ReviewDAOImpl.class);

    /**
     * A configuration object from SessionFactory interface which contain all BD related property
     */
    private SessionFactory sessionFactory;

    /**
     *Add a new review object into database
     * @param review the type of object which will be created
     * @return a new object which will be inserted in database
     */
    public void addReview(Review review) {
        this.sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(review);
        logger.info("Review saved successfully, Review Details=" + review);
        transaction.commit();
        session.close();
        sessionFactory.close();
    }

    /**
     * Update an existing entry on database
     * @param review the type of object which will be updated
     */
    public void updateReview(Review review) {
        this.sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(review);
        logger.info("Review updated successfully, Review Details=" + review);
        transaction.commit();
        session.close();
        sessionFactory.close();
    }

    /**
     * Displays a list of review items from a that table
     * @return a list of review objects
     */
    @SuppressWarnings("unchecked")
    public List<Review> listReviews() {
        this.sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Review> reviewList = session.createQuery("from Review ").list();
        for(Review r : reviewList){
            logger.info("Review List:" + r);
        }
        transaction.commit();
        session.close();
        sessionFactory.close();
        return reviewList;
    }

    /**
     *Display the review name based of id parameter
     * @param id unique value of a review object
     * @return information about a review object
     */
    public Review getReviewById(int id) {
        this.sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Review review;
        Query query = session.createQuery("from Review WHERE id=' " + id + "'");
        review = (Review) query.getSingleResult();
        logger.info("Review loaded successfully, Review details= " + review);
        transaction.commit();
        session.close();
        sessionFactory.close();
        return review;
    }

    /**
     *Delete a review entry from a database based on id parameter
     * @param id unique value of a review object
     */
    public void removeReview(int id) {
        this.sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Review review = session.load(Review.class, id);
        if(null != review){
            session.delete(review);
        }
        logger.info("Review deleted successfully, review details= " + review);
        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
