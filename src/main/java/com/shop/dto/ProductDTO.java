package com.shop.dto;

/**
 * Shows only a part of specifications of a product object
 */
public class ProductDTO {

    public final String name;
    public final String description;
    public final double price;

    public ProductDTO(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}