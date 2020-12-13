package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.ItemComparisonPage;
import page.ProductPage;
import service.TestDataReader;

import java.util.List;

public class TestAddToComparison extends CommonConditions {
    private static final String PRODUCT_LINK_PROPERTY = "testdata.product.link_second";

    @Test
    public void testPresenceOfItemAfterAdding() {
        String expectedItemName = new ProductPage(driver, TestDataReader.getTestData(PRODUCT_LINK_PROPERTY))
                .openPage()
                .addItemToComparison()
                .getProductName();
        String actualItemName = new ItemComparisonPage(driver)
                .openPage()
                .getFirstItemName();
        Assert.assertEquals(expectedItemName, actualItemName);
    }

    @Test
    public void testPresenceOfCharacteristicsNamesAfterAddingToComparison() {
        ProductPage productPage = new ProductPage(driver, TestDataReader.getTestData(PRODUCT_LINK_PROPERTY))
                .openPage()
                .addItemToComparison();
        List<String> expectedCharNames = productPage
                .getItemCharacteristicsNames();
        List<String> actualCharNames = new ItemComparisonPage(driver)
                .openPage()
                .getItemCharacteristicsNames();
        Assert.assertTrue(actualCharNames.containsAll(expectedCharNames));
    }

    @Test
    public void testPresenceOfCharacteristicsAfterAddingToComparison() {
        ProductPage productPage = new ProductPage(driver, TestDataReader.getTestData(PRODUCT_LINK_PROPERTY))
                .openPage()
                .addItemToComparison();
        List<String> expectedCharacteristics = productPage
                .getItemCharacteristics();
        List<String> actualCharacteristics = new ItemComparisonPage(driver)
                .openPage()
                .getItemCharacteristics();
        Assert.assertTrue(actualCharacteristics.containsAll(expectedCharacteristics));
    }
}
