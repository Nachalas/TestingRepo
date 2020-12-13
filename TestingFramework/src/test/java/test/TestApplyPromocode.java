package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.CartPage;
import page.ProductPage;
import service.TestDataReader;

import static util.StringUtils.parsePrice;

public class TestApplyPromocode extends CommonConditions {
    private static final String PROMO_ITEM_PROPERTY = "testdata.promo.item.link";
    private static final String PROMO_PROMOCODE_PROPERTY = "testdata.promo.promocode";
    private static final String PROMO_PROMOCODE_PERCENT_PROPERTY = "testdata.promo.percent";

    @Test
    public void testApplyPromocode() {
        new ProductPage(driver, TestDataReader.getTestData(PROMO_ITEM_PROPERTY))
                .openPage()
                .addItemToCart();
        CartPage cartPage = new CartPage(driver).openPage();
        String firstPrice = cartPage.getFinalPrice();
        String secondPrice = cartPage
                .applyPromocode(TestDataReader.getTestData(PROMO_PROMOCODE_PROPERTY))
                .getFinalPrice();
        double expected = parsePrice(firstPrice) - parsePrice(firstPrice) * Double.parseDouble(TestDataReader.getTestData(PROMO_PROMOCODE_PERCENT_PROPERTY)) / 100;
        double actual = parsePrice(secondPrice);
        Assert.assertEquals(actual, expected);
    }

}
