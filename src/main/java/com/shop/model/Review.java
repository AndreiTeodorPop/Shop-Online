package com.shop.model;

import javax.persistence.*;

/**
 * The mapping for review table stored in a database
 * Refers to a review table from an existing database
 */
@Entity
@Table(name = "review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "rating")
    private int rating;

    @Column(name = "comment")
    private String comment;

    /**
     * Many instances of this entry are mapped to one instance of another entity
     * A review will be assigned to product entry from the related table
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product")
    private Product product;

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setProductEntity(Product product) {
        this.product = product;
    }

    public int getId() {
        return id;
    }

    public int getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }

    public Product getProduct() {
        return product;
    }
}
