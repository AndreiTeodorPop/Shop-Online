package com.shop.service;

import com.shop.dao.impl.CategoryDAOImpl;
import com.shop.model.Category;
import com.shop.service.impl.CategoryServiceImpl;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import java.util.List;

@SpringBootTest
@Transactional
public class CategoryServiceTest {

    private CategoryDAOImpl categoryDao = new CategoryDAOImpl();
    private CategoryServiceImpl categoryService = new CategoryServiceImpl(categoryDao);


    @Test
    public void getAllCategory() {
        List<Category> actual = categoryService.listCategory();
        List<Category> expected = categoryDao.listCategory();
        Assertions.assertEquals(expected.size(), actual.size());
        Assertions.assertEquals(expected.get(0).getId(), actual.get(0).getId());
        Assertions.assertEquals(expected.get(0).getName(), actual.get(0).getName());

    }

    @Test
    public void getCategoryById() {
        int input = categoryDao.listCategory().get(0).getId();
        Category actual = categoryService.getCategoryById(input);
        Category expected = categoryDao.getCategoryById(input);
        Assertions.assertEquals(expected.getName(), actual.getName());
        Assertions.assertThrows(NoResultException.class, () -> categoryService.getCategoryById(-123321));
    }
}
