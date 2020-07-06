package com.shop.service;

import com.shop.dao.impl.ProductDAOImpl;
import com.shop.model.Product;
import com.shop.service.impl.ProductServiceImpl;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import java.util.List;

@SpringBootTest
@Transactional
public class ProductServiceTest {

    private SessionFactory sessionFactory;

    private ProductDAOImpl productDao = new ProductDAOImpl();
    private ProductServiceImpl productService = new ProductServiceImpl(productDao);


    @Test
    public void getAllProducts() {
        List<Product> actual = productService.listProducts();
        List<Product> expected = productDao.listProducts();
        Assertions.assertEquals(expected.size(), actual.size());
        Assertions.assertEquals(expected.get(0).getId(), actual.get(0).getId());
        Assertions.assertEquals(expected.get(0).getName(), actual.get(0).getName());
        Assertions.assertEquals(expected.get(0).getPrice(), actual.get(0).getPrice());
        Assertions.assertEquals(expected.get(0).getDescription(), actual.get(0).getDescription());
    }

    @Test
    public void getProductById() {
        int input = productDao.listProducts().get(0).getId();
        Product actual = productService.getProductById(input);
        Product expected = productDao.getProductById(input);
        Assertions.assertEquals(expected.getName(), actual.getName());
        Assertions.assertEquals(expected.getPrice(), actual.getPrice());
        Assertions.assertEquals(expected.getPrice(), actual.getPrice());
        Assertions.assertEquals(expected.getDescription(), actual.getDescription());
        Assertions.assertEquals(expected.getDetailedCharacteristics(), actual.getDetailedCharacteristics());
        Assertions.assertEquals(expected.getReviewList().size(), actual.getReviewList().size());
        Assertions.assertThrows(NoResultException.class, () -> productService.getProductById(-123321));
    }

}
