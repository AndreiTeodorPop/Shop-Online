package com.shop.dto;

/**
 * Shows only a part of specifications of a category object
 */
public class CategoryDTO {

    public final Integer id;
    public final String name;

    public CategoryDTO(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}