package com.shop.model;

import javax.persistence.*;
import java.util.List;

/**
 * The mapping for product table stored in a database
 * Refers to a product table from an existing database
 */
@Entity
@Table(name = "product")
public class Product {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Double price;

    @Column(name = "detailed_characteristics")
    private String detailedCharacteristics;

    /**
     * This row of the table is mapped to multiple rows in another table
     * One product can have multiple reviews
     */
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Review> reviewList;

    /**
     * Many instances of this entry are mapped to one instance of another entity
     * A product will be assigned to category entry from the related table
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category")
    private Category category;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDetailedCharacteristics() {
        return detailedCharacteristics;
    }

    public void setDetailedCharacteristics(String detailedCharacteristics) {
        this.detailedCharacteristics = detailedCharacteristics;
    }

    public List<Review> getReviewList() {
        return reviewList;
    }

    public void setReviewList(List<Review> reviewList) {
        this.reviewList = reviewList;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
