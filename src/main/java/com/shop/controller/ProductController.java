package com.shop.controller;

import com.shop.model.Product;
import com.shop.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

/**
 * This class gets processed data from the Product class
 * Advances that data to the View for rendering
 */
@Controller
public class ProductController {

    public static final String PRODUCT = "product";
    public static final String LIST_OF_PRODUCTS = "listProducts";
    public static final String PRODUCTS = "products";
    public static final String PRODUCT_ID = "product-id";
    /**
     * Injected into this class
     * Used to access DAO layer
     */
    @Resource
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /**
     *Selects the categories view to render by returning a list of products with simple information
     *
     * @param model is used for adding attributes of a specific class for visualization using jsp
     * @return a String used for mapping a web page, a jsp file with the same name
     * @see <a href="http://localhost:9001/shop/products">Products</a>
     */
    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String listProducts(Model model){
        model.addAttribute(PRODUCT, new Product());
        model.addAttribute(LIST_OF_PRODUCTS, this.productService.listProducts());
        return PRODUCTS;
    }

    /**
     * Selects the product view to render by returning a product detailed information with a specific id
     *
     * @param id the product id to be displayed
     * @param model is used for adding attributes of a specific class for visualization using jsp
     * @return a String used for mapping a web page, a jsp file with the same name
     * @see <a href="http://localhost:9001/shop/category/1">Category with id 1</a>
     */
    @RequestMapping(value= "/product/{product-id}")
    public String getProduct(@PathVariable(PRODUCT_ID) int id, Model model) {
        Product product = productService.getProductById(id);
        model.addAttribute(PRODUCT, product);
        return PRODUCT;
    }
}

