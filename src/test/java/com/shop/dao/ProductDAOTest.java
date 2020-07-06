package com.shop.dao;

import com.shop.dao.impl.CategoryDAOImpl;
import com.shop.dao.impl.ProductDAOImpl;
import com.shop.model.Product;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;

@SpringBootTest
@Transactional
public class ProductDAOTest {

    ProductDAOImpl productDao = new ProductDAOImpl();

    @Test
    public void addProduct() {
        Product input = createDummy();
        Product actual = productDao.addProduct(input);

        Assertions.assertEquals(input.getName(), actual.getName());
        Assertions.assertNotEquals(0, actual.getId());
        Assertions.assertEquals(input.getId(), actual.getId());

        productDao.removeProduct(actual.getId());
    }

    private Product createDummy() {
        Product product = new Product();
        product.setName("product name");
        product.setPrice(5.5);
        product.setDescription("description");
        product.setDetailedCharacteristics("detailed characteristics");
        product.setCategory(new CategoryDAOImpl().getCategoryById(1));
        return product;
    }

    @Test
    public void getProduct() {
        Product input = createDummy();
        Product expected = productDao.addProduct(input);
        Product actual = productDao.getProductById(expected.getId());

        Assertions.assertEquals(expected.getId(), actual.getId());
        Assertions.assertEquals(expected.getName(), actual.getName());

        Assertions.assertNotEquals(0, productDao.listProducts().size());

        productDao.removeProduct(actual.getId());
    }

    @Test
    public void updateProduct() {
        Product input = createDummy();
        Product expected = productDao.addProduct(input);
        expected.setName("Another name");
        productDao.updateProduct(expected);
        Product actual = productDao.getProductById(expected.getId());

        Assertions.assertEquals(expected.getName(), actual.getName());

        productDao.removeProduct(actual.getId());

    }

    @Test
    public void removeProduct() {
        Product input = createDummy();
        Product expected = productDao.addProduct(input);
        productDao.removeProduct(expected.getId());

        Assertions.assertThrows(NoResultException.class, () -> productDao.getProductById(expected.getId()));

    }
}

