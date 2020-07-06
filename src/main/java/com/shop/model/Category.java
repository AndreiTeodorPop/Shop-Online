package com.shop.model;

import javax.persistence.*;
import java.util.List;

/**
 * The mapping for category table stored in a database
 * Refers to a category table from an existing database
 */
@Entity
@Table(name = "category")
public class Category {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    /**
     * This row of the table is mapped to multiple rows in another table
     * One category can have multiple products
     */
    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
    private List<Product> productList;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProductList() {
        return productList;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", category='" + name + '\'' +
                '}';
    }
}
