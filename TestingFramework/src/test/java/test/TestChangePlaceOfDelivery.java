package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.ProductPage;
import service.TestDataReader;

public class TestChangePlaceOfDelivery extends CommonConditions {
    private static final String FIRST_PRODUCT_LINK_PROPERTY = "testdata.product.link";
    private static final String SECOND_PRODUCT_LINK_PROPERTY = "testdata.product.link_second";
    private static final String PLACE_OF_DELIVERY_PROPERTY = "testdata.place.delivery";

    @Test
    public void testChangeOfPlaceOfDeliveryAtProductPage() {
        String expected = TestDataReader.getTestData(PLACE_OF_DELIVERY_PROPERTY);
        String actual = new ProductPage(driver, TestDataReader.getTestData(FIRST_PRODUCT_LINK_PROPERTY))
                .openPage()
                .changePlaceOfDelivery(TestDataReader.getTestData(PLACE_OF_DELIVERY_PROPERTY))
                .getPlaceOfDelivery();
        Assert.assertTrue(actual.toLowerCase().contains(expected.toLowerCase()));
    }

    @Test
    public void testPlaceOfDeliveryPermanence() {
        String expected = TestDataReader.getTestData(PLACE_OF_DELIVERY_PROPERTY);
        new ProductPage(driver, TestDataReader.getTestData(FIRST_PRODUCT_LINK_PROPERTY))
                .openPage()
                .changePlaceOfDelivery(TestDataReader.getTestData(PLACE_OF_DELIVERY_PROPERTY));
        String actual = new ProductPage(driver, TestDataReader.getTestData(SECOND_PRODUCT_LINK_PROPERTY))
                .openPage()
                .getPlaceOfDelivery();
        Assert.assertTrue(actual.toLowerCase().contains(expected.toLowerCase()));
    }

}
