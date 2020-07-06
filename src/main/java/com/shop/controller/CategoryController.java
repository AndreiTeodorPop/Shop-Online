package com.shop.controller;

import com.shop.model.Product;
import com.shop.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.List;

/**
 * Advances data from Category class to the View for rendering
 */
@Controller
public class CategoryController {

    public static final String CATEGORIES = "categories";
    public static final String CATEGORY = "category";
    public static final String LIST_OF_CATEGORY = "listCategory";
    public static final String LIST_OF_PRODUCTS = "listProducts";
    public static final String CATEGORY_ID = "category-id";
    /**
     * Injected into this class
     * Used to access DAO layer
     */
    @Resource
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    /**
     * Selects the categories view to render by returning a list of category
     *
     * @param model is used for adding attributes of a specific class for visualization using jsp
     * @return a String used for mapping a web page, a jsp file with the same name
     * @see <a href="http://localhost:9001/shop/categories">Categories</a>
     */
    @RequestMapping(value = "/categories", method = RequestMethod.GET)
    public String listCategories(Model model) {
        model.addAttribute(LIST_OF_CATEGORY, this.categoryService.listCategory());
        return CATEGORIES;
    }

    /**
     * Selects the category view to render by returning a list of products for a category id
     *
     * @param id    the category id to be displayed
     * @param model is used for adding attributes of a specific class for visualization using jsp
     * @return a String used for mapping a web page, a jsp file with the same name
     * @see <a href="http://localhost:9001/shop/category/1">Category with id 1</a>
     */
    @RequestMapping(value = "/category/{category-id}", method = RequestMethod.GET)
    public String getProductsByCategoryId(@PathVariable(CATEGORY_ID) int id, Model model) {
        List<Product> result = categoryService.getProductsByCategoryId(id);
        model.addAttribute(LIST_OF_PRODUCTS, result);
        return CATEGORY;
    }

}