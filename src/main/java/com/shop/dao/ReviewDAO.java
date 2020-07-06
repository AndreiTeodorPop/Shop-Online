package com.shop.dao;

import com.shop.model.Review;

import java.util.List;

/**
 * This interface contain HTTP methods that must be implemented by ReviewDAOImpl class
 */
public interface ReviewDAO {

    void addReview(Review review);

    void updateReview(Review review);

    List<Review> listReviews();

    Review getReviewById(int id);

    void removeReview(int id);
}
