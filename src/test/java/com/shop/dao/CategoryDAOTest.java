package com.shop.dao;

import com.shop.dao.impl.CategoryDAOImpl;
import com.shop.model.Category;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;

@SpringBootTest
@Transactional
public class CategoryDAOTest {

    CategoryDAOImpl categoryDAO = new CategoryDAOImpl();

    @Test
    public void addCategory() {
        Category input = createDummy();
        Category actual = categoryDAO.addCategory(input);

        Assertions.assertEquals(input.getName(), actual.getName());
        Assertions.assertNotEquals(0, actual.getId());
        Assertions.assertEquals(input.getId(), actual.getId());

        categoryDAO.removeCategory(actual.getId());
    }

    private Category createDummy() {
        Category category = new Category();
        category.setName("category name");

        return category;
    }

    @Test
    public void getCategory() {
        Category input = createDummy();
        Category expected = categoryDAO.addCategory(input);
        Category actual = categoryDAO.getCategoryById(expected.getId());

        Assertions.assertEquals(expected.getId(), actual.getId());
        Assertions.assertEquals(expected.getName(), actual.getName());

        Assertions.assertNotEquals(0, categoryDAO.listCategory().size());

        categoryDAO.removeCategory(actual.getId());
    }

    @Test
    public void updateCategory() {
        Category input = createDummy();
        Category expected = categoryDAO.addCategory(input);
        expected.setName("Another name");
        categoryDAO.updateCategory(expected);
        Category actual = categoryDAO.getCategoryById(expected.getId());

        Assertions.assertEquals(expected.getName(), actual.getName());

        categoryDAO.removeCategory(actual.getId());

    }

    @Test
    public void removeCategory() {
        Category input = createDummy();
        Category expected = categoryDAO.addCategory(input);
        categoryDAO.removeCategory(expected.getId());

        Assertions.assertThrows(NoResultException.class, () -> categoryDAO.getCategoryById(expected.getId()));

    }
}
