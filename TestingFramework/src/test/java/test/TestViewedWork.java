package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.ProductPage;
import page.ViewedPage;
import service.TestDataReader;

public class TestViewedWork  extends CommonConditions {
    private static final String PRODUCT_LINK_PROPERTY = "testdata.product.link";

    @Test
    public void testChangeOfCounterAfterAdding() {
        int expectedCount = 1;
        int viewedCount = new ProductPage(driver, TestDataReader.getTestData(PRODUCT_LINK_PROPERTY))
                .openPage()
                .getViewedItemsCount();
        Assert.assertEquals(expectedCount, viewedCount);
    }

    @Test
    public void testPresenceAfterViewing() {
        String expected = new ProductPage(driver, TestDataReader.getTestData(PRODUCT_LINK_PROPERTY))
                .openPage()
                .getProductName();
        String actual = new ViewedPage(driver)
                .openPage()
                .getFirstItemName();
        Assert.assertEquals(expected, actual);
    }

}
