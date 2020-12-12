package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.ProductPage;
import service.TestDataReader;

public class TestAddToDesired extends CommonConditions {

    private static final String PRODUCT_LINK_PROPERTY = "testdata.product.link";

    @Test
    public void testPresenceAfterAddingToDesired() {
        ProductPage productPage = new ProductPage(driver, TestDataReader.getTestData(PRODUCT_LINK_PROPERTY));
        String expected = productPage.openPage().getProductName();
        String firstDesiredElement = productPage
                .addItemToDesired()
                .openFavouritesPage()
                .getFirstItemName();
        Assert.assertEquals(expected, firstDesiredElement);
    }

    @Test
    public void testChangeOfCounterAfterAdding() {
        int favouriteCount = new ProductPage(driver, TestDataReader.getTestData(PRODUCT_LINK_PROPERTY))
                .openPage()
                .addItemToDesired()
                .getFavouriteItemsCount();
        Assert.assertEquals(1, favouriteCount);
    }
}
