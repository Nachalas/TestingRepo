package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.CartPage;
import page.ProductPage;
import service.TestDataReader;

public class TestAddToCart extends CommonConditions {

    private static final String PRODUCT_LINK_PROPERTY = "testdata.product.link";

    @Test
    public void testPresenceAfterAddingToCart() {
        String expected = new ProductPage(driver, TestDataReader.getTestData(PRODUCT_LINK_PROPERTY))
                .openPage()
                .addItemToCart()
                .getProductName();
        String actual = new CartPage(driver).openPage().getFirstItemName();
        Assert.assertEquals(expected, actual);
    }
}
