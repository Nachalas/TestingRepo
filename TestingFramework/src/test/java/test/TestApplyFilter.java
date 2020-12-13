package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.CatalogPage;
import service.TestDataReader;

public class TestApplyFilter extends CommonConditions {
    private static final String CATALOG_LINK_PROPERTY = "testdata.catalog.link";
    private static final String MANUFACTURER_PROPERTY = "testdata.catalog.manufacturer";

    @Test
    public void testPresenceAfterApplyingFilter() {
        String expected = TestDataReader.getTestData(MANUFACTURER_PROPERTY);
        String actual = new CatalogPage(driver, TestDataReader.getTestData(CATALOG_LINK_PROPERTY))
                .openPage()
                .applyManufacturerFilter(expected)
                .getFirstItemName();
        Assert.assertTrue(actual.toLowerCase().contains(expected.toLowerCase()));
    }
}
